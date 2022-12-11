create database if not exists javacorebasic; 
use javacorebasic; 
create table if not exists student(
      student_id int primary key auto_increment , 
      student_age int not null check(student_age >0)  , 
	  student_hometown varchar(255), 
	  student_name varchar(255) not null , 
      student_gender enum("male" , "female") not null   
 ); 
 insert into student(student_name,student_hometown, student_age,student_gender)
 values("phung","hung yen",22,1); 
