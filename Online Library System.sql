/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.21-MariaDB : Database - library_system_online
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library_system_online` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `library_system_online`;

/*Table structure for table `app_user` */

DROP TABLE IF EXISTS `app_user`;

CREATE TABLE `app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `app_user` */

insert  into `app_user`(`id`,`user_name`,`user_password`,`role`) values (1,'admin@gmail.com','admin12345','ADMIN'),(3,'hujajali2233@gmail.com','hujaj1133','STUDENT'),(4,'hujajali334455@gmail.com','114422','STUDENT'),(5,'mukhtiarali567880@gmail.com','mukhtiar1122','STUDENT'),(7,'akramali12@gmail.com','akramali12','INSTRUCTOR'),(8,'hujajali2233@gmail.com','hujo1122','INSTRUCTOR'),(9,'ashiqueali1133@gmail.com ','ashique1133','LIBRARAIN'),(10,'azeemali1122@gmail.com','azeem1122','LIBRARAIN'),(11,'mustafaali@gmail.com','mustafaali@123','LIBRARAIN'),(12,'waqarali12@gmail.com','waqarali12','LIBRARAIN'),(13,'shahidaali116@gmail.com','shahidaali116','LIBRARAIN'),(14,'abudulmajeed112233@gmail.com','abudlmajeed112233','LIBRARAIN'),(15,'shaista1122@gmail.com','shaista1122','STUDENT'),(16,'yusraali12@gmail.com','yusara12','STUDENT'),(17,'asifkhan1234@gmail.com','asifkhan1234','STUDENT'),(18,'hamza1122@gmail.com','hamza@1122','INSTRUCTOR'),(19,'ameenali1133@gmail.com','ameena#li1133','INSTRUCTOR'),(20,'zoyaali112233@gmail.com','zoya112233','STUDENT'),(21,'bareozekhan1122@gmail.com','khan1122','LIBRARAIN'),(22,'mujtabaali12345@gmail.com','ali12345','INSTRUCTOR'),(24,'awaiskhan12345@gmail.com','khan12345','INSTRUCTOR'),(25,'umairali1234@gmail.com','ali1234','INSTRUCTOR');

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `cnic` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `author` */

insert  into `author`(`author_id`,`first_name`,`last_name`,`father_name`,`surname`,`cnic`,`contact_number`,`email_id`,`gender`,`address`) values (1,'Akram','Ali','Muhammad Ali','Khokhar','4130660574701','03091135133','akram@gmail.com','male','kamari.'),(2,'Aamir','Ali','Nazeer','Khokhar','03091135121','4130660574701','aamirali123@gmail.com','male','north karachi'),(3,'Shaista ','Ali','Arbaz','Chandio','03091135142','4130660574702','shaista12@gmail.com','female',' house no 120 North karachi '),(4,'Javed','Hussain','Naiz Ahmed','Shar','41223567','2244566','javedhussain12@gmail.com','male','HassanSaquare'),(5,'Naila','Gohri','Aziz','UrduSpeaking','03091135121','4130660574703','nailagohri@gmail.com','femeale','Hassan Square'),(6,'Rahool','Kumar','jakesh','Kumar','03091135132','4130660574702','rahulkumar@gmail.com','female','Tarique Road'),(7,'Haseeb','Rehman','Raj Mahfooz','Raja','03222457465','4130660574703','haseebali@gmail.com','male','ok'),(8,'Akram','Ahmed','Nazeer','Khokhar','03091135100','4130660574703','akramali@gmail.com','male','Islamabad'),(9,'Talah','Ahmed','Tahir','Punjabi','03091135122','4130660574701','talah1122@gmail.com','male','Kamari'),(10,'Umera ','Ahmed','Basharat','UrduSpeaking','03081135133','4130660574700','umeraahmed1122@gmail.com','female','House No 120 P.I.B.E.C.H Colonoy Sha re faisal.'),(11,'Khalil','ur Rehman','Abdul Rehman','Pathan','03391135133','4130660574700','khalilurrehman12347@gmail.com ','male','DHA PhaseII House No 123 Khyban e Ithad.'),(12,'Bisma ','Ali','Ashique Ali','Chandio','03161135130','4130660574700','bismaali123@gmail.com','female','D 124 phaseII Qasimabad Hyd.'),(13,'Awais','Khan','Ahmed','Pathan','03001135133','4130660574702','awaiskhan112233@gmail.com','male','Johar Complex Flate 501 at Karachi.');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `author_editor` varchar(255) DEFAULT NULL,
  `editor_volume` varchar(255) DEFAULT NULL,
  `year_of_publishing` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `number_of_pages` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`book_id`,`author_id`,`category_id`,`book_name`,`language`,`author_editor`,`editor_volume`,`year_of_publishing`,`isbn`,`number_of_pages`,`remarks`) values (11,2,2,'Java','English','Paul Detail&Detail ','Volume1','2000','40231','4000','ok'),(12,1,3,'BasicEelectronics','English','Dr.Albert','Volume1','2012','40231','4000','good written for knwoldege.'),(13,3,1,'intro to python','English','Dr.Yohan','Volume1','2013','12346','4500','understandable.'),(14,4,5,'Java','English','Paul Detail&Detail ','Volume1','2001','40231','4000','understandable.'),(15,5,12,'Remo and Juliet','English','William Shakespeare','Volume1','2000','33210','2000','romantic story of love and molodarma.'),(18,11,13,'Main manto nahe hun.','Urdu','M.Iqbal','Volume1','2025','33216','2000','its novel based story.'),(19,2,4,'The Great Gatsby','English','Dr.Mohsin','Volume1','2001','9780306406157','2000','its novel.'),(20,11,13,'Mery pass tum ho','Urdu','M.Iqbal','Volume1','2001','9780306406157','2000','its novel.'),(21,10,13,'Yaqeen ka Safar','Urdu','Mohsin','Volume1','2001','9780306406157','3000','its novel.');

/*Table structure for table `book_issue` */

DROP TABLE IF EXISTS `book_issue`;

CREATE TABLE `book_issue` (
  `book_id` int(100) DEFAULT NULL,
  `librarian_id` int(100) DEFAULT NULL,
  `book_issue_id` int(100) NOT NULL AUTO_INCREMENT,
  `date_of_issue` varchar(100) DEFAULT NULL,
  `due_date` varchar(100) DEFAULT NULL,
  `date_of_returne` varchar(100) DEFAULT NULL,
  `fine` int(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`book_issue_id`),
  KEY `book_id` (`book_id`),
  KEY `libraraian_id` (`librarian_id`),
  CONSTRAINT `book_issue_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `book_issue_ibfk_2` FOREIGN KEY (`librarian_id`) REFERENCES `librarain` (`librarain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `book_issue` */

insert  into `book_issue`(`book_id`,`librarian_id`,`book_issue_id`,`date_of_issue`,`due_date`,`date_of_returne`,`fine`,`remarks`) values (11,7,6,'2025-12-13',' 2025-12-20','2025-12-25',50,'Book Is Returned.'),(12,8,7,'2025-12-14',' 2025-12-30','2025-12-31',50,'Book Is Returned.');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`category_id`,`book_category`) values (1,'Computer Science'),(2,'Software Engineering'),(3,'Electronics'),(4,'Computer System Engineering'),(5,'Information Technology'),(6,'Cyber Security'),(7,'Artificial Inteligence'),(8,'Telecommunication'),(9,'Mechatorinics and Robortics'),(10,'Data Science'),(11,'Civil Engennring'),(12,'English'),(13,'Urdu.'),(14,'Telecommunication');

/*Table structure for table `librarain` */

DROP TABLE IF EXISTS `librarain`;

CREATE TABLE `librarain` (
  `user_id` int(11) DEFAULT NULL,
  `librarain_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `cnic` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`librarain_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `librarain_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `librarain` */

insert  into `librarain`(`user_id`,`librarain_id`,`first_name`,`last_name`,`father_name`,`surname`,`cnic`,`contact_number`,`gender`,`email_id`,`address`) values (9,7,'Bisma','Ali','Ashique Ali','Chandio','4130660574700','03421135130','Female','ashiqueali1133@gmail.com ','Chandni Newtown '),(10,8,'Azeem','Ali','Nazeer','Memon','4130660574700','03091135109','Male','azeemali1122@gmail.com','Islamabad '),(11,9,'Mustafa','Ali','Muhammad Ali','Somrrow','4130660574702','03091135122','Male','mustafaali@gmail.com','Gulshan e Iqbal'),(12,10,'Waqar','Ali','Arbaz','Jaghrani','4130660574702','03091135122','Male','waqarali12@gmail.com','Gulshan e Iqbal House No 120 Sindhi Muslims Society Karachi.'),(13,11,'Shahida','Ali','Altaf ','Chandio','4130660574700','03341135133','Female','shahidaali116@gmail.com','D 124 Phase II Qasimabad Hyderabad.'),(14,12,'Abdul','Majeed','Nazeer','Shaikh','4130660574700','03591135133','Male','abudulmajeed112233@gmail.com','House No 005 Shah Faisal Colony Karongi Karachi ');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `std_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `member_type` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `father_name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `contact_number` varchar(50) DEFAULT NULL,
  `cnic` varchar(50) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `std_id` (`std_id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `student` (`std_id`),
  CONSTRAINT `member_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `member` */

insert  into `member`(`member_id`,`std_id`,`teacher_id`,`member_type`,`first_name`,`last_name`,`father_name`,`surname`,`contact_number`,`cnic`,`email_id`,`gender`,`address`) values (4,2,NULL,'Student','Mukhtiar ','Mukhtiar ','Arz Muhammad','Chandio','4130660574701','03091135133','Male','mukhtiarali567880@gmail.com','A33/7 Johar Complex Mossmeyat Main Road University Karachi'),(5,1,NULL,'Student','Hujaj','Hujaj','Taj Muhammad','Qambrani','4130660574703','03091135123','Male','hujajali2233@gmail.com','Islamabad'),(6,NULL,4,'Teacher','Shaista','Shaista','Ashique Ali','Chandio','4130660574702','03491135133','Male','shaista1122@gmail.com','D 124 phaseII Qasimabad Hyderabad.');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `std_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `cnic` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`std_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`std_id`,`user_id`,`first_name`,`last_name`,`father_name`,`surname`,`cnic`,`contact_number`,`gender`,`email_id`,`address`) values (1,3,'Hujaj','Ali','Taj Muhammad','Qambrani','4130660574701','03091135133','male','hujajali2233@gmail.com','Islamabad'),(2,5,'Mukhtiar ','Ali','Arz Muhammad','Chandio','4130660574701','03091135133','male','mukhtiarali567880@gmail.com','A33/7 Johar Complex Mossmeyat Main Road University Karachi'),(3,15,'Shaista','Ali','Ashique Ali','Chandio','4130660574702','03491135133','female','shaista1122@gmail.com','D 124 phaseII Qasimabad Hyderabad.'),(4,16,'Yusra','Ali','Ashique Ali','Chandio','4130660574700','03191135122','female','yusraali12@gmail.com','D 124 phaseII Qasimabad Hyderabad.'),(5,17,'Asif','Khan','Muhammad ','Yousafzai','4130660574700','03451135133','female','asifkhan1234@gmail.com','house No 120 New Karachi.  '),(6,20,'Zoya','Ali','Kamran','Shaikh','4130660574000','03491135122','female','zoyaali112233@gmail.com','Phase 1 Block A House No 120 Boat Bason Karachi.');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(50) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `cnic` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `teacher` */

insert  into `teacher`(`teacher_id`,`user_id`,`first_name`,`last_name`,`father_name`,`surname`,`cnic`,`contact_no`,`gender`,`email`,`date_of_birth`,`department`,`address`) values (4,7,'Akram','Ali','Muhammad Ali','Somrrow','4130660574703','03091135121','male','akramali12@gmail.com','2025-10-03','IT','Johar Square'),(5,8,'Hujaj','Ali','Taj Muhammad','Qambrani','4130660574703','03091135123','male','hujajali2233@gmail.com','2025-10-03','IT','Islamabad'),(6,18,'Hamza','Ali','Muhammad Ali','UrduSpeaking','4130660574722','03491135133','male','hamza1122@gmail.com','2000-06-01','Information Technology','A22/7 Johar Square Gulistan-e-johar Karachi. '),(7,19,'Ameen','Chajjro','Muhammad Nawaz','chajjro','4130660574000','03391135133','male','ameenali1133@gmail.com','1985-01-01','Soft Eng','House No 11 Block D Chappal Suncity.'),(8,22,'Mujataba','Ali','Akram','Jut','4130660574701','03091135133','male','hujajali12345@gmail.com','2001-02-12','IT','Sultanabad Karachi.'),(10,24,'Awais','Khan','Ahmed','Pathan','4130660574702','03091135133','male','awaiskhan12345@gmail.com','2001-02-12','IT','Tariq Road Karachi.'),(11,25,'Umair','Ali','Fateh','Chandio','4130860574703','03391135134','male','umairali1234@gmail.com','2001-10-05','Computer Science','Village Chajjri Kambar Shahdadkot.');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
