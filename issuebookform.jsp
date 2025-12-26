<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Book Issue Form</title>

<!-- ✅ Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: url('form.jpg') no-repeat center center fixed;
    background-size: cover;
    font-family: 'Poppins', sans-serif;
}
.form-container {
    background-color: rgba(0, 0, 0, 0.7);
    color: white;
    border-radius: 12px;
    padding: 30px;
    max-width: 600px;
    margin: 80px auto;
    box-shadow: 0 0 20px rgba(0,0,0,0.5);
}
.form-title {
    text-align: center;
    margin-bottom: 25px;
    font-weight: bold;
    text-transform: uppercase;
    color: #f1f1f1;
}
label {
    font-weight: 500;
}
.btn-custom {
    width: 48%;
}
</style>
</head>

<body>

<div class="form-container">
    <h2 class="form-title">📚 Book Issue Form</h2>

    <form action="ServletBookIusse" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="option" value="insertIssuebookvalue">
        
        <!-- Librarian -->
        <div class="mb-3">
            <label for="librarian" class="form-label">Select Librarian Name</label>
            <select class="form-select" name="librarianId" id="librarian">
                <c:forEach var="lib" items="${libListdata}">
                    <option value="${lib.librarainId}">
                        ${lib.firstName} ${lib.lastName}
                    </option>
                </c:forEach>
            </select>
        </div>

        <!-- Book -->
        <div class="mb-3">
            <label for="book" class="form-label">Select Book Name</label>
            <select class="form-select" name="bookId" id="book">
                <c:forEach var="book" items="${bookListdata}">
                    <option value="${book.bookId}">
                        ${book.bookName}
                    </option>
                </c:forEach>
            </select>
        </div>

        <!-- Issue Date -->
        <div class="mb-3">
            <label for="issueDate" class="form-label">Date of Issue</label>
            <input type="date" class="form-control" id="issueDate" name="dateOfIssue">
        </div>

        <!-- Due Date -->
        <div class="mb-3">
            <label for="dueDate" class="form-label">Due Date</label>
            <input type="date" class="form-control" id="dueDate" name="dateOfDueDate">
        </div>

        <!-- Remarks -->
        <div class="mb-3">
            <label for="remarks" class="form-label">Remarks</label>
            <textarea class="form-control" id="remarks" name="remarks" rows="4" placeholder="Enter any remarks here..."></textarea>
        </div>

        <!-- Buttons -->
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success btn-custom">Submit</button>
            <button type="reset" class="btn btn-secondary btn-custom">Reset</button>
        </div>
    </form>
</div>

<!-- ✅ JavaScript Validation -->
<script>
function validateForm() {
    let librarian = document.getElementById("librarian").value.trim();
    let book = document.getElementById("book").value.trim();
    let issueDate = document.getElementById("issueDate").value.trim();
    let dueDate = document.getElementById("dueDate").value.trim();
    let remarks = document.getElementById("remarks").value.trim();

    // Check if librarian selected
    if (librarian === "") {
        alert("Please select a Librarian Name.");
        document.getElementById("librarian").focus();
        return false;
    }

    // Check if book selected
    if (book === "") {
        alert("Please select a Book Name.");
        document.getElementById("book").focus();
        return false;
    }

    // Validate issue date
    if (issueDate === "") {
        alert("Please enter the Date of Issue.");
        document.getElementById("issueDate").focus();
        return false;
    }

    // Validate due date
    if (dueDate === "") {
        alert("Please enter the Due Date.");
        document.getElementById("dueDate").focus();
        return false;
    }

    // Check that due date is after issue date
    if (new Date(dueDate) < new Date(issueDate)) {
        alert("Due Date must be after the Date of Issue.");
        document.getElementById("dueDate").focus();
        return false;
    }

    if (remarks === "") {
        alert("Please enter remarks.");
        document.getElementById("remarks").focus();
        return false;
    }

    if (remarks.length < 3) {
        alert("Remarks must be at least 3 characters long.");
        document.getElementById("remarks").focus();
        return false;
    }

    // ✅ All checks passed
    return true;
}
</script>

<!-- ✅ Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
