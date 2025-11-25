FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the JAR you built locally
COPY target/*.jar app.jar

EXPOSE 8080

# Render uses dynamic port, so allow override
ENV PORT=8080
ENV SERVER_PORT=${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]
