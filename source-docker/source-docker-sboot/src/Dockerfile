FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/docker-demo.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]