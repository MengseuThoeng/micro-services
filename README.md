## Spring Boot Microservices Project

### Overview

This project demonstrates a Spring Boot 3.3.3-based microservices architecture, incorporating:

* **Configuration Server:** Centralized management of application properties.
* **Eureka Server:** Service discovery and registration.
* **Gateway:** API gateway for routing and filtering requests.
* **OAuth2:** Authentication and authorization using OAuth2.

### Project Structure

```
├── config-server
├── eureka-server
├── gateway
├── oauth2-server
└── ... (other microservices)
```

### Getting Started

1. **Clone the repository:**
   ```bash
   git clone <[repository-url](https://github.com/MengseuThoeng/micro-services)>
   ```

2. **Build and run the projects:**
   ```bash
   cd <micro-services>
   ./gradlew bootRun
   ```
   This will start all microservices.

### Configuration Server

The configuration server provides a centralized location for application properties. Clients can fetch properties from the server using Spring Cloud Config.

### Eureka Server

The Eureka server is responsible for service discovery and registration. Microservices register themselves with the server, and other services can use it to locate and communicate with each other.

### Gateway

The gateway acts as a single entry point for all requests. It routes requests to the appropriate microservices based on path, query parameters, or other criteria. It can also apply filters to requests and responses, such as authentication, rate limiting, and logging.

### OAuth2

OAuth2 is used for authentication and authorization. The OAuth2 server provides endpoints for clients to obtain access tokens, and microservices can use these tokens to authenticate requests.

### Usage

**Example:**

To call a protected resource in another microservice:

1. Obtain an access token from the OAuth2 server.
2. Include the access token in the Authorization header of your request.

### Dependencies

This project uses the following Spring Boot starters:

* `spring-boot-starter-actuator`
* `spring-boot-starter-cloud-config`
* `spring-boot-starter-cloud-config-server`
* `spring-boot-starter-cloud-netflix-eureka-server`
* `spring-boot-starter-cloud-netflix-zuul`
* `spring-boot-starter-oauth2-client`
* `spring-boot-starter-oauth2-resource-server`
* ... (other dependencies as needed)

### Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your fork.
5. Create a pull request to the main repository.

### License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

---

**Remember to replace placeholders like `<repository-url>` and `<project-directory>` with your actual values.**

**Customize the README further to provide more specific information about your project, such as deployment instructions, troubleshooting tips, and additional features.**
