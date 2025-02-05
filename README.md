# 🚀 Spring Boot Login & Registration API && Financial Tracking App 

Welcome to **Spring Boot Login & Registration API**! 🔐 This project provides a secure and robust API for user authentication and registration using **Spring Boot**, **Spring Security**, and **JWT**. 🛡️

---

## 🌟 Features

✅ **JWT Authentication** for secure login and session management.  
✅ **Password Encryption** using `BCrypt`. 🔒  
✅ **REST API** with endpoints for **Login**, **Registration**, and **User Profile**. 🌐  
✅ **Integration with MySQL / H2 Database** using **Spring Data JPA**. 🗄️  
✅ **Spring Security** for endpoint protection. 🔑  
✅ **Role-Based Access Control** for user roles. 👥  
✅ **Custom UserDetailsService** to manage credentials. 🛠️  

---

## 🏗️ Technology Stack

🔹 **Backend**: Spring Boot, Spring Security, Spring Data JPA  
🔹 **Authentication**: JWT (JSON Web Tokens)  
🔹 **Database**: MySQL / H2  
🔹 **Build Tool**: Maven  
🔹 **Language**: Java ☕  

---

## 🚀 Getting Started

### 📌 Prerequisites
Ensure you have installed:  

- **Java 17+** ☕  
- **Maven** ⚙️  
- **MySQL** (optional if using H2 for local development) 🛢️  

### 📥 Installation

1️⃣ **Clone the repository** 📂  
```bash
   git clone https://github.com/Dev-Albertojunior1/login-app-backend-main.git
   cd spring-boot-login-registration-api
```

2️⃣ **Configure Your Database** 🗄️  
- For **MySQL**: edit `application.properties` or `application.yml` with your credentials.  
- For **H2 Database**: skip MySQL configuration for local testing.  

3️⃣ **Run the application** ▶️  
```bash
   mvn spring-boot:run
```

4️⃣ **Access the API** via `http://localhost:8080`. 🌍

---

## 🔗 API Endpoints

| HTTP Method | Endpoint              | Description                   | Authentication? |
|-------------|-----------------------|-------------------------------|--------------|
| `POST`      | `/auth/register`       | Register a new user           | No           |
| `POST`      | `/auth/login`          | Login and obtain JWT          | No           |
| `GET`       | `/users/me`            | Get logged-in user profile    | Yes          |

🔑 **Authentication**: Protected routes require a JWT token in the `Authorization` header:  
```bash
Authorization: Bearer <JWT_TOKEN>
```

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.example.project
│   │       ├── config         # Security and JWT Configurations 🔐
│   │       ├── controller     # Authentication and User Controllers 🚀
│   │       ├── dto            # Data Transfer Objects 📨
│   │       ├── entity         # User Entity 👤
│   │       ├── repository     # JPA Repository 🔍
│   │       ├── service        # Services for Authentication and JWT 🛠️
│   └── resources
│       ├── application.yml    # Database Configuration ⚙️
└── pom.xml                    # Project Dependencies 📦
```

---

## 🔑 Example JWT Token

After a successful login, you will receive a JWT token:

```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huZG9lQGVtYWlsLmNvbSIsImlhdCI6MTYyNjU5MjA1MywiZXhwIjoxNjI2NTk1NjUzfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

Use this token to access protected routes by adding it to the request headers. 🛡️

---

## ⚙️ Configuration

Customize the settings by modifying `application.properties` or `application.yml`.  

### 🛢️ Example for MySQL:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: your-username
    password: your-password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  security:
    jwt:
      secret: YourJWTSecretKey
      expirationMs: 86400000
```

---

## 🛠️ Testing the API

Use tools like **Postman** or **Insomnia** to test the endpoints. Here’s an example request to register a new user:

```json
POST /auth/register
{
  "name": "Alberto junior",
  "email": "aj@example.com",
  "password": "password123"
}
```

---

## 🏗️ Built With

🔹 [Spring Boot](https://spring.io/projects/spring-boot) - Backend Framework  
🔹 [JWT](https://jwt.io/) - Token-Based Authentication 🔐  
🔹 [Maven](https://maven.apache.org/) - Build Tool ⚙️  

---

## 🤝 Contribution

Contributions are always welcome! 💡 Open a PR or an issue to suggest improvements. Check out the [contribution guidelines](CONTRIBUTING.md). 📜

---

## 📜 License

This project is under the **MIT License** - see the [LICENSE](LICENSE) file for more details. 📄

---

## 📩 Contact

Feel free to reach out via [Email](mailto:albertojunior848423803@gmail.com) or open an issue for any questions, bugs, or suggestions! ✉️

