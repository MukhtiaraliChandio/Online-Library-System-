package com.library.dao;

import java.util.List;

import com.library.pojo.Member;
import com.library.pojo.Student;
import com.library.pojo.Teacher;

public interface MemberDao {

public void  insertMemberdata(String stdId, String teacherId,   String memberType,   String firstName, String lastName,  String fatherName, String surname,
String cnic, String contactNumber, String gender, String emailId, String address);


public List<Student> getAllstudentdata();

public List<Teacher> showTeacherdata();

	
}