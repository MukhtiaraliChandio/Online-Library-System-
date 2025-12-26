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
<title>Edit Teacher Registration</title>

<!-- ✅ Bootstrap 5 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- ✅ Custom CSS -->
<style>
body {
  background: url('form.jpg') no-repeat center center fixed;
  background-size: cover;
  font-family: 'Poppins', sans-serif;
  min-height: 100vh;
  color: #fff;
}

.container {
  max-width: 750px;
  background: rgba(0, 0, 0, 0.75);
  border-radius: 15px;
  margin-top: 60px;
  padding: 40px 50px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
  backdrop-filter: blur(6px);
}

h2 {
  text-align: center;
  font-weight: 600;
  margin-bottom: 25px;
  letter-spacing: 1px;
  color: #f8f9fa;
}

label {
  font-weight: 500;
  color: #f1f1f1;
}

.btn-primary, .btn-secondary {
  border-radius: 25px;
  font-weight: 600;
  width: 45%;
}

.btn-primary {
  background-color: #0d6efd;
  transition: all 0.3s ease;
}

.btn-primary:hover {
  background-color: #0b5ed7;
  transform: scale(1.05);
}

textarea {
  resize: none;
}

input:focus, textarea:focus {
  box-shadow: 0 0 5px #0d6efd;
  border-color: #0d6efd;
}

</style>
</head>

<body>

<div class="container">
  <h2>👨‍🏫 Edit Teacher Registration</h2>
  <form action="TeacherServlet" method="post" onsubmit="return validateForm()">
    <input type="hidden" name="option" value="updateData">

    <!-- User ID -->
    <div class="mb-3">
      <label class="form-label">User ID</label>
      <input type="text" class="form-control" name="userId" value="${teacherData.userId}" readonly>
    </div>

    <!-- Teacher ID -->
    <div class="mb-3">
      <label class="form-label">Teacher ID</label>
      <input type="text" class="form-control" name="teacherId" value="${teacherData.teacherId}" required>
    </div>

    <!-- Name Fields -->
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label">First Name</label>
        <input type="text" class="form-control" id="firstname" name="firstname" value="${teacherData.firstName}" required>
      </div>
      <div class="col-md-6 mb-3">
        <label class="form-label">Last Name</label>
        <input type="text" class="form-control" id="lastname" name="lastname" value="${teacherData.lastName}" required>
      </div>
    </div>

    <!-- Father Name & Surname -->
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label">Father's Name</label>
        <input type="text" class="form-control" id="fatherName" name="fatherName" value="${teacherData.fatherName}" required>
      </div>
      <div class="col-md-6 mb-3">
        <label class="form-label">Surname</label>
        <input type="text" class="form-control" id="surname" name="surname" value="${teacherData.surname}" required>
      </div>
    </div>

    <!-- Contact & CNIC -->
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label">Contact Number</label>
        <input type="text" class="form-control" id="contactNumber" name="contactNumber" value="${teacherData.contactNo}" required>
      </div>
      <div class="col-md-6 mb-3">
        <label class="form-label">CNIC Number</label>
        <input type="text" class="form-control" id="cnicNumber" name="cnicNumber" value="${teacherData.cnic}" required>
      </div>
    </div>

    <!-- Email -->
    <div class="mb-3">
      <label class="form-label">Email ID</label>
      <input type="email" class="form-control" id="emailId" name="emailId" value="${teacherData.emailId}" required>
    </div>

    <!-- Department -->
    <div class="mb-3">
      <label class="form-label">Department</label>
      <input type="text" class="form-control" id="depart" name="depart" value="${teacherData.department}" required>
    </div>

    <!-- Date of Birth -->
    <div class="mb-3">
      <label class="form-label">Date of Birth</label>
      <input type="date" class="form-control" id="birthday" name="birthday" value="${teacherData.dateOfbirth}" required>
    </div>

    <!-- Gender -->
    <div class="mb-3">
      <label class="form-label">Gender</label><br>
      <c:forEach var="gender" items="${teacherallgenders}">
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="gender" value="${gender}"
                 <c:if test="${gender == teacherselectedGender}">checked</c:if>>
          <label class="form-check-label">${gender}</label>
        </div>
      </c:forEach>
    </div>

    <!-- Address -->
    <div class="mb-3">
      <label class="form-label">Address</label>
      <textarea class="form-control" id="address" name="address" rows="3" required>${teacherData.address}</textarea>
    </div>

    <!-- Buttons -->
    <div class="d-flex justify-content-between">
      <button type="submit" class="btn btn-primary">💾 Update</button>
    </div>
  </form>
</div>

<!-- ✅ JavaScript Validation -->
<script>
function validateForm() {
  const contact = document.getElementById("contactNumber").value.trim();
  const cnic = document.getElementById("cnicNumber").value.trim();
  const email = document.getElementById("emailId").value.trim();

  if (!/^[0-9]{11}$/.test(contact)) {
    alert("Contact number must be exactly 11 digits.");
    return false;
  }

  if (!/^[0-9]{13}$/.test(cnic)) {
    alert("CNIC number must be exactly 13 digits.");
    return false;
  }

  const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  if (!emailPattern.test(email)) {
    alert("Please enter a valid email address.");
    return false;
  }

  // Ensure gender selected
  const genders = document.getElementsByName("gender");
  let selected = false;
  for (let g of genders) {
    if (g.checked) selected = true;
  }
  if (!selected) {
    alert("Please select a gender.");
    return false;
  }

  return true;
}
</script>

<!-- ✅ Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
