FROM openjdk:12-jdk-alpine

COPY build/libs/*.jar k8s-add.jar
ENTRYPOINT ["java","-jar","/k8s-add.jar"]