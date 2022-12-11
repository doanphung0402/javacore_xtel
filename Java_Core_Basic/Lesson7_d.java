package Java_Core_Basic ;

import Java_Core_Basic.Example.Example_JavaCore.Gender_Student;
import Java_Core_Basic.Example.Example_JavaCore.Student;
import Utils.ConnectDB;
import Utils.ConnectProperties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Lesson7_d {
    static Properties properties = new ConnectProperties().createProperties();
    private static final String DB_URL = properties.getProperty("DB_URL");
    private static final String USER_NAME = properties.getProperty("USER_NAME");
    private static final String PASSWORD  = properties.getProperty("PASSWORD");
    public void saveStudent(Student student ) throws SQLException {
         Connection conn = new ConnectDB(DB_URL,USER_NAME,PASSWORD).getConnection();
         Statement stm = conn.createStatement();
         String stringQuery  =String.format(
                 "insert into student(student_name,student_hometown,student_age,student_gender)" +
                         " values(\"%s\",\"%s\",\"%d\",\"%s\");",
                 student.getStudent_name(),
                 student.getHome_town(),
                 student.getStudent_age(),
                 student.getStudent_gender().toString()) ;
//        System.out.println(stringQuery);
        stm.execute(stringQuery);
    }
    public static void main(String[] args) {
        int number_student = 0; //so snh vien can nap thong tin
        System.out.println("nhap so luong sinh vien :  ");
        number_student = new Scanner(System.in).nextInt();
        if(number_student <=0) {
            return;
        }else {
             int i =1 ;
             while(i<=number_student){
                 System.out.println("Nhap thong tin sinh vien thu "+i);
                 System.out.println("Ten hoc sinh");
                 String student_name = new Scanner(System.in).nextLine();
                 System.out.println("Tuoi hoc sinh ");
                 int student_age = new Scanner(System.in).nextInt();
                 while(student_age<=0){
                     System.out.println("khong hop le !Nhap lai");
                     student_age = new Scanner(System.in).nextInt();
                 }
                 System.out.println("Que quan hoc sinh");
                 String student_hometown = new Scanner(System.in).nextLine();
                 System.out.print("Gioi tinh : ");
                 System.out.println("1.nam     2.nu");
                 Gender_Student gender_student ;
                 int choose_gender = new Scanner(System.in).nextInt();
                 while(choose_gender!=1 && choose_gender!=2){
                     System.out.println("Khong hop le ! Nhap lai");
                     choose_gender = new Scanner(System.in).nextInt();
                 }
                 if(choose_gender ==1) {
                      gender_student = Gender_Student.MALE ;
                 }else{
                      gender_student = Gender_Student.FEMALE ;
                 }
                  try {
                      Student student = new Student(student_name,student_age,student_hometown,gender_student);
                      new Lesson7_d().saveStudent(student);
                      System.out.println("Luu thanh cong hoc sinh " + (i==1?"":i) );
                  }catch (SQLException e) {
                      e.printStackTrace();
                  }
                 i++;
             }


        }
    }
}