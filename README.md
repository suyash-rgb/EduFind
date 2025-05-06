# EduFind
A SpringBoot + React WebApp created for students to be able to find and explore coaching institutes for various fields.

You're working with a well-structured relational database designed for managing educational institutions, students, courses, and administrative functions. Let's break it down into key components:

# Database

### **Core Entities**
1. **Admin (`admin`)**  
   - Stores admin credentials and authentication tokens.
   
2. **Institute (`institute`)**  
   - Represents educational institutions, containing details like name, password, email, and address.
   
3. **Student (`student`)**  
   - Represents students with basic personal details, credentials, and unique identifiers.

4. **Course (`course`)**  
   - Holds course details such as name, price, seat availability, and brochures.

### **Relationships Between Entities**
1. **Institute & Course (`course_institute`)**  
   - Associates institutes with courses they offer.

2. **Student & Course (`student_course`)**  
   - Tracks students enrolled in courses.

3. **Admission Requests (`admissionrequest`)**  
   - Handles student applications, linking students (`userID`), institutes (`instituteID`), and courses (`courseID`).
   
4. **Faculty (`faculty`)**  
   - Associates faculty members with courses and institutes.
   
5. **Audit Log (`audit_log`)**  
   - Captures student actions for tracking changes.
   
6. **Feedback (`feedback`)**  
   - Stores student feedback related to institutes.

7. **Roles & User Roles (`roles`, `user_roles`)**  
   - Defines roles and assigns them to users (`student` table).

### **Media & Additional Features**
1. **Institute Images (`instituteimages`)**  
   - Stores institute-related images in binary form.
   
2. **Course Images (`courseimages`)**  
   - Stores images related to courses.

### **Key Constraints**
- **Foreign Keys** ensure integrity by linking relevant tables.
- **Auto-Incremented Primary Keys** simplify indexing for records.
- **Unique Constraints on Emails** prevent duplicate registrations.

Your structure follows good relational database principles, ensuring scalability and clear linkages between students, courses, and institutes. Do you need help optimizing any aspect of this?

