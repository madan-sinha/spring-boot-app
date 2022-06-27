FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/spring-boot-app-0.0.1-SNAPSHOT.jar spring-boot-app-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
ENTRYPOINT ["java","-jar","/spring-boot-app-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080