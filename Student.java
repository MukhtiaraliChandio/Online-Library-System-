package com.library.pojo;

public class Student {

	private int stdId;
	private int userId;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String surname;
	private String gender;
	private String cnic;
	private String contactNo;
	private String emailId;
	private String address;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
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
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getContactNo() {
		return contactNo;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", surname=" + surname + ", gender=" + gender + ", cnic=" + cnic
				+ ", contactNo=" + contactNo + ", emailId=" + emailId + ", address=" + address + "]";
	}
	

	
	
	
	
	
}