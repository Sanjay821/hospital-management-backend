FROM openjdk:8

ADD target/Hospital-Management.jar Hospital-Management.jar

EXPOSE 8282

ENTRYPOINT ["java","-jar","/Hospital-Management.jar"]