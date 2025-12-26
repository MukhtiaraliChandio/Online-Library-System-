<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Book Return Form</title>

<!-- ✅ Bootstrap 5 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">

<style>
body {
    background: url('form.jpg') no-repeat center center fixed;
    background-size: cover;
    font-family: 'Poppins', sans-serif;
    min-height: 100vh;
}
.form-container {
    background-color: rgba(0, 0, 0, 0.75);
    color: white;
    border-radius: 12px;
    padding: 35px;
    max-width: 600px;
    margin: 80px auto;
    box-shadow: 0 0 25px rgba(0,0,0,0.5);
    backdrop-filter: blur(5px);
}
.form-title {
    text-align: center;
    margin-bottom: 30px;
    font-weight: 600;
    letter-spacing: 1px;
}
label {
    font-weight: 500;
    color: #f1f1f1;
}
.btn-custom {
    width: 48%;
    font-weight: 500;
}
input, select, textarea {
    border-radius: 8px !important;
}
</style>

</head>
<body>

<div class="form-container">
    <h2 class="form-title">📘 Book Return Form</h2>

<form action="UpdateResturneIssueBookServlet" method="post" onsubmit="return validateForm()">
        

        <!-- Librarian ID -->
             <div> 
<label for="librarian" class="form-label">Select Librarian Name</label>
<select class="form-select" name="librarianId" id="librarian" required>
   
    <c:forEach var="lib" items="${libListdata}">
        <option value="${lib.librarainId}">
            ${lib.firstName} ${lib.lastName}
        </option>
    </c:forEach>
</select>


        </div>
        
       <!-- Book -->
        <div class="mb-3">
            <label for="book" class="form-label">Select Book Name </label>
            <select class="form-select" name="bookId" id="book" required>
               
                <c:forEach var="book" items="${bookListdata}">
                    <option value="${book.bookId}">
                        ${book.bookName}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="dueDate" class="form-label">BookIssueId </label>
            <input type="text" class="form-control" id="bookIssueid" name="bookIssueid" required>
        </div>
        

    

         <!-- Fine -->
        <div class="mb-3">
            <label for="fine" class="form-label">Fine</label>
            <input type="text" class="form-control" id="fine" name="fine" placeholder="Enter Value of Fine"  required>
        </div>

        <!-- Return Date -->
        <div class="mb-3">
            <label for="returnDate" class="form-label">Date of Returne</label>
            <input type="date" class="form-control" id="returnDate" name="dateOfReturne" required>
        </div>

        <!-- Remarks -->
        <div class="mb-3">
            <label for="remarks" class="form-label">Remarks</label>
            <textarea class="form-control" id="remarks" name="remarks" rows="4" placeholder="Enter remarks (optional)..."></textarea>
        </div>

        <!-- Buttons -->
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success btn-custom">Update</button>
            <button type="reset" class="btn btn-secondary btn-custom">Reset</button>
        </div>
    </form>
</div>

<!-- ✅ Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
