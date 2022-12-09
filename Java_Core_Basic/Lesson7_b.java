package Java_Core_Basic;

import java.util.Scanner;

public class Lesson7_b {
    public static void main(String[] args) {
        int electric_number = 0 ;
        System.out.println("Nhap so tien dien");
        electric_number = new Scanner(System.in).nextInt();
        int electric_money = 0 ;
        if(electric_number <=100) {
             electric_money = electric_number * 1000;
        }else if(electric_number<=150){
             electric_money = electric_number * 1500 ;
        }else {
             electric_money = electric_number * 2000;
        }
    }
}
