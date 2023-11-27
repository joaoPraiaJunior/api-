FROM openjdk:17-jdk-alpine3.13

WORKDIR /app

COPY /build/libs/*.jar medvoll_api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "medvoll_api.jar"]