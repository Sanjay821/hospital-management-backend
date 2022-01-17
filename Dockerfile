FROM openjdk:8

ADD target/Hospital-Managment.jar Hospital-Managment.jar

EXPOSE 8282

ENTRYPOINT ["java","-jar","/Hospital-Managment.jar"]