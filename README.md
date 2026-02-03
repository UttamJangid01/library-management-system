# 📚 Library Management System (LMS) API

A production-ready **RESTful Library Management System Backend** built using **Java, Spring Boot, and MySQL**.

This project provides APIs for managing **Books, Members, Users, and Issue/Return operations** with proper authentication, exception handling, and clean layered architecture.

Designed following real-world backend standards and best practices.

---

## 🚀 Features

### 📖 Book Management
- Add, update, delete books
- Search books by title
- View all books
- Track availability

### 👤 Member Management
- Register members
- Activate / Deactivate members
- Update member details
- Delete members

### 🔁 Issue & Return System
- Issue book to member
- Return book
- Track issue history
- Issue status tracking

### 🔐 Authentication & Users
- User signup
- Login
- Authentication APIs
- Role-based handling (Admin/User ready structure)

### ⚙️ Backend Best Practices
- RESTful APIs
- Layered Architecture (Controller → Service → Repository)
- DTO Pattern
- Global Exception Handling
- Custom Exceptions
- Validation
- Proper HTTP Status Codes
- Clean JSON Responses
- JPA/Hibernate ORM

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Lombok
- Postman (API Testing)

---

## 📂 Project Structure

src/main/java/com

├── controller
│ ├── AdminController.java
│ ├── AuthController.java
│ ├── GettingBooksBy.java
│ ├── IssueController.java
│ ├── MemberController.java
│ └── UserController.java
│
├── dto
│ ├── BookReturn.java
│ ├── ErrorResponse.java
│ ├── LoginRequest.java
│ ├── LoginResponse.java
│ ├── MemberActiveStatusRequest.java
│ ├── SignupRequest.java
│ └── SignupResponse.java
│
├── enums
│ └── IssueStatus.java
│
├── exception
│ ├── BookNotFoundException.java
│ ├── GlobalExceptionHandler.java
│ ├── IssueNotFoundException.java
│ ├── MemberNotFoundException.java
│ └── ResourceNotFoundException.java
│
├── model
│ ├── Book.java
│ ├── IssueRecord.java
│ ├── Member.java
│ └── User.java
│
├── repository
│ ├── BookRepository.java
│ ├── IssueRepository.java
│ ├── MemberRepository.java
│ └── UserRepository.java
│
├── service
│ ├── BookService.java
│ ├── IssueRecordService.java
│ ├── MemberService.java
│ └── UserService.java
│
└── LibraryManagementSystemApplication.java


---

## ⚡ Getting Started

### 1. Clone Repository

bash
git clone https://github.com/UttamJangid01/library-management-system.git
cd lms-api

2. Create MySQL Database
CREATE DATABASE lms;

3. Configure application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/lms
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4. Run Application
mvn spring-boot:run
Server runs at:
http://localhost:8080

📌 API Modules

Book APIs

Member APIs

Issue/Return APIs

Authentication APIs

Admin/User APIs

Test using Postman or Thunder Client.

❗ Sample Error Response
{
  "status": 404,
  "message": "Resource not found"
}

🧠 Concepts Practiced

Spring Boot Architecture

REST API Design

DTO usage

Exception Handling

Authentication flows

JPA Relationships

Clean Code Structure

Layered Backend Design

🔮 Future Improvements

JWT Security

Role-based authorization

Swagger Documentation

Pagination & Sorting

Docker deployment

Frontend integration

👨‍💻 Author

Uttam Jangid
Java Backend Developer
Skills: Java • Spring Boot • MySQL • DSA
