FROM openjdk:19
LABEL maintainer="nimeshchanuka@gmail.com"
WORKDIR /app
COPY target/garbage-collection.jar /app/garbage-collection.jar
ENTRYPOINT ["java","-jar","garbage-collection.jar"]
