# Online-Library-System-
The Online Library System is a web-based application developed using Java EE technologies that manages library resources such as books, authors, categories, users, and book issuing records.
It provides role-based access for Admin (Librarian) and Members (Students & Teachers) and performs all operations using a MySQL relational database.Another words say like that  library operations can perform  as book management, book searching, user management, and book issue/return processes.

🧩 System Modules
1️⃣ Admin (Librarian) Module
The Admin is responsible for managing the entire library system.
Admin Functions:
Secure admin login
Add, update, and delete books
Manage authors and categories
Register and manage students and teachers
Issue and return books
Manage fines
View issued, returned, and overdue books

2️⃣ Book Search Module
The Book Search module allows users to search books efficiently.
Search Features:
Search by book name
Search by author


Real-time search using AJAX
How it works:
User enters keywords in the search box
AJAX sends request to Servlet
Servlet fetches data from MySQL
Results returned as JSON
Books displayed dynamically without page reload

3️⃣ User Module (Student / Teacher)
User login
View available books
Search books
View issued books and due dates

🏗️ Technology Usage
🔸 Java Servlet
Handles HTTP requests
Controls business logic
Processes CRUD operations
Sends JSON responses for AJAX calls

🔸 JSP
Displays UI pages
Handles forms and tables
Shows dynamic content

🔸 JSTL
Used for loops and conditions
Removes Java code from JSP
Improves code readability

🔸 MySQL
Stores users, books, authors, categories, and issue records
Maintains relationships using foreign keys
🔸 AJAX & JSON
Enables asynchronous book search
Updates UI without page reload
Improves performance and user experience

🗄️ Database Tables (Main)
app_user
book
author
category
student
teacher
member
book_issue
librarian

🔐 Security Features
Role-based access (Admin, Student, Teacher)
Session management
Input validation
Password protection

✅ Advantages
Fast book searching
Centralized data management
Reduced manual work.
User-friendly interface

Secure and scalable system
