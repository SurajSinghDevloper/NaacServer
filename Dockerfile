FROM openjdk:8
EXPOSE 8081
ADD target/naacserver.jar naacserver.jar
ENTRYPOINT ["java","-jar","/naacserver.jar"]