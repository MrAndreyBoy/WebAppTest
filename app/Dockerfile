FROM gradle:6.3-jdk11 as builder
COPY --chown=gradle:gradle app/. /home/gradle/app
WORKDIR /home/gradle/app
RUN gradle --no-daemon build

FROM openjdk:11.0-jre
WORKDIR /app
COPY --from=builder /home/gradle/app/build/libs/*.jar ./app.jar

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar
