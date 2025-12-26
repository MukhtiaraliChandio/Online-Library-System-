<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Member Registration Form</title>

<!-- ✅ Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- ✅ jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- ✅ Custom CSS -->
<style>
body {
  background: url('form.jpg') no-repeat center center fixed;
  background-size: cover;
  font-family: 'Poppins', sans-serif;
  color: #fff;
  min-height: 100vh;
}

.container {
  max-width: 700px;
  background: rgba(0, 0, 0, 0.7);
  border-radius: 15px;
  padding: 30px 40px;
  margin-top: 60px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.4);
  backdrop-filter: blur(6px);
}

h2 {
  text-align: center;
  font-weight: 600;
  margin-bottom: 25px;
  color: #f8f9fa;
}

label {
  color: #f1f1f1;
  font-weight: 500;
}

.form-control, .form-select {
  border-radius: 10px;
  border: none;
  padding: 10px;
}

.form-control:focus, .form-select:focus {
  box-shadow: 0 0 5px #0d6efd;
}

.btn {
  border-radius: 25px;
  font-weight: 600;
  transition: 0.3s;
}

.btn:hover {
  transform: scale(1.05);
}

</style>
</head>
<body>

<div class="container">
  <h2>📋 Member Registration Form</h2>

  <form action="MemberServlet" method="post" id="memberForm" onsubmit="return validateForm()">
    <input type="hidden" name="option" value="insertmembervalue">

    <!-- Member Type -->
    <div class="mb-3">
      <label class="form-label">Select Member Type</label>
      <select class="form-select" id="memberType" name="memberType" required>
        <option value="">-- Select --</option>
        <option value="Student">Student</option>
        <option value="Teacher">Teacher</option>
      </select>
    </div>

    <!-- Name Dropdown -->
    <div class="mb-3">
      <label class="form-label">Select Name</label>
      <select class="form-select" name="memberTypeId" id="nameList" required>
        <option value="">Select a member</option>
      </select>
    </div>

    <!-- Member Information -->
    <div class="row">
      <div class="col-md-6 mb-3">
        <label>First Name</label>
        <input type="text" id="firstname" name="firstname" class="form-control" required>
      </div>
      <div class="col-md-6 mb-3">
        <label>Last Name</label>
        <input type="text" id="lastname" name="lastname" class="form-control" required>
      </div>
    </div>

    <div class="mb-3">
      <label>Father's Name</label>
      <input type="text" id="fatherName" name="fatherName" class="form-control" required>
    </div>

    <div class="mb-3">
      <label>Surname</label>
      <input type="text" id="surname" name="surname" class="form-control" required>
    </div>

    <div class="mb-3">
      <label>Contact Number</label>
      <input type="text" id="contactNumber" name="contactNumber" class="form-control" maxlength="11" required>
    </div>

    <div class="mb-3">
      <label>CNIC Number</label>
      <input type="text" id="cnicNumber" name="cnicNumber" class="form-control" maxlength="13" required>
    </div>

    <div class="mb-3">
      <label>Email ID</label>
      <input type="email" id="emailId" name="emailId" class="form-control" required>
    </div>

    <div class="mb-3">
      <label>Gender</label><br>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="gender" id="male" value="Male">
        <label class="form-check-label">Male</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="gender" id="female" value="Female">
        <label class="form-check-label">Female</label>
      </div>
    </div>

    <div class="mb-3">
      <label>Address</label>
      <textarea id="address" name="address" rows="3" class="form-control" required></textarea>
    </div>

    <!-- Buttons -->
    <div class="d-flex justify-content-between mt-4">
      <button type="submit" class="btn btn-primary w-45">Submit</button>
      <button type="reset" class="btn btn-secondary w-45">Reset</button>
    </div>
  </form>
</div>

<!-- ✅ AJAX Logic -->
<script>
let selectMember = "";

$(document).ready(function() {
  // When member type changes, load names
  $("#memberType").change(function() {
    let selectedType = $(this).val();
    selectMember = selectedType;

    if (selectedType) {
      $.ajax({
        url: 'MemberServlet?option=nameList',
        type: 'POST',
        data: { memberType: selectedType },
        success: function(response) {
          $("#nameList").html(response);
        },
        error: function() {
          alert("Error fetching names. Try again.");
        }
      });
    } else {
      $("#nameList").html("<option>Select a member</option>");
    }
  });

  // Fetch details when name selected
  $('#nameList').change(function() {
    let memberId = $(this).val();

    if (memberId) {
      $.ajax({
        url: 'MemberServlet?option=getmemberdata',
        type: 'POST',
        data: { memberId: memberId, selectedMember: selectMember },
        success: function(response) {
          let memberDetails = response[0];
          if (memberDetails) {
            $('#firstname').val(memberDetails.firstname);
            $('#lastname').val(memberDetails.lastname);
            $('#fatherName').val(memberDetails.fathername);
            $('#surname').val(memberDetails.surname);
            $('#contactNumber').val(memberDetails.contactnumber);
            $('#cnicNumber').val(memberDetails.cnicnumber);
            $('#emailId').val(memberDetails.emailId);
            $('#address').val(memberDetails.address);

            document.querySelectorAll('input[name="gender"]').forEach(g => {
              if (g.value === memberDetails.gender) g.checked = true;
            });
          } else {
            alert("Member details not found.");
          }
        },
        error: function() {
          alert("Failed to fetch member details.");
        }
      });
    }
  });
});
</script>

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

  const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  if (!emailPattern.test(email)) {
    alert("Please enter a valid email address.");
    return false;
  }

  const genderSelected = document.querySelector('input[name="gender"]:checked');
  if (!genderSelected) {
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
