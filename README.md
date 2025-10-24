# 🦷 Dental Clinic Management System

A **Java-based Object-Oriented Programming (OOP)** project designed to manage the operations of a dental clinic.  
This system provides separate roles for **Dentists**, **Receptionists**, and **Patients**, each with unique features and access privileges.  
It also supports **data persistence** through text files for saving and loading clinic data.

---

## 🚀 Features Overview

### 👨‍⚕️ Dentist
- View and update personal profile  
- Update and manage work schedule  
- View availability and appointments for a specific day  
- Access patient and receptionist contact information  
- Write and manage prescriptions  
- View all staff members in the clinic  

### 💼 Receptionist
- Register patients and dentists  
- View all appointments  
- Reserve and cancel appointments for patients  
- Update or modify existing appointments  
- Edit receptionist profile details  
- View and manage patient data  

### 🧍 Patient
- View and edit profile information  
- Reserve, view, update, or cancel appointments  
- Search for dentists by name or mobile number  
- View prescribed medications and treatment details  
- Check available dental services and their prices  

---

## 🧩 Core Classes

| Class | Description |
|-------|--------------|
| **Person** | Base class containing shared attributes (name, username, password, etc.). |
| **Staff** | Inherits from Person; used for Dentists and Receptionists. |
| **Dentist** | Manages profile, appointments, and prescriptions. |
| **Receptionist** | Handles patient appointments and administrative actions. |
| **Patient** | Manages personal details, appointments, and prescriptions. |
| **Appointment** | Handles creation, viewing, updating, and cancellation of appointments. |
| **Service** | Defines available dental services with cost and duration. |
| **File Handling** | Manages saving and loading of all data to and from `.txt` files. |

---

## 💾 File Management

- **dentists.txt** → Stores dentist data (name, specialization, schedule, contact info).  
- **patients.txt** → Stores patient data (personal info, medical records, appointments).  
- **receptionists.txt** → Stores receptionist details.  
- **appointments.txt** → Stores appointment and scheduling data.  
- Data is **loaded automatically** on program start and **saved** before exit.

---

## 🧠 OOP Concepts Applied
- **Encapsulation:** Secure data through getters/setters.  
- **Inheritance:** Reuse behavior from the `Person` and `Staff` classes.  
- **Polymorphism:** Allow multiple role-based behaviors.  
- **Abstraction:** Separate business logic into independent classes.

---

## ⚙️ How to Run the Project

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/Dental-Clinic-Management-System.git
