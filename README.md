# 🎓 RJ College Attendance Portal

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" />
  <img src="https://img.shields.io/badge/Swing-007396?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge" />
</p>

---

## 📋 Overview

**RJ College Attendance Portal** is a robust **Java Swing GUI application** for managing student attendance records. It features role-based access control, secure authentication, and persistent PostgreSQL database integration via JDBC. Perfect for educational institutions needing automated attendance management.

---

## ✨ Key Features

- 🔐 **Secure Role-Based Login**
  - Student login
  - Teacher/Faculty login
  - Administrator access
  - Encrypted password handling

- 📊 **Attendance Management**
  - Mark attendance for students
  - View attendance records
  - Generate attendance reports
  - Track attendance history

- 👥 **User Management**
  - Add/edit student profiles
  - Manage faculty accounts
  - User role assignment
  - Admin dashboard

- 🗄️ **Database Integration**
  - PostgreSQL backend
  - JDBC connection pooling
  - Data persistence
  - Efficient queries

- 🎨 **User Interface**
  - Intuitive Swing GUI
  - Multi-frame navigation
  - Real-time data display
  - Responsive design

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|-----------|
| **Frontend** | Java Swing GUI |
| **Backend** | Java |
| **Database** | PostgreSQL |
| **Connection** | JDBC |
| **Architecture** | MVC Pattern |
| **Build Tool** | Maven/Gradle (optional) |

---

## 📋 System Requirements

```
Java: JDK 8 or higher
PostgreSQL: 10.x or higher
RAM: Minimum 2GB
Storage: 100MB free space
OS: Windows, Linux, macOS
```

---

## 🚀 Installation & Setup

### 1. **Clone Repository**
```bash
git clone https://github.com/ShubhamK-0904/RJAttendPortal.git
cd RJAttendPortal
```

### 2. **Database Setup**

Create PostgreSQL database:
```sql
CREATE DATABASE attendance_system;

-- Create tables (see schema below)
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    student_name VARCHAR(100),
    class_name VARCHAR(50),
    roll_number VARCHAR(20)
);

CREATE TABLE attendance (
    attendance_id SERIAL PRIMARY KEY,
    student_id INT REFERENCES students(student_id),
    date DATE,
    status VARCHAR(20),
    marked_by INT REFERENCES users(user_id)
);
```

### 3. **Database Configuration**

Update JDBC connection in source code:
```java
String url = "jdbc:postgresql://localhost:5432/attendance_system";
String user = "postgres";
String password = "your_password";
```

### 4. **Compile & Run**

```bash
javac -d bin src/**/*.java
java -cp bin:lib/* com.attendance.Main
```

---

## 📊 Database Schema

### Users Table
```sql
user_id (PK) | username | password | role | email | created_at
```

### Students Table
```sql
student_id (PK) | student_name | class_name | roll_number | enrollment_date
```

### Attendance Table
```sql
attendance_id (PK) | student_id (FK) | date | status | marked_by (FK) | timestamp
```

### Faculty/Teachers Table
```sql
faculty_id (PK) | faculty_name | department | email | user_id (FK)
```

---

## 🎯 Usage Guide

### **Student Login**
1. Launch application
2. Select "Student" login
3. Enter username and password
4. View your attendance record
5. Check attendance percentage

### **Faculty/Teacher Login**
1. Select "Faculty" login
2. Enter credentials
3. Select class/section
4. Mark attendance for students
5. Submit attendance

### **Admin Dashboard**
1. Select "Admin" login
2. Access user management
3. Generate reports
4. View system statistics
5. Configure settings

---

## 🔄 Workflow Diagram

```
Login Screen
    ↓
├─→ Student Portal → View Attendance → View Reports
├─→ Faculty Portal → Mark Attendance → View Students → Submit
└─→ Admin Portal → Manage Users → View Reports → System Settings
```

---

## 📈 Features Breakdown

### **Role-Based Access Control**
```
Admin
├── User Management (CRUD)
├── View All Reports
├── System Configuration
└── Backup/Restore Data

Faculty
├── Mark Attendance
├── View Student List
├── Generate Class Reports
└── Download Attendance Sheets

Student
├── View Own Attendance
├── Check Attendance %
├── View Attendance History
└── Download Attendance Certificate
```

---

## 🎓 Learning Outcomes

After reviewing this project, you'll understand:
- ✅ Java Swing GUI development
- ✅ JDBC database connectivity
- ✅ Role-based authentication
- ✅ MVC architecture pattern
- ✅ Database design for enterprise apps
- ✅ Multi-frame navigation
- ✅ Event handling in Java
- ✅ SQL integration with Java

---

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| **PostgreSQL connection fails** | Check database URL, username, password, and JDBC driver |
| **Login fails** | Verify user credentials in database and role assignment |
| **UI not displaying** | Ensure Java Swing libraries are properly imported |
| **Slow performance** | Check database indexes and optimize queries |

---

## 🔒 Security Features

- ✅ Password hashing (bcrypt recommended)
- ✅ SQL injection prevention
- ✅ Role-based access control
- ✅ Session management
- ✅ Input validation
- ✅ Secure JDBC connections

---

## 🚀 Future Enhancements

- [ ] Web-based version (Spring Boot)
- [ ] Mobile app (Android/iOS)
- [ ] Email notifications for absent students
- [ ] Biometric attendance integration
- [ ] QR code-based check-in
- [ ] Advanced reporting and analytics
- [ ] Export to PDF/Excel
- [ ] Real-time attendance dashboard

---

## 📚 Libraries & Dependencies

```xml
<!-- JDBC -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.x.x</version>
</dependency>

<!-- Swing (built-in with JDK) -->
<!-- No additional dependency needed -->
```

---

## 📖 Code Structure

```
RJAttendPortal/
├── src/
│   ├── com/attendance/
│   │   ├── Main.java
│   │   ├── LoginFrame.java
│   │   ├── StudentFrame.java
│   │   ├── FacultyFrame.java
│   │   ├── AdminFrame.java
│   │   ├── Database.java
│   │   ├── User.java
│   │   └── Attendance.java
│   └── resources/
├── lib/
│   └── postgresql-42.x.x.jar
├── README.md
└── LICENSE
```

---

## 🤝 Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

---

## 📝 License

MIT License - see LICENSE file for details

---

## 👨‍💻 Author

**Shubham Kadam**
- GitHub: [@ShubhamK-0904](https://github.com/ShubhamK-0904)
- LinkedIn: [Shubham Kadam](https://www.linkedin.com/in/shubham-kadam-b8856031a/)
- Email: shubham85kadam@gmail.com

---

<p align="center">
  <strong>⭐ If helpful, consider giving it a star! ⭐</strong>
</p>

<p align="center">
  Made with ❤️ by Shubham Kadam | Last Updated: May 2026
</p>
