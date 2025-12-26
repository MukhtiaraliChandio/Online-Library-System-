package com.library.pojo;

public class Member {

	private int memberId;
	private int stdId;
	private int  teacherId;
	private String memberName;
	private String memberType;
	private String fatherName;
	private String surname;
	private String contactNumber;
	private String cnic;
	private String emailId;
	private String gender;
	private String address;
	
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", stdId=" + stdId + ", teacherId=" + teacherId + ", memberName="
				+ memberName + ", memberType=" + memberType + ", fatherName=" + fatherName + ", surname=" + surname
				+ ", contactNumber=" + contactNumber + ", cnic=" + cnic + ", emailId=" + emailId + ", gender=" + gender
				+ ", address=" + address + "]";
	}
	
	
	
	
	
	
	
}