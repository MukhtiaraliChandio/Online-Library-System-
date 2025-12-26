<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Librarian Data List</title>

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

    /* ✅ White table with black borders */
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

    /* ✅ Action buttons */
    .btn-action {
        border: none;
        padding: 4px 10px;
        border-radius: 5px;
        font-size: 12px;
        transition: 0.3s;
        color: white;
    }

    .btn-edit {
        background-color: #007bff;
    }
    .btn-edit:hover {
        background-color: #0069d9;
    }

    .btn-delete {
        background-color: #dc3545;
    }
    .btn-delete:hover {
        background-color: #b52a36;
    }
</style>
</head>

<body>
    <div class="data-container">
        <h2>List of Librarian Data</h2>

        <table class="table align-middle">
            <thead>
                <tr>
                    <th>Librarian ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Father Name</th>
                    <th>Surname</th>
                    <th>Contact Number</th>
                    <th>CNIC</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="libraryData" items="${libData}">
                    <tr>
                        <td>${libraryData.librarainId}</td>
                        <td>${libraryData.firstName}</td>
                        <td>${libraryData.lastName}</td>
                        <td>${libraryData.fatherName}</td>
                        <td>${libraryData.surname}</td>
                        <td>${libraryData.contactNumber}</td>
                        <td>${libraryData.cnic}</td>
                        <td>${libraryData.emailId}</td>
                        <td>${libraryData.gender}</td>
                        <td>${libraryData.address}</td>

                        <td>
                            <a href="LibrarainServlet?option=getDatabyIdeditForm&librarainId=${libraryData.librarainId}" 
                               class="btn-action btn-edit">Edit</a>
                        </td>
                        <td>
                            <a href="LibrarainServlet?option=deleteDatalib&librarainId=${libraryData.librarainId}" 
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
