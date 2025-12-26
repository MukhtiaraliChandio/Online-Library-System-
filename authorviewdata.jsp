<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>List of Author Data</title>

<!-- ✅ Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- ✅ Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">

<style>
    body {
        background-image: url("form.jpg");
        background-size: cover;
        background-position: center;
        font-family: 'Poppins', sans-serif;
        padding: 40px;
    }

    .data-container {
        background-color: rgba(0, 0, 0, 0.6);
        border-radius: 15px;
        padding: 25px;
        box-shadow: 0 0 25px rgba(0, 0, 0, 0.6);
        backdrop-filter: blur(8px);
        max-width: 100%;
        margin: auto;
    }

    h2 {
        text-align: center;
        color: #ffffff;
        font-weight: 600;
        margin-bottom: 25px;
        letter-spacing: 1px;
        text-transform: uppercase;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #ffffff;
        color: #212529;
        font-size: 14px;
        border: 1px solid #000;
    }

    thead th {
        background-color: #007bff;
        color: #fff;
        text-align: center;
        padding: 10px;
        border: 1px solid #000;
    }

    tbody td {
        text-align: center;
        vertical-align: middle;
        padding: 8px;
        border: 1px solid #000;
    }

    tbody tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tbody tr:hover {
        background-color: #dbe9ff;
        transition: 0.3s;
    }

    /* ✅ Buttons */
    .btn-action {
        border: none;
        padding: 4px 10px;
        border-radius: 5px;
        font-size: 12px;
        transition: 0.3s;
        color: white;
        text-decoration: none;
    }

    .btn-edit {
      background-color: #00bfff; /* Sky Blue */
    }
   .btn-edit:hover {
      background-color: #009acd; /* Slightly darker blue on hover */
    }

    .btn-delete {
        background-color: #dc3545;
    }
    .btn-delete:hover {
        background-color: #bb2d3b;
    }
</style>
</head>

<body>
    <div class="data-container">
        <h2>List of Author Data</h2>

        <table class="table align-middle">
            <thead>
                <tr>
                    <th>Author ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Father Name</th>
                    <th>Surname</th>
                    <th>Contact Number</th>
                    <th>CNIC</th>
                    <th>Gender</th>
                    <th>Email ID</th>
                    <th>Current Address</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="authorallData" items="${authorData}">
                    <tr>
                        <td>${authorallData.authorId}</td>
                        <td>${authorallData.firstName}</td>
                        <td>${authorallData.lastName}</td>
                        <td>${authorallData.fatherName}</td>
                        <td>${authorallData.surname}</td>
                        <td>${authorallData.contactNo}</td>
                        <td>${authorallData.cnic}</td>
                        <td>${authorallData.gender}</td>
                        <td>${authorallData.emailId}</td>
                        <td>${authorallData.address}</td>

                        <td>
                            <a href="AuthorServlet?option=getAuthordatabyIdeditForm&authorId=${authorallData.authorId}" 
                               class="btn-action btn-edit">Edit</a>
                        </td>
                        <td>
                            <a href="AuthorServlet?option=deleteAuthordataByid&authorId=${authorallData.authorId}" 
                               class="btn-action btn-delete">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

<!-- ✅ Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
