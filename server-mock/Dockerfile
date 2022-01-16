FROM openjdk:17-jdk-slim
VOLUME /server-mock
EXPOSE 8080
ADD target/server-mock-0.0.1-SNAPSHOT.jar /server-mock.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n", "-jar", "/server-mock.jar"]

