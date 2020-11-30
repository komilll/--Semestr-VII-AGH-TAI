# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine

EXPOSE 7777

# copy the packaged jar file into our docker image
ADD service-history-0.0.1-SNAPSHOT.jar app.jar

# set the startup command to execute the jar
RUN /bin/sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Xmx256m", "-Xss32m", "-Dspring.data.mongodb.uri=mongodb://service-history-db:27017/service-history","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]