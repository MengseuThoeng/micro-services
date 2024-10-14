FROM gradle:8.10.0-jdk21 AS builder
ENV SPRING_PROFILES_ACTIVE=dev
WORKDIR /app
COPY / .
RUN gradle build --no-daemon

FROM openjdk:21
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8081