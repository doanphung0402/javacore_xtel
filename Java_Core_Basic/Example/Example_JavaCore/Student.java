package Java_Core_Basic.Example.Example_JavaCore;

public class Student {
    String student_name ;
    String home_town;
    Gender_Student student_gender ;
    int student_age ;

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getHome_town() {
        return home_town;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public Gender_Student getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(Gender_Student student_gender) {
        this.student_gender = student_gender;
    }

    public int getStudent_age() {
        return student_age;
    }

    public void setStudent_age(int student_age) {
        this.student_age = student_age;
    }

    public Student(String student_name, int student_age, String home_town, Gender_Student student_gender) {
        this.student_age = student_age ;
        this.student_name = student_name;
        this.home_town = home_town;
        this.student_gender = student_gender ;
    }
}
