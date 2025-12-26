package com.library.pojo;

public class Author {

	
	private int authorId;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String surname;
	private String contactNo;
	private String cnic;
	private String emailId;
	private String  gender;
	private String  address;
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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
	public String getContactNo() {
		return contactNo;
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
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", fatherName="
				+ fatherName + ", surname=" + surname + ", contactNo=" + contactNo + ", cnic=" + cnic + ", emailId="
				+ emailId + ", gender=" + gender + ", address=" + address + "]";
	}

	
	
	
	
	
	
	
	
	
}