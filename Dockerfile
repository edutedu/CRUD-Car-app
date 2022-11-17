FROM openjdk:19

COPY target/CRUD_Car_App-0.0.1-SNAPSHOT.jar CRUD_Car_App-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/CRUD_Car_App-0.0.1-SNAPSHOT.jar"]