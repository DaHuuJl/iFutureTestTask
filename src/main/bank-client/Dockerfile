#
# Build stage
#
FROM public.ecr.aws/docker/library/maven:3.8.6-amazoncorretto-17 AS build

ARG PATH_TO_APP=/home/app
COPY /src ${PATH_TO_APP}/src
COPY /pom.xml ${PATH_TO_APP}

RUN mvn -f ${PATH_TO_APP}/pom.xml clean install

#
# Package stage
#
FROM amazoncorretto:11-alpine-jdk

COPY --from=build /home/app/target/bank-client.jar /usr/local/lib/app.jar

ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar", "--spring.profiles.active=docker"]