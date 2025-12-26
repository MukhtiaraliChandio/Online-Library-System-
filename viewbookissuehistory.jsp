<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Book Issue History List</title>

<!-- ✅ Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- ✅ Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">

<style>
   body {
		    min-height: 100vh;
		    background: url("form.jpg") no-repeat center center fixed;
		    background-size: cover;
		    font-family: 'Poppins', sans-serif;
		    margin: 0;
		    padding: 20px;

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

    .btn-action {
        border: none;
        padding: 4px 10px;
        border-radius: 5px;
        font-size: 12px;
        transition: 0.3s;
        color: white;
        text-decoration: none;
    }

    .btn-fine {
        background-color: #28a745;
    }
    .btn-fine:hover {
        background-color: #1e7e34;
    }
</style>
</head>

<body>
<div class="data-container">
    <h2>Book Issue History List</h2>

    <table class="table align-middle">
        <thead>
            <tr>
                
                <th>Issue ID</th>
                <th>Book Name</th>
                <th>Librarian Name</th>
                <th>Date of Issue</th>
                <th>Due Date</th>
                <th>Date of Return</th>
                <th>Fine</th>
                <th>Remarks</th>
                <th>Action</th>
            </tr>
        </thead>
<tbody>
        <tr>       
            <c:forEach var="bookIssuedata" items="${historyList}">
                     <!-- ✅ Direct Book Issue Data -->
                     
                     
                     <td>${bookIssuedata.bookIssueid}</td>
                    <td>${bookIssuedata.bookName}</td>
                    <td>${bookIssuedata.librarianFirstname}${bookIssuedata.librarianLastname}</td>
                    <td>${bookIssuedata.dateOfissue}</td>
                    <td>${bookIssuedata.dueDate}</td>
                    <td>${bookIssuedata.dateOfreturne}</td>
                    <td>${bookIssuedata.fine}</td>
                    <td>${bookIssuedata.remarks}</td>

                    <td>
                        <a href="ServletBookIusse?option=getbookreturnnamelist" class="btn-action btn-fine">Open Fine Form</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
