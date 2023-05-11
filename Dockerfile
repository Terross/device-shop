FROM eclipse-temurin:20-alpine
VOLUME /tmp
COPY /build/libs/device-shop-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]