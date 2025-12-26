<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Registration Form</title>
<style>
body {
  background-image: url('form.jpg');
  background-position: center;
  background-size: cover;
  font-family: sans-serif;
  margin-top: 40px;
  color: #fff;
}

.regform {
  width: 600px;
  background-color: rgba(0,0,0,0.6);
  margin: auto;
  padding: 10px 0;
  text-align: center;
  border-radius: 10px 10px 0 0;
}

.main {
  width: 600px;
  background-color: rgba(0,0,0,0.5);
  margin: auto;
  padding: 20px;
  border-radius: 0 0 10px 10px;
}

.form-group {
  margin-bottom: 15px;
  text-align: center;
}

label {
  display: block;
  margin-bottom: 6px;
  text-transform: capitalize;
}

input[type="text"], select, textarea {
  width: 80%;
  padding: 8px;
  border-radius: 6px;
  border: none;
  font-size: 14px;
}

textarea {
  resize: none;
}

input[type="submit"], input[type="reset"] {
  padding: 8px 20px;
  border: none;
  border-radius: 6px;
  background-color: #4CAF50;
  color: white;
  cursor: pointer;
  margin: 10px;
}

input[type="submit"]:hover, input[type="reset"]:hover {
  background-color: #45a049;
}
</style>
</head>
<body>

<div class="regform">
  <h1>Book Registration Form</h1>
</div>

<div class="main">
  <!-- ✅ Add validation call -->
  <form action="BookServlet" method="post" onsubmit="return validateBookForm()">
    <input type="hidden" name="option" value="insertbookdata">

    <div class="form-group">
        <label>Select Author:</label>
        <select name="author" id="author">
            <c:forEach var="author" items="${authors}">
                <option value="${author.authorId}">
                    ${author.firstName} ${author.lastName}
                </option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
      <label>Book Name</label>
      <input type="text" name="bookName" maxlength="50">
    </div>

    <div class="form-group">
      <label>Book Category</label>
      <select name="category" id="category">
        <c:forEach var="category" items="${categories}">
          <option value="${category.categoryId}">${category.bookCategory}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <label>Language</label>
      <input type="text" name="language" maxlength="50">
    </div>

    <div class="form-group">
      <label>Author Editor</label>
      <input type="text" name="authoreditor" maxlength="50">
    </div>

    <div class="form-group">
      <label>Editor Volume</label>
      <input type="text" name="editorVolume" maxlength="50">
    </div>

    <div class="form-group">
      <label>Year of Publishing</label>
      <input type="text" name="yearOfpublishing" maxlength="4">
    </div>

    <div class="form-group">
      <label>ISBN</label>
      <input type="text" name="isbn" maxlength="13">
    </div>

    <div class="form-group">
      <label>No. of Pages</label>
      <input type="text" name="noOfpages" maxlength="5">
    </div>

    <div class="form-group">
      <label>Remarks</label>
      <textarea rows="4" cols="50" name="remarks"></textarea>
    </div>

    <div class="form-group">
      <input type="submit" value="Send">
      <input type="reset" value="Reset">
    </div>
  </form>
</div>

<script>
function validateBookForm() {
  const form = document.forms[0];

  const bookName = form["bookName"].value.trim();
  const language = form["language"].value.trim();
  const authorEditor = form["authoreditor"].value.trim();
  const editorVolume = form["editorVolume"].value.trim();
  const year = form["yearOfpublishing"].value.trim();
  const isbn = form["isbn"].value.trim();
  const pages = form["noOfpages"].value.trim();
  const remarks = form["remarks"].value.trim();

  // ✅ 1. Required fields check
  if (!bookName || !language || !authorEditor || !editorVolume || !year || !isbn || !pages || !remarks) {
    alert("⚠️ Please fill out all fields before submitting.");
    return false;
  }

  // ✅ 2. Year: must be 4 digits (e.g. 2024)
  const yearPattern = /^[0-9]{4}$/;
  if (!yearPattern.test(year)) {
    alert("Enter a valid 4-digit year (e.g., 2025).");
    return false;
  }

  // ✅ 3. ISBN: must be 10 or 13 digits
  const isbnPattern = /^(?:\d{10}|\d{13})$/;
  if (!isbnPattern.test(isbn)) {
    alert("Enter a valid ISBN number (10 or 13 digits).");
    return false;
  }

  // ✅ 4. Pages: must be a positive number
  const pagePattern = /^[1-9][0-9]*$/;
  if (!pagePattern.test(pages)) {
    alert("Number of pages must be a positive number.");
    return false;
  }

  // ✅ 5. Text-only check for Book Name and Language
  const textPattern = /^[A-Za-z\s]+$/;
  if (!textPattern.test(bookName) || !textPattern.test(language)) {
    alert("Book Name and Language should contain only letters.");
    return false;
  }

  // ✅ 6. Everything passed
  alert("✅ Form validated successfully!");

  

  return true; // ✅ Passed all checks
}
</script>


</body>
</html>
