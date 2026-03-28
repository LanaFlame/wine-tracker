[readme.md](https://github.com/user-attachments/files/26324495/readme.md)
# Wine Tracker API

REST API for managing a personal wine collection, built with Spring Boot.

## Features

- Create, read, update, and delete wines
- DTO-based request/response models
- Input validation
- Global exception handling
- Swagger / OpenAPI documentation
- PostgreSQL integration
- H2 and PostgreSQL profiles
- Postman collection for API testing

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- H2 Database
- Maven
- Docker
- Swagger / springdoc-openapi

## API Endpoints

### Wines

- `GET /wines` — get all wines
- `GET /wines/{id}` — get wine by id
- `POST /wines` — create a new wine
- `PUT /wines/{id}` — update an existing wine
- `DELETE /wines/{id}` — delete wine by id

## Example Request

### Create wine

```json
{
  "name": "Chianti Classico",
  "winery": "Castello di Ama",
  "country": "Italy",
  "year": 2019,
  "rating": 4,
  "notes": "Cherry, leather, dry finish"
}
```

## Validation Rules

- `name` — required, not blank, max 100 chars
- `winery` — required, not blank, max 100 chars
- `country` — required, not blank, max 50 chars
- `year` — required, from 1900 to 2100
- `rating` — required, from 1 to 5
- `notes` — optional, max 500 chars

## Error Handling

The API returns structured error responses for:

- `404 Not Found` — wine does not exist
- `400 Bad Request` — validation errors

## Swagger UI

After starting the app, open:

```text
http://localhost:8080/swagger-ui.html
```

## Running the Project

### 1. Clone the repository

```bash
git clone <your-repository-url>
cd wine-tracker
```

### 2. Run with PostgreSQL profile

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=postgres
```

On Windows:

```bash
mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=postgres
```

### 3. Run with H2 profile

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=h2
```

## Docker PostgreSQL

Example container:

```bash
docker run --name wine-tracker-postgres -e POSTGRES_DB=wine_tracker -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5433:5432 -d postgres
```

## Profiles

- `h2` — in-memory database for quick local testing
- `postgres` — external PostgreSQL database in Docker

## Learning Goals of This Project

This project was built to practice:

- Spring Boot application structure
- REST API development
- layered architecture
- DTO usage
- validation
- exception handling
- working with external databases
- Docker basics

## Future Improvements

- tests
- sorting
- search/filter endpoints
