# Metronome - Class Routine Management System

A Spring Boot application for managing class routines and teacher schedules. Built with a MVVM architecture pattern.

## Architecture Overview

### MVVM (Model-View-ViewModel) Structure

- **Models** (`models/`)
  - 

User.java

- User authentication model
- User DTO ( Data Transfer Object )

UserProfile.java

- Teacher/Employee profile model
- Teacher DTO

Routine.java

- Class routine model

- **ViewModels** (`services/`)
  - 

UserService.java

- Authentication logic


UserProfileService.java

- Profile management
- Profile DTO

RoutineService.java

- Routine management

- **Views** (`controllers/`)
  - 

AuthController.java

- Authentication endpoints


UserProfileController.java

- Profile endpoints


RoutineController.java

- Routine endpoints

## Prerequisites

- Java 23
- Maven 3.9.9+
- PostgreSQL
- Docker (optional)

## Setup Steps

1. **Clone the repository**
```bash
git clone "https://github.com/Sabir-Islam-Khan/metronome.git"
cd metronome
```

2. **Configure database**

   Use the provided Docker Compose file:
```bash
docker-compose up -d
```

3. **Configure application.properties**

   Update

application.properties

with your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/metronome_db
spring.datasource.username=admin
spring.datasource.password=test1test
```

4. **Build and run**
```bash
./mvnw clean install
./mvnw spring-boot:run
```

## API Documentation

The API documentation is available via Swagger UI at:
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/v3/api-docs

## Security

The application uses JWT for authentication. Security configuration can be found in

SecurityConfig.java

.

## Database Schema

- **users** - Authentication data
- **user_profiles** - Teacher/Employee information
- **routines** - Class schedule information

## Key Features

- JWT Authentication
- User Profile Management
- Class Routine Management
- Teacher Schedule Management

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the MIT License.