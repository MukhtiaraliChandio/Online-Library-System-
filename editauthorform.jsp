<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Author Registration Form</title>

<!-- ✅ Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- ✅ Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

<style>
body {
  background: url('form.jpg') no-repeat center center fixed;
  background-size: cover;
  font-family: 'Poppins', sans-serif;
}

.form-container {
  background: rgba(0, 0, 0, 0.7);
  border-radius: 15px;
  padding: 40px;
  max-width: 800px;
  margin: 60px auto;
  color: #fff;
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.6);
  backdrop-filter: blur(8px);
}

.form-title {
  text-align: center;
  font-weight: 600;
  text-transform: uppercase;
  margin-bottom: 30px;
  color: #f8f9fa;
}

label {
  font-weight: 500;
}

.btn-custom {
  width: 48%;
}

.error {
  color: #ff6b6b;
  font-size: 14px;
  margin-top: 5px;
}
</style>
</head>

<body>
<div class="container">
  <div class="form-container">
    <h2 class="form-title">✏️ Edit Author Registration</h2>

    <form action="AuthorServlet" method="post" onsubmit="return validateForm()">
      <input type="hidden" name="option" value="updateData">

      <!-- Row 1 -->
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="authorId" class="form-label">Author ID</label>
          <input type="text" class="form-control" id="authorId" name="authorId" 
                 value="${authorData.authorId}" readonly>
        </div>
        <div class="col-md-6">
          <label for="firstName" class="form-label">First Name</label>
          <input type="text" class="form-control" id="firstName" name="firstname" 
                 value="${authorData.firstName}" required>
        </div>
      </div>

      <!-- Row 2 -->
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="lastName" class="form-label">Last Name</label>
          <input type="text" class="form-control" id="lastName" name="lastname" 
                 value="${authorData.lastName}" required>
        </div>
        <div class="col-md-6">
          <label for="fatherName" class="form-label">Father's Name</label>
          <input type="text" class="form-control" id="fatherName" name="fatherName" 
                 value="${authorData.fatherName}" required>
        </div>
      </div>

      <!-- Row 3 -->
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="surname" class="form-label">Surname</label>
          <input type="text" class="form-control" id="surname" name="surname" 
                 value="${authorData.surname}" required>
        </div>
        <div class="col-md-6">
          <label for="contactNumber" class="form-label">Contact Number</label>
          <input type="text" class="form-control" id="contactNumber" name="contactNumber" 
                 value="${authorData.contactNo}" required>
        </div>
      </div>

      <!-- Row 4 -->
      <div class="row mb-3">
        <div class="col-md-6">
          <label for="cnicNumber" class="form-label">CNIC Number</label>
          <input type="text" class="form-control" id="cnicNumber" name="cnicNumber" 
                 value="${authorData.cnic}" required>
        </div>
        <div class="col-md-6">
          <label for="emailId" class="form-label">Email ID</label>
          <input type="email" class="form-control" id="emailId" name="emailId" 
                 value="${authorData.emailId}" required>
        </div>
      </div>

      <!-- Gender -->
      <div class="mb-3">
        <label class="form-label">Gender</label><br>
        <c:forEach var="gender" items="${authorallgenders}">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" value="${gender}"
                   <c:if test="${gender == authorselectedGender}">checked</c:if>>
            <label class="form-check-label">${gender}</label>
          </div>
        </c:forEach>
      </div>

      <!-- Address -->
      <div class="mb-4">
        <label for="address" class="form-label">Address</label>
        <textarea class="form-control" id="address" name="address" rows="3"
                  placeholder="Enter full address...">${authorData.address}</textarea>
      </div>

      <!-- Buttons -->
      <div class="d-flex justify-content-between">
        <button type="submit" class="btn btn-success btn-custom">Update</button>
      </div>
    </form>
  </div>
</div>

<!-- ✅ JS Validation -->

<script>
function validateAuthorForm() {

    // Get values
    let firstName = document.getElementById("firstName").value.trim();
    let lastName = document.getElementById("lastName").value.trim();
    let fatherName = document.getElementById("fatherName").value.trim();
    let surname = document.getElementById("surname").value.trim();
    let contact = document.getElementById("contactNumber").value.trim();
    let cnic = document.getElementById("cnicNumber").value.trim();
    let email = document.getElementById("emailId").value.trim();
    let address = document.getElementById("address").value.trim();

    // Name validation (letters only)
    let namePattern = /^[A-Za-z\s]+$/;

    if (!namePattern.test(firstName)) {
        alert("Please enter a valid First Name");
        return false;
    }

    if (!namePattern.test(lastName)) {
        alert("Please enter a valid Last Name");
        return false;
    }

    if (!namePattern.test(fatherName)) {
        alert("Please enter a valid Father's Name");
        return false;
    }

    // Contact number (11 digits)
    if (!/^\d{11}$/.test(contact)) {
        alert("Please enter a valid 11-digit Contact Number");
        return false;
    }

    // CNIC (13 digits)
    if (!/^\d{13}$/.test(cnic)) {
        alert("Please enter a valid 13-digit CNIC number");
        return false;
    }

    // Email
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid Email address");
        return false;
    }

    // Gender check
    let genderSelected = document.querySelector('input[name="gender"]:checked');
    if (!genderSelected) {
        alert("Please select Gender");
        return false;
    }

    // Address
    if (address.length < 5) {
        alert("Please enter a valid Address");
        return false;
    }

    return true; // submit form
}
</script>


<!-- ✅ Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
