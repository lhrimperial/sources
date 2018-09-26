package com.github.sources.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.sources.dubbo.api.domain.UserDTO;
import com.github.sources.dubbo.api.service.IUserService;
import org.springframework.stereotype.Component;

/**
 *
 */
@Service(interfaceClass = IUserService.class)
@Component
public class UserServiceImpl implements IUserService {

    @Override
    public UserDTO findUserByName(String userName) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("admin");
        userDTO.setPassword("123");
        return userDTO;
    }
}
