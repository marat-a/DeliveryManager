FROM openjdk:19-alpine

ENV POSTGRES_DB=dm
ENV POSTGRES_USER=user
ENV POSTGRES_PASSWORD=user

# Копируем JAR-файл вашего Spring приложения в контейнер
COPY target/delivery-0.1.jar /app/delivery-0.1.jar

# Устанавливаем рабочую директорию
WORKDIR /app

# Запускаем Spring приложение при старте контейнера
CMD ["java", "-jar", "delivery-0.1.jar"]