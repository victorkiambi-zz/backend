FROM openjdk:8-jdk-alpine
LABEL maintainer="kiambi15@gmail.com"

RUN mkdir target
VOLUME /tmp
EXPOSE 8080
#ARG JAR_FILE = target/media-0.0.1-SNAPSHOT.jar
COPY /target/media-0.0.1-SNAPSHOT.jar /target
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/media-0.0.1-SNAPSHOT.jar"]