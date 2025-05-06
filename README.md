# EduFind
A SpringBoot + React WebApp created for students to be able to find and explore coaching institutes for various fields.

Absolutely! Here’s a **summary of how we’ve restructured your database and entity relationships** to create a **cleaner, scalable, and more efficient** design:  

### **🔹 Entity Relationships Overview**
#### 🏫 **Institute**
- **One-to-Many** → Courses (`An Institute can have multiple Courses`)  
- **One-to-Many** → Admission Requests (`An Institute can receive requests from multiple Students`)  
- **One-to-Many** → Faculty (`An Institute employs multiple Faculty members`)  
- **Many-to-One** → Admin (`An Institute is approved by an Admin`)  

#### 📖 **Course**
- **Many-to-One** → Institute (`Each Course belongs to one Institute`)  
- **One-to-Many** → Admission Requests (`Each Course can be requested by multiple Students`)  

#### 👩‍🎓 **Student**
- **Many-to-One** → Institute (`Each Student applies to one Institute`)  
- **Many-to-One** → Course (`Each Student applies to one Course`)  
- **One-to-Many** → Feedback (`A Student can submit multiple reviews`)  
- **One-to-Many** → Roles (`A Student can have multiple roles`)  

#### 👨‍🏫 **Faculty**
- **Many-to-One** → Institute (`Each Faculty belongs to one Institute`)  
- **Many-to-One** → Course (`Each Faculty teaches one Course`)  

#### ⭐ **Feedback**
- **Many-to-One** → Institute (`Each Feedback is about one Institute`)  
- **Many-to-One** → Student (`Each Feedback is submitted by one Student`)  

#### 🛡 **Admin**
- **One-to-Many** → Institutes (`An Admin approves multiple Institutes`)  
- **One-to-Many** → Roles (`An Admin can have multiple permissions`)  

#### 🔑 **UserRoles**
- **Many-to-One** → Student (`A Student can have a role like STUDENT`)  
- **Many-to-One** → Institute (`An Institute can have a role like INSTITUTE_ADMIN`)  
- **Many-to-One** → Admin (`An Admin can have a role like SUPER_ADMIN`)  


