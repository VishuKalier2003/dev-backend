# **Dev Backend – Spring Boot Microservice**

A cloud-ready REST API developed using Spring Boot 3.5 and Java 17. The service exposes secure CRUD endpoints for student data and user identity management. It is architected for containerized deployment on cloud infrastructure (Render) and uses the embedded H2 database for zero-configuration persistence and streamlined provisioning.

---

## **1. Technical Overview**

This service follows a stateless, REST-first design pattern. It is designed for ease of deployment, minimal environment configuration, and rapid product iteration. Modern backend components, cloud hosting, and containerization are built into the core architecture.

### Key Features:

* REST API implemented using Spring Boot
* Spring Data JPA ORM with H2 persistence
* Stateless request handling via controllers
* Multi-stage Docker build for production deployment
* Cross-platform compatibility with container runtimes
* Production deployed and auto-provisioned on Render

This architecture is a lightweight but scalable microservice suitable for rapid prototyping and enterprise adoption.

---

## **2. System Requirements**

| Component           | Specification |
| ------------------- | ------------- |
| Java                | 17+           |
| Build Tool          | Maven         |
| Database            | H2            |
| Runtime Environment | Docker        |

Local run and cloud execution require no additional configuration.

---

## **3. Project Structure**

```
src/
  main/
    java/com/example/demo/
      api/
      model/
      repo/
    resources/
      application.properties
pom.xml
Dockerfile
```

The codebase follows standard Spring Boot layering conventions for clarity, maintainability, and future scaling.

---

## **4. API Endpoints**

### **Authentication**

| Method | Endpoint             |
| ------ | -------------------- |
| POST   | `/api/auth/register` |
| POST   | `/api/auth/login`    |

### **Student Operations**

| Method | Endpoint             |
| ------ | -------------------- |
| GET    | `/api/students`      |
| POST   | `/api/students`      |
| PUT    | `/api/students/{id}` |
| DELETE | `/api/students/{id}` |

All APIs are JSON-based, state-safe, and orchestrated through Spring MVC.

---

## **5. Local Execution**

### **Clone**

```bash
git clone <repo-url>
cd dev-backend
```

### **Run using Maven**

```bash
mvn spring-boot:run
```

Service will be available at:

```
http://localhost:8080
```

---

## **6. Running Using JAR**

Build:

```bash
mvn clean package -DskipTests
```

Run:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

## **7. Running on Docker**

### **Build image**

```bash
docker build -t dev-backend .
```

### **Run container**

```bash
docker run -p 8080:8080 dev-backend
```

This fully encapsulates dependencies, runtime, Maven builds, and environment variables.

---

## **8. Deployment on Render (Production)**

This service is live at:

```
https://dev-backend-4oow.onrender.com
```

Render identifies exposed ports automatically and runs the JAR from the container runtime environment. No external configuration is required.

---

## **9. Technology Stack**

| Layer       | Technology      |
| ----------- | --------------- |
| Framework   | Spring Boot     |
| Runtime     | Java 17         |
| Persistence | H2 Database     |
| ORM         | JPA/Hibernate   |
| Deployment  | Docker + Render |

This stack is lightweight, rapidly deployable, and production-ready.

