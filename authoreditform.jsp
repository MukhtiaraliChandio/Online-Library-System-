<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.pojo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
*{
   
   margin: 0;
   padding: 0;

}
body
{

   background-image : url(form.jpg);
   background-position: center;
   background-size: cover;
   font-family: sans-serif;
   margin-top: 40px;

}
.regform
{

   width: 600px;
   background-color: rgb(0,0,0,0.6);
   margin: auto;
   color: #FFFFFFFF;
   padding: 10px 0px 10px 0px;
   text-align: center;
   border-radius: 10px 10px 0px 0px; 

}
.main 
{
             
   background-color: rgb(0,0,0,0.5);
   width: 600px;
   margin: auto;

}
.form
{

   padding: 5px;

}
#name
{

   width: 100%;
   height: 100px;

}

.teacherIdlabel{
     position: relative;
     color: #E5E5E5;
     text-transform:capitalize;
     font-size: 14px;
     left: 0px;
     top:-0px;  


}
 
.firstName
{
    position: relative;
    left: 400px;
    top:-80px;
    line-height: 40px;
    border-radius :6px;
    padding: 0 22px;
    font-size: 16px;

}


.firstlabel
{

     position: relative;
     color: #E5E5E5;
     text-transform:capitalize;
     font-size: 14px;
     left: 0px;
     top:-0px;  

}
.lastName
{
     position: relative;
     left: 417px;
     top:-80px;
     line-height: 40px;
     border-radius: 6px;
     padding: 0 22px;
     font-size: 16px;
               	  
}

.lastlabel
{
     position: relative;
     color: #E5E5E5;
     text-transform:capitalize;
     font-size: 14px;
     left: 0px;
     top:-0px;

}
.fatherNamelabel
{
     position: relative;
     color: #E5E5E5;
     text-transform:capitalize;
     font-size: 14px;
     left: 0px;
     top:-0px;

}
.surnamelabel
{

     position: relative;
     color: #E5E5E5;
     text-transform:capitalize;
     font-size: 14px;
     left: 0px;
     top:-0px;


}
.contactNumber
{
	 
	 position: relative;
     color: #E5E5E5;
     text-transform:capitalize;
     font-size: 14px;
     left: 0px;
     top:-0px;


}
.cnicNumber
{
     
      position: relative;
      color: #E5E5E5;
      text-transform:capitalize;
      font-size: 14px;
      left: 0px;
      top:-0px;

}
.emailId
{
      position: relative;
      color: #E5E5E5;
      text-transform:capitalize;
      font-size: 14px;
      left: 0px;
      top:-0px;

}
.depart
{

      position: relative;
      color: #E5E5E5;
      text-transform:capitalize;
      font-size: 14px;
      left: 0px;
      top:-0px;

}
.address
{

      position: relative;
      color: #E5E5E5;
      text-transform:capitalize;
      font-size: 14px;
      left: 0px;
      top:-0px;

}
.regNo
{
      position: relative;
      color: #E5E5E5;
      text-transform:capitalize;
      font-size: 14px;
      left: 0px;
      top:-0px;

}
.dateofbirthday
{

      position: relative;
      color: #E5E5E5;
      text-transform:capitalize;
      font-size: 14px;
      left: 0px;
      top:-0px;

}
.cityName
{
      
      position: relative;
      color: #E5E5E5;
      text-transform:capitalize;
      font-size: 14px;
      left: 0px;
      top:-0px;

}
.provinceName
{

      position: relative;
      color: #E5E5E5;
      text-transform:capitalize;
      font-size: 14px;
      left: 0px;
      top:-0px;

}
.zipCode
{

     position: relative;
     color: #E5E5E5;
     text-transform:capitalize;
     font-size: 14px;
     left: 0px;
     top:-0px;



}
.country
{

     position: relative;
	 color: #E5E5E5;
	 text-transform:capitalize;
	 font-size: 14px;
	 left: 0px;
	 top:-0px;


}
.selectGender
{
     position: relative;
     color: #E5E5E5;
     text-transform:capitalize;
     font-size: 14px;
     left: 0px;
     top:-0px;


}
.gender
{
     position: relative;
    color: #E5E5E5;
    text-transform:capitalize;
    font-size: 14px;
    left: 0px;
    top:-0px;
         
         
}

.Nationality
{

    position: relative;
    color: #E5E5E5;
    text-transform:capitalize;
    font-size: 14px;
    left: 0px;
    top:-0px;


}
</style>
</head>
<body>

<div class="regform"><h1>Edit Teacher Registration Form</h1></div>
<div class="main">
  <form action="TeacherServlet"  method="post" onsubmit="return validateForm()">
  <input type="hidden" id="stdId" name="option" value="updateData">
   
   

   
    <div id="name">
      
      <br>
      <center><label class="authorIdlabel">Author Id</label>
        <input type="text" name="authorId" maxlength="50" value="${teacherData.teacherId}" size="50"></center>
      <br>
      <center><label class="firstlabel">First Name</label>
        <input type="text" name="firstname" maxlength="50" value="${teacherData.firstName}" size="50"></center>
      <br>
      <center><label class="lastlabel">Last Name</label>
        <input type="text" name="lastname" maxlength="50" size="50" value="${teacherData.lastName}"  ></center>
        <br>
    </div>

    <div>
      <center>
      <br>
      <br>
        <label class="fatherNamelabel">Father's Name</label>
        <input type="text" name="fatherName" maxlength="50" size="50" value="${teacherData.fatherName}"></center>
      <br>
      <center>
        <label class="surnamelabel">Surname</label>
        <input type="text" name="surname" maxlength="50" size="50" value="${teacherData.surname}">
      </center>
    </div>

    <br>
    <div>
      <center>
        <label class="contactNumber">Contact Number</label>
        <input type="text" name="contactNumber" maxlength="50" size="50" value="${teacherData.contactNo}">
      </center><br>
      <center>
        <label class="cnicNumber">CNIC Number</label>
        <input type="text" name="cnicNumber" maxlength="50" size="50" value="${teacherData.cnic }"><br>
      </center>
    </div>

    <div>
      <br>
      <center>
        <label class="emailId">Email Id</label>
        <input type="text" name="emailId" maxlength="50" size="50" value="${teacherData.emailId}"><br>
        <br>
       
      </center>
    </div>
  <div>
      <br>
      <center>
        <label class="depart">Department</label>
        <input type="text" name="depart" maxlength="50" size="50" value="${teacherData.department}"><br>
        <br>
       
      </center>
    </div>

  
  
    
      <div>
        <center>
          <label class="dateofbirthday">Date of Birth</label>
          <input type="date" id="birthday" name="birthday" value="${teacherData.dateOfbirth}">
        </center>
      </div>

      

    

      <div>
        <center>
    <label class="selectGender">Select Gender</label><br>    
     <c:forEach var="gender" items="${teacherallgenders}">
            <label>
                <input type="radio" name="gender" value="${gender}"
                       <c:if test="${gender == teacherselectedGender}">checked</c:if>> 
                ${gender}
            </label><br>
        </c:forEach>
          
          
        </center>
      </div>

      <div>
        <center>
          <label class="address">Address</label><br>
          <textarea rows="5" cols="50" wrap="hard" name="address">${teacherData.address}</textarea>
        </center>
      </div>

      <center>
        <input type="submit" value="updateData">
      
      </center>
    </div>

  </form>
</div>
<script>
  function validateForm() {
    // Teacher ID
    var teacherId = document.forms[0]["teacherId"].value;
    if (teacherId == "") {
      alert("Teacher ID must be filled out.");
      return false;
    }

    // First Name
    var firstName = document.forms[0]["firstname"].value;
    if (firstName == "") {
      alert("First Name must be filled out.");
      return false;
    }

    // Last Name
    var lastName = document.forms[0]["lastname"].value;
    if (lastName == "") {
      alert("Last Name must be filled out.");
      return false;
    }

    // Father's Name
    var fatherName = document.forms[0]["fatherName"].value;
    if (fatherName == "") {
      alert("Father's Name must be filled out.");
      return false;
    }

    // Surname
    var surname = document.forms[0]["surname"].value;
    if (surname == "") {
      alert("Surname must be filled out.");
      return false;
    }

    // Contact Number (Valid number)
      var contactPattern = /^[0-9]{11}$/;  // Match exactly 11 digits
   if (!contactPattern.test(contactNo)) {
   alert("Please enter a valid 11-digit contact number.");
   return false;
   }


    // CNIC Number (Valid CNIC number)
    var cnicNumber = document.forms[0]["cnicNumber"].value;
    var cnicPattern = /^[0-9]{13}$/;
    if (!cnicNumber.match(cnicPattern)) {
      alert("Please enter a valid 13-digit CNIC number.");
      return false;
    }

    // Email ID (Valid email format)
    var emailId = document.forms[0]["emailId"].value;
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailId.match(emailPattern)) {
      alert("Please enter a valid email address.");
      return false;
    }

    // Department
    var department = document.forms[0]["depart"].value;
    if (department == "") {
      alert("Department must be filled out.");
      return false;
    }

    // Date of Birth
    var dob = document.forms[0]["birthday"].value;
    if (dob == "") {
      alert("Date of Birth must be filled out.");
      return false;
    }

    // Gender
    var gender = document.forms[0]["gender"];
    var genderSelected = false;
    for (var i = 0; i < gender.length; i++) {
      if (gender[i].checked) {
        genderSelected = true;
        break;
      }
    }
    if (!genderSelected) {
      alert("Please select a gender.");
      return false;
    }

    // Address
    var address = document.forms[0]["address"].value;
    if (address == "") {
      alert("Address must be filled out.");
      return false;
    }

    // If all fields are valid
    return true;
  }
</script>

</body>
</html>