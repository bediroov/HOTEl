# OpenJDK 17 istifadə edin
FROM openjdk:17-jdk-slim

# Tətbiqin JAR faylını konteynerə kopyalayın
COPY build/libs/HotelReservation-0.0.1-SNAPSHOT.jar hotel-management-app.jar

# Ətraf mühit dəyişkənləri (PostgreSQL bağlantısı üçün)
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/hotel_management
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=hafiz.127

# JAR faylını işə salın
ENTRYPOINT ["java", "-jar", "hotel-management-app.jar"]
