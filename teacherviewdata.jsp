<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Teacher Data List</title>

<!-- ✅ Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- ✅ Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">

<style>
   body {
    background: url("form.jpg") no-repeat center center fixed;
    background-size: cover;
    font-family: 'Poppins', sans-serif;
    padding: 40px;
}

/* Dark glass container */
.data-container {
    background: rgba(0, 0, 0, 0.65);
    border-radius: 15px;
    padding: 30px;
    box-shadow: 0 0 25px rgba(0, 0, 0, 0.6);
    backdrop-filter: blur(8px);
}

/* Page heading */
h2 {
    text-align: center;
    color: #ffffff;
    font-weight: 600;
    margin-bottom: 25px;
    letter-spacing: 1px;
    text-transform: uppercase;
}

/* Table */
table {
    background-color: #ffffff;
    font-size: 14px;
    border: 1px solid #000;
}

thead th {
    background-color: #ffffff;
    color: #000;
    border: 1px solid #000;
    text-align: center;
}

tbody td {
    border: 1px solid #000;
    text-align: center;
    vertical-align: middle;
}

tbody tr:hover {
    background-color: #f2f7ff;
}

</style>
</head>

<body>

<div class="container-fluid">
    <div class="data-container">

        <h2>LIST OF TEACHER DATA</h2>

        <div class="table-responsive">
            <table class="table table-bordered align-middle">
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Teacher ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Father Name</th>
                        <th>Surname</th>
                        <th>CNIC</th>
                        <th>Contact No</th>
                        <th>Gender</th>
                        <th>Email</th>
                        <th>Date of Birth</th>
                        <th>Department</th>
                        <th>Address</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="teacherData" items="${teachData}">
                        <tr>
                            <td>${teacherData.userId}</td>
                            <td>${teacherData.teacherId}</td>
                            <td>${teacherData.firstName}</td>
                            <td>${teacherData.lastName}</td>
                            <td>${teacherData.fatherName}</td>
                            <td>${teacherData.surname}</td>
                            <td>${teacherData.cnic}</td>
                            <td>${teacherData.contactNo}</td>
                            <td>${teacherData.gender}</td>
                            <td>${teacherData.emailId}</td>
                            <td>${teacherData.dateOfbirth}</td>
                            <td>${teacherData.department}</td>
                            <td>${teacherData.address}</td>

                            <!-- Edit Button -->
                            <td>
                                <a href="TeacherServlet?option=getDatabyIdeditForm&teacherId=${teacherData.teacherId}"
                                   class="btn btn-sm btn-info text-white">
                                    Edit
                                </a>
                            </td>

                            <!-- Delete Button -->
                            <td>
                                <a href="TeacherServlet?option=deleteData&teacherId=${teacherData.teacherId}"
                                   class="btn btn-sm btn-danger">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>

</body>
