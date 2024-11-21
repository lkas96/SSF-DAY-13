# Base Image with the JDK used to build and run the java application
FROM eclipse-temurin:23-jdk

LABEL MAINTAINER = "lawson@lawson.com"
LABEL DESCRIPTION = "VTTP Day 14 Lecture - Dockerfile example"
LABEL NAME = "SSF-DAY12-LECTURE"

ARG APP_DIR=/APP

# Directory where your source code will reside
# Directory where you will copy to in the next step
WORKDIR ${APP_DIR}

# Install Maven
RUN apt-get update && apt-get install -y maven && apt-get clean

# Copy the required files/directories into the image
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY src src
COPY .mvn .mvn

# Run and package the application using hte RUN directive
# This will download the dependencies that are defined in pom.xml
# Compiles and package the jar
RUN mvn package -Dmaven.test.skip=true

ENV SERVER_PORT 3000

EXPOSE ${SERVER_PORT}


ENTRYPOINT SERVER_PORT=${SERVER_PORT} java -jar target/vttp-day13-lecture-0.0.1-SNAPSHOT.jar