# Product Management API

This is a RESTful API developed in Java using Spring Boot and MariaDB. It allows managing **products**, **categories**, and **users** in an online store backend. The API supports full CRUD operations and is secured using **JWT authentication**. All endpoints are documented with **Swagger (OpenAPI)**.

## 🔧 Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Security + JWT
- MariaDB
- Docker + Docker Compose
- Swagger (springdoc-openapi)

---

## 🚀 Getting Started

To run the application, you need Docker and Docker Compose installed.

### Step 1: Start MariaDB and Adminer

```bash
docker-compose up -d
```

This will start:
- MariaDB database on port `3306`
- Adminer (DB GUI) on `http://localhost:8082`

### Step 2: Run the Spring Boot application

You can run the project using your IDE or with Maven:

```bash
./mvnw spring-boot:run
```

The API will be available at:  
📍 `http://localhost:8081`

---

## 📘 API Documentation

Once the application is running, open the Swagger UI:

**Swagger URL:**  
👉 `http://localhost:8081/swagger-ui.html`

You can explore all endpoints directly from the browser.

---

## 📝 Default Ports

| Service      | Port       |
|--------------|------------|
| Spring Boot  | `8081`     |
| Adminer      | `8082`     |
| MariaDB      | `3306`     |

---

## 👤 Author

Made with ❤️ by Noah Lezama  
Email: `noah.lezama@ict.csbe.ch`

---

> This project is part of the üK295 module: *Backend für Applikationen realisieren*
