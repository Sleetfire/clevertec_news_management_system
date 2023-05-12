FROM eclipse-temurin:17-alpine
MAINTAINER Sleetfire

ADD ./build/libs/news_management_service-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/news_management_service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080 8089