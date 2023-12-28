FROM openjdk:19-alpine

ENV POSTGRES_DB=dm
ENV POSTGRES_USER=user
ENV POSTGRES_PASSWORD=user

COPY target/delivery-0.1.jar /app/delivery-0.1.jar

WORKDIR /app

CMD ["java", "-jar", "delivery-0.1.jar"]