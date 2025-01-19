FROM amazoncorretto:21

WORKDIR /usr/local/app

COPY ./build/libs/*.jar ./

EXPOSE 8080

RUN chmod 777 *.jar

CMD ["java", "-jar", "/usr/local/app/parquimetro-0.0.1-SNAPSHOT.jar"]

