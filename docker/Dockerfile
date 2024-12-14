FROM openjdk:17-jdk-slim

ENV TZ=Asia/Seoul

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

CMD ["java", "-jar", "app.jar"]