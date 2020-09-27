package com.github.sources.distributed.idempotent.annotation;

import com.github.sources.distributed.idempotent.comm.RedisToken;
import com.github.sources.distributed.idempotent.domain.ResponseStatus;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Component
@Aspect
public class AopIdempotent {

    @Autowired
    private RedisToken redisToken;

    @Pointcut("execution(public * com.github.sources.distributed.idempotent.controller.*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        CheckToken declaredAnnotation = methodSignature.getMethod().getDeclaredAnnotation(CheckToken.class);
        if (declaredAnnotation != null) {
            String token = getRequest().getHeader("token");
            ResponseStatus responseStatus = new ResponseStatus();
            responseStatus.setSuccess(false);
            if(StringUtils.isEmpty(token)){
                responseStatus.setRespMsg("参数错误");
                return responseStatus;
            }
            // 校验token
            boolean isToken = redisToken.checkToken(token);
            if(!isToken){
                responseStatus.setRespMsg("请勿重复提交!");
                return responseStatus;
            }
        }
        //通过
        return proceedingJoinPoint.proceed();
    }

    public HttpServletRequest getRequest(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }
}
