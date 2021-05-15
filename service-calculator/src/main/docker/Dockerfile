# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine

EXPOSE 5555

# copy the packaged jar file into our docker image
ADD service-calculator-0.0.1-SNAPSHOT.jar app.jar
ADD elastic-apm-agent-1.23.0.jar agent.jar

# set the startup command to execute the jar
CMD ["java", "-javaagent:/agent.jar", "-Delastic.apm.service_name=api-gateway*", "-Delastic.apm.server_url=http://apm-server:8200", "-Delastic.apm.application_packa    ges=pl.agh.apigateway", "-jar", "/app.jar"]