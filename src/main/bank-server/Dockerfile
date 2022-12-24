FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/bank-server.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar","--spring.profiles.active=docker"]
