# 💳 Payment Management API

> **Demo project.** Built independently to practice a layered Spring Boot REST API (DTOs, mapper, validation, global exception handling). Not affiliated with or built for any employer.

A RESTful API built with **Spring Boot** for recording and retrieving payments, following a clean controller → service → repository architecture with DTO/entity mapping.

## 🚀 Features

- Create and retrieve payment records
- Request validation on incoming payloads
- DTO ↔ entity mapping kept separate from persistence
- Centralised exception handling with structured error responses

## 🛠️ Technologies Used

- Java 17
- Spring Boot (Web, Data JPA, Validation)
- H2 (in-memory database for local development/testing)
- Lombok
- Maven

## 🔧 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+

### Run the App

```bash
mvn spring-boot:run
```

The H2 console is available at `/h2-console` while running with the default local profile.
