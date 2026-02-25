# Étape 1 : Build
FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder
WORKDIR /build

# Cache intelligent des dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Image finale très légère
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# On copie seulement le jar
COPY --from=builder /build/target/*.jar app.jar

# Utilisateur non-root (sécurité)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

EXPOSE 8080

# Pour healthcheck + graceful shutdown
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0 -XX:+UseZGC"

ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
