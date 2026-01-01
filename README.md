# RJ College Attendance Portal

A Java Swing application that simulates an attendance management system for RJ College.  
The project demonstrates GUI design, secure login, event-driven programming, and database integration using PostgreSQL.

---

## 📌 Features
- **Multi-Frame Navigation** – Includes Welcome, Designation Selection, Details Entry, and Login frames for smooth user flow.  
- **Role Selection** – Users can choose their designation (Student, Teacher, Admin) via a drop-down menu.  
- **Details Entry Form** – Collects information such as Unique ID, Name, Middle Name, Surname, Date, and Time.  
- **Secure Login** – Login frame with username and password fields, using `JPasswordField` for secure input and validation.  
- **Database Connectivity** – Integrated with **PostgreSQL** via **JDBC driver** to store and retrieve attendance details.  
- **Event-Driven Programming** – Implemented with `ActionListener` for handling user actions.  
- **Fixed Layout Design** – Components positioned precisely using `setBounds`.  

---

## 🛠️ Tech Stack
- **Java (Swing)** – GUI design and event handling  
- **PostgreSQL** – Database for attendance details  
- **JDBC Driver** – Database connectivity  
- **Event-Driven Programming** – User interaction handling  

---

## 📦 Dependencies
Before running the project, ensure the following dependencies are installed and configured:

- **Java JDK 8+**  
- **PostgreSQL Database** (version 13 or later recommended)  
- **PostgreSQL JDBC Driver**  
  - Download: [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html)  
  - Example: `postgresql-42.7.3.jar`  
  - Add the JAR file to your project’s classpath.  
- *(Optional)* If using another database (e.g., MySQL, SQL Server), include the respective JDBC driver JAR file.

---

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/Asura-824/RJAttendPortal.git
