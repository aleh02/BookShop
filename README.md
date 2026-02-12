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
Add your ER diagram here.

Option 1: commit an image and reference it below.

```md
![DB ER Diagram](docs/er-diagram.png)
```

Option 2: paste/link an external diagram URL.

---

If you want, this README can be extended with endpoint examples and validation/error response samples.
