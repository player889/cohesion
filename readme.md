# Cohesion

A demonstration project for Java Spring Boot concepts, currently focusing on Aspect-Oriented Programming (AOP).

## Project Overview

This repository serves as a collection of examples demonstrating various software engineering principles and frameworks,
specifically focusing on cohesion and common Spring Boot patterns.

## Stack

- **Language:** Java 17+ (assumed from Spring Boot 3.3.3 requirements)
- **Framework:** [Spring Boot 3.3.3](https://spring.io/projects/spring-boot)
- **AOP:** Spring AOP
- **Package Manager:** Maven
- **Libraries:** Lombok, SLF4J

## Project Structure

```text
cohesion/
├── aop/                # AOP demonstration module
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/   # Source code
│   │   │   └── resources/ # Configuration and HTTP samples
│   ├── pom.xml         # Module-specific Maven configuration
│   └── readme.md       # Module-specific documentation
├── pom.xml             # Root Maven configuration
└── README.md           # This file
```

## Requirements

- **JDK:** 17 or higher
- **Maven:** 3.6 or higher

## Setup & Run

### Building the Project

To build the entire project, run the following command from the root directory:

```bash
mvn clean install
```

### Running the AOP Module

To run the AOP demonstration:

```bash
cd aop
mvn spring-boot:run
```

## Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `PORT`   | Server port | `8080`  |

*(Note: Currently using default Spring Boot configuration. Add any custom env vars here.)*

## Tests

To run tests (when available):

```bash
mvn test
```

*TODO: Add unit and integration tests for AOP cases.*

## Scripts

- `mvn clean install`: Builds the project and installs artifacts.
- `mvn spring-boot:run`: Runs the Spring Boot application (within the `aop` module).

## License

TODO: Specify license (e.g., MIT, Apache 2.0).