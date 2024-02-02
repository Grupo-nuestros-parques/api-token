FROM openjdk:13-alpine
#WORKDIR /app
#COPY . .
#RUN ./gradlew clean build
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","build/libs/app-0.0.1-SNAPSHOT.jar"]
VOLUME /tmp
EXPOSE 8090
ARG JAR_FILE=build/libs/api-token-0.0.1-api-token.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
