# Book Shop API

Spring Boot REST API for managing authors, publishers, and books.

## Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- MapStruct
- SpringDoc OpenAPI (Swagger UI)

## Run Locally
1. Start PostgreSQL (you can use `docker-compose.yml`).
2. Run the application:

```powershell
.\mvnw.cmd spring-boot:run
```

3. Optional: run with dev seed data:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=dev"
```

## Swagger
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Postman
- Collection file: `postman-bookshop-full-tests.postman_collection.json`

## Database ER Diagram
<img width="301" height="298" alt="ER Diagram-1" src="https://github.com/user-attachments/assets/e3bac2ad-f409-4f33-9e8a-1853114905b4" />
