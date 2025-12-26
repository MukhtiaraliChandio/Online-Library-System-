<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Librarian Dashboard - Search Books</title>

<!-- ✅ Bootstrap 5 ONLY -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- ✅ Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">

<style>
    body {
        background: url("form.jpg") no-repeat center center fixed;
        background-size: cover;
        font-family: 'Poppins', sans-serif;
        min-height: 100vh;
        padding: 40px;
    }

    /* Glass container */
    .data-container {
        background: rgba(0, 0, 0, 0.65);
        border-radius: 15px;
        padding: 30px;
        box-shadow: 0 0 25px rgba(0, 0, 0, 0.6);
        backdrop-filter: blur(8px);
    }

    h2 {
        text-align: center;
        color: #fff;
        font-weight: 600;
        margin-bottom: 25px;
        text-transform: uppercase;
    }

    /* Table styling */
    table {
        background-color: #fff;
        font-size: 14px;
    }

    thead th {
        background-color: #0d6efd;
        color: #fff;
        text-align: center;
        vertical-align: middle;
    }

    tbody td {
        text-align: center;
        vertical-align: middle;
    }

    tbody tr:hover {
        background-color: #eaf2ff;
    }

    /* Search bar */
    .search-box input {
        height: 45px;
        border-radius: 8px 0 0 8px;
    }

    .search-box button {
        height: 45px;
        border-radius: 0 8px 8px 0;
    }
</style>
</head>

<body>

<div class="container-fluid">
    <div class="data-container">

        <h2>Search Books</h2>

        <!-- 🔍 Search Form -->
        <form action="SearchServlet" method="get" class="mb-4">
            <div class="input-group search-box">
                <input type="text" name="keyword" class="form-control"
                       placeholder="Search by book name, category, author" required>
                <button class="btn btn-primary" type="submit">
                    🔍 Search
                </button>
            </div>
        </form>

        <!-- 📚 Book Table -->
        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Author ID</th>
                        <th>Book ID</th>
                        <th>Category</th>
                        <th>Book Name</th>
                        <th>Language</th>
                        <th>Author/Editor</th>
                        <th>Volume</th>
                        <th>Year</th>
                        <th>ISBN</th>
                        <th>Pages</th>
                        <th>Remarks</th>
                    </tr>
                </thead>

                <tbody>
                    <c:choose>
                        <c:when test="${not empty bookList}">
                            <c:forEach var="bookAlldata" items="${bookList}">
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
                                </tr>
                            </c:forEach>
                        </c:when>

                        <c:otherwise>
                            <tr>
                                <td colspan="11" class="text-center text-danger fw-bold">
                                    No books found
                                </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>

    </div>
</div>

</body>
</html>
