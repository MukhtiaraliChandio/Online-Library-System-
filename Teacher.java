package com.library.pojo;

public class Teacher {

	private int userId;
	private int teacherId;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String surname;
	private String cnic;
	private String contactNo;
	private String gender;
	private String emailId;
	private String dateOfbirth;
	private String department;
	private String address;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Teacher [userId=" + userId + ", teacherId=" + teacherId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", fatherName=" + fatherName + ", surname=" + surname + ", cnic=" + cnic + ", contactNo="
				+ contactNo + ", gender=" + gender + ", emailId=" + emailId + ", dateOfbirth=" + dateOfbirth
				+ ", department=" + department + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
}