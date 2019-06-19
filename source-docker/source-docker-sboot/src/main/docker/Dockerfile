<<<<<<< HEAD
FROM frolvlad/alpine-oraclejdk8

# 挂载test-docker目录
VOLUME /tmp

# COPY or ADD to image
COPY docker-demo-exec.jar app.jar

RUN sh -c "touch /app.jar"
#默认8080端口，我的server.port=80
#指定项目暴露的端口号，与项目配置一样,即容器配置的暴露端口
EXPOSE 80
=======
FROM openjdk:8-jdk-alpine

# 挂载test-docker目录
VOLUME /tmp

# COPY or ADD to image
COPY docker-demo-exec.jar app.jar

RUN sh -c "touch /app.jar"
#默认8080端口，我的server.port=80
#指定项目暴露的端口号，与项目配置一样,即容器配置的暴露端口
EXPOSE 80
>>>>>>> 53a2c382af697e2464c9c2a9cf5506d6eb213d9c
ENTRYPOINT ["java", "-jar", "app.jar"]