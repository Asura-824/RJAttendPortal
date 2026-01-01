# RJ College Attendance Portal 🎓

A simple **Java Swing application** that simulates a multi-step attendance portal for RJ College.  
This project demonstrates GUI design, event-driven programming, and multi-frame navigation in Java.

---

## 📝 Program Description

The application guides the user through **three sequential windows**:

1. **Welcome Screen**
   - Displays a greeting message: *“Welcome to RJ College Attendance Portal”*
   - Contains a **Next** button to proceed

2. **Designation Selection Screen**
   - Prompts: *“Please select Your Designation”*
   - Provides a drop-down (**JComboBox**) with options: *Student, Teacher, Other*
   - Includes a **Continue** button to move forward

3. **Details Entry Screen**
   - Collects personal details:
     - Unique ID  
     - Name, Middle Name, Surname  
     - Date & Time  
   - Each field is paired with a **JLabel** and **JTextField**  
   - A **Submit** button is provided for final confirmation

---

## ⚙️ Technical Features

- Built with **Java Swing** using `setBounds()` for precise component positioning  
- Implements **event-driven programming** via `ActionListener` for button clicks  
- Each `JFrame` is disposed before opening the next, ensuring clean transitions  
- Mimics a real-world form-filling process with step-by-step navigation  

---

## 🎯 Purpose

This project demonstrates:
- Practical **GUI design in Java Swing**  
- **Multi-frame navigation** techniques  
- **User input handling**  
- A prototype for an **attendance management system**  

---

## 🏆 Future Goals

- Integrate the portal with a **PostgreSQL database** using the **PostgreSQL JDBC Driver**  
- Enable persistent storage and retrieval of attendance records  
- Expand functionality for role-based access (Student, Teacher, Admin)  

---

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher  
- Any Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans) or command-line setup  
- **PostgreSQL JDBC Driver** installed and available in your classpath  

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/rj-college-attendance-portal.git
