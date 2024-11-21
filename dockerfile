# # Base Image with the JDK used to build and run the java application
# FROM eclipse-temurin:23-jdk

# LABEL MAINTAINER = "lawson@lawson.com"
# LABEL DESCRIPTION = "VTTP Day 14 Lecture - Dockerfile example using day 12 lecture example java programme"
# LABEL NAME = "SSF-DAY12-LECTURE"

# ARG APP_DIR=/APP

# # Directory where your source code will reside
# # Directory where you will copy to in the next step
# WORKDIR ${APP_DIR}

# # Install Maven
# RUN apt-get update && apt-get install -y maven && apt-get clean

# # Copy the required files/directories into the image
# COPY pom.xml .
# COPY mvnw .
# COPY mvnw.cmd .
# COPY src src
# COPY .mvn .mvn

# # Run and package the application using hte RUN directive
# # This will download the dependencies that are defined in pom.xml
# # Compiles and package the jar
# RUN mvn package -Dmaven.test.skip=true

# ENV SERVER_PORT 3000

# EXPOSE ${SERVER_PORT}


# ENTRYPOINT SERVER_PORT=${SERVER_PORT} java -jar target/vttp-day13-lecture-0.0.1-SNAPSHOT.jar


# the base image with JDK use to build and run your java application
FROM eclipse-temurin:23-jdk

# labeling the dockerfile
LABEL MAINTAINER="darryl"
LABEL description="This is VTTP5 SSF Day13 lecture demo and walkthrough"
LABEL name="vttp5a-ssf-day13l"

ARG APP_DIR=/APP

# directory where your source code will reside
# directory where you copy your project to (in the next step)
WORKDIR ${APP_DIR}

# copy the required files and/or directories into the image 
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY src src
COPY .mvn .mvn

# package the application using the RUN directive
# this will download the dependencies definedin pom.xml
# compile and package to jar
# RUN chmod a+x ./mvnw
RUN chmod a+x ./mvnw && ./mvnw clean package -Dmaven.test.skip=true
# RUN mvn package -Dmaven.test.skip=true

ENV SERVER_PORT 3000

EXPOSE ${SERVER_PORT}

ENTRYPOINT SERVER_PORT=${SERVER_PORT} java -jar target/vttp-day13-lecture-0.0.1-SNAPSHOT.jar