FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# copy maven wrapper and pom first (for dependency caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:resolve

# now copy source code
COPY src src

# build the JAR
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app

# copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# expose Spring Boot port
EXPOSE 8080

# Spring Boot must run on Render's dynamic port
ENV PORT=8080
ENV SERVER_PORT=${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]
