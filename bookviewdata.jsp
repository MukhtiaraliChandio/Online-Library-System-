<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>List of Book Data</title>

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

    /* 🌤️ Sky Blue Edit Button */
    .btn-edit {
        background-color: #00bfff;
    }
    .btn-edit:hover {
        background-color: #009acd;
    }

    /* 🔴 Delete Button */
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
        <h2>List of Book Data</h2>



<br>

        <table class="table align-middle">
            <thead>
                <tr>
                    <th>Author ID</th>
                    <th>Book ID</th>
                    <th>Book Category</th>
                    <th>Book Name</th>
                    <th>Language</th>
                    <th>Author Editor</th>
                    <th>Editor Volume</th>
                    <th>Year of Publishing</th>
                    <th>ISBN</th>
                    <th>Number of Pages</th>
                    <th>Remarks</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="bookAlldata" items="${bookData}">
                    <tr>
                        <td>${bookAlldata.authorId}</td>
                        <td>${bookAlldata.bookId}</td>
                        <td>${bookAlldata.bookCategory}</td>
                        <td>${bookAlldata.bookName}</td>
                        <td>${bookAlldata.language}</td>
                        <td>${bookAlldata.authorEditor}</td>
                        <td>${bookAlldata.editorVolume}</td>
                        <td>${bookAlldata.yearOfpublishing}</td>
                        <td>${bookAlldata.isbn}</td>
                        <td>${bookAlldata.numberOfpages}</td>
                        <td>${bookAlldata.remarks}</td>

                        <td>
                            <a href="BookServlet?option=getDatabookByIdeditForm&bookId=${bookAlldata.bookId}" 
                               class="btn-action btn-edit">Edit</a>
                        </td>
                        <td>
                            <a href="BookServlet?option=deleteBookdataByid&bookId=${bookAlldata.bookId}" 
                               class="btn-action btn-delete">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody id="bookTable">
        </table>
    </div>

<!-- ✅ Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>






</body>

</html>
