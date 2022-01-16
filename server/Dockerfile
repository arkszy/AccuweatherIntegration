FROM openjdk:17-jdk-slim
VOLUME /server
EXPOSE 8080
ADD target/server-0.0.1-SNAPSHOT.jar /server.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n", "-jar", "/server.jar"]

