<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Book</title>

<!-- ✅ Bootstrap 5 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- ✅ Custom CSS -->
<style>
body {
  background: url('form.jpg') no-repeat center center fixed;
  background-size: cover;
  font-family: 'Poppins', sans-serif;
  min-height: 100vh;
}

.container {
  max-width: 700px;
  margin-top: 60px;
  background: rgba(0, 0, 0, 0.75);
  border-radius: 15px;
  color: #fff;
  padding: 30px 40px;
  box-shadow: 0 4px 25px rgba(0, 0, 0, 0.3);
}

h2 {
  text-align: center;
  margin-bottom: 25px;
  font-weight: 600;
  letter-spacing: 1px;
  color: #f8f9fa;
}

label {
  font-weight: 500;
  color: #f1f1f1;
}

.btn-primary {
  width: 45%;
  border-radius: 25px;
  font-weight: 600;
  background-color: #0d6efd;
  transition: all 0.3s;
}

.btn-primary:hover {
  background-color: #0b5ed7;
  transform: scale(1.05);
}

.btn-secondary {
  width: 45%;
  border-radius: 25px;
  font-weight: 600;
}

.form-control, select, textarea {
  border-radius: 8px;
}

textarea {
  resize: none;
}
</style>
</head>
<body>

<div class="container">
  <h2>📚 Edit Book Details</h2>
  <form action="BookServlet" method="post" onsubmit="return validateForm()">
    <input type="hidden" name="option" value="updatebookdata">

    <div class="mb-3">
      <label for="authorId" class="form-label">Author ID</label>
      <input type="text" class="form-control" id="authorId" name="authorId" value="${bookData.authorId}">
    </div>

    <div class="mb-3">
      <label for="bookId" class="form-label">Book ID</label>
      <input type="text" class="form-control" id="bookId" name="bookId" value="${bookData.bookId}">
    </div>

    <div class="mb-3">
      <label for="bookName" class="form-label">Book Name</label>
      <input type="text" class="form-control" id="bookName" name="bookName" value="${bookData.bookName}">
    </div>

    <div class="mb-3">
      <label for="category" class="form-label">Book Category</label>
      <select class="form-select" id="category" name="category">
        <c:forEach var="category" items="${categories}">
          <option value="${category.categoryId}"
            ${bookData.categoryId == category.categoryId ? 'selected' : ''}>
            ${category.bookCategory}
          </option>
        </c:forEach>
      </select>
    </div>

    <div class="mb-3">
      <label for="language" class="form-label">Language</label>
      <input type="text" class="form-control" id="language" name="language" value="${bookData.language}">
    </div>

    <div class="mb-3">
      <label for="authoreditor" class="form-label">Author Editor</label>
      <input type="text" class="form-control" id="authoreditor" name="authoreditor" value="${bookData.authorEditor}">
    </div>

    <div class="mb-3">
      <label for="editorVolume" class="form-label">Editor Volume</label>
      <input type="text" class="form-control" id="editorVolume" name="editorVolume" value="${bookData.editorVolume}">
    </div>

    <div class="mb-3">
      <label for="yearOfpublishing" class="form-label">Year of Publishing</label>
      <input type="text" class="form-control" id="yearOfpublishing" name="yearOfpublishing" value="${bookData.yearOfpublishing}">
    </div>

    <div class="mb-3">
      <label for="isbn" class="form-label">ISBN</label>
      <input type="text" class="form-control" id="isbn" name="isbn" value="${bookData.isbn}">
    </div>

    <div class="mb-3">
      <label for="noOfpages" class="form-label">Number of Pages</label>
      <input type="text" class="form-control" id="noOfpages" name="noOfpages" value="${bookData.numberOfpages}">
    </div>

    <div class="mb-3">
      <label for="remarks" class="form-label">Remarks</label>
      <textarea class="form-control" id="remarks" name="remarks" rows="4">${bookData.remarks}</textarea>
    </div>

    <div class="d-flex justify-content-between">
      <button type="submit" class="btn btn-primary">💾 Update</button>
    </div>
  </form>
</div>

<!-- ✅ JavaScript Validation -->
<script>
function validateForm() {
  const requiredFields = ["bookName", "category", "language", "authoreditor", "editorVolume", "yearOfpublishing", "isbn", "noOfpages"];
  
  for (let field of requiredFields) {
    const value = document.getElementById(field).value.trim();
    if (value === "") {
      alert("Please fill out all required fields.");
      return false;
    }
  }

  const year = document.getElementById("yearOfpublishing").value;
  const isbn = document.getElementById("isbn").value;
  const pages = document.getElementById("noOfpages").value;

  if (isNaN(year)) {
    alert("Year of publishing must be a number.");
    return false;
  }

  if (!/^[0-9]+$/.test(isbn)) {
    alert("ISBN must contain only numbers.");
    return false;
  }

  if (isNaN(pages)) {
    alert("Number of pages must be a valid number.");
    return false;
  }

  return true;
}
</script>

<!-- ✅ Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
