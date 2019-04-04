FROM openjdk:12-jdk-alpine
EXPOSE 8082
COPY build/libs/*.jar k8s-add.jar
ENTRYPOINT ["java","-jar","/k8s-add.jar"]