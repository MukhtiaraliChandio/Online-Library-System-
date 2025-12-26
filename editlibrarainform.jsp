<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Librarian</title>

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

.form-control, textarea {
  border-radius: 8px;
}

textarea {
  resize: none;
}
</style>
</head>
<body>

<div class="container">
  <h2>👨‍💼 Edit Librarian Details</h2>
  <form action="LibrarainServlet" method="post" onsubmit="return validateForm()">
    <input type="hidden" name="option" value="updateDatalib">

    <div class="mb-3">
      <label for="librarainId" class="form-label">Librarian ID</label>
      <input type="text" class="form-control" id="librarainId" name="librarainId"
             value="${libData.librarainId}" readonly>
    </div>

    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="firstname" class="form-label">First Name</label>
        <input type="text" class="form-control" id="firstname" name="firstname"
               value="${libData.firstName}" required>
      </div>
      <div class="col-md-6 mb-3">
        <label for="lastname" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="lastname" name="lastname"
               value="${libData.lastName}" required>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="fathername" class="form-label">Father Name</label>
        <input type="text" class="form-control" id="fathername" name="fathername"
               value="${libData.fatherName}" required>
      </div>
      <div class="col-md-6 mb-3">
        <label for="surname" class="form-label">Surname</label>
        <input type="text" class="form-control" id="surname" name="surname"
               value="${libData.surname}" required>
      </div>
    </div>

    <div class="mb-3">
      <label for="cnic" class="form-label">CNIC</label>
      <input type="text" class="form-control" id="cnic" name="cnic"
             value="${libData.cnic}" required>
    </div>

    <div class="mb-3">
      <label for="contactNo" class="form-label">Contact Number</label>
      <input type="text" class="form-control" id="contactNo" name="contactNo"
             value="${libData.contactNumber}" required>
    </div>

    <div class="mb-3">
      <label for="email" class="form-label">Email ID</label>
      <input type="email" class="form-control" id="email" name="email"
             value="${libData.emailId}" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Select Gender</label><br>
      <c:forEach var="gender" items="${librarainallgenders}">
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="gender" value="${gender}"
                 <c:if test="${gender == libraryselectedGender}">checked</c:if>>
          <label class="form-check-label">${gender}</label>
        </div>
      </c:forEach>
    </div>

    <div class="mb-3">
      <label for="address" class="form-label">Current Address</label>
      <textarea class="form-control" id="address" name="address" rows="3" required>${libData.address}</textarea>
    </div>

    <div class="d-flex justify-content-between">
      <button type="submit" class="btn btn-primary">💾 Update</button>
    </div>
  </form>
</div>

<!-- ✅ JavaScript Validation -->
<script>
function validateForm() {
  const fields = ["firstname", "lastname", "fathername", "surname", "cnic", "contactNo", "email", "address"];
  for (let id of fields) {
    const value = document.getElementById(id).value.trim();
    if (value === "") {
      alert("Please fill all required fields.");
      return false;
    }
  }

  const email = document.getElementById("email").value;
  const cnic = document.getElementById("cnic").value;
  const contact = document.getElementById("contactNo").value;

  if (!/^[0-9]{13}$/.test(cnic)) {
    alert("CNIC must be 13 digits only.");
    return false;
  }

  if (!/^[0-9]{10,11}$/.test(contact)) {
    alert("Enter a valid contact number (10–11 digits).");
    return false;
  }

  const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
  if (!email.match(emailPattern)) {
    alert("Please enter a valid email address.");
    return false;
  }

  return true;
}
</script>

<!-- ✅ Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
