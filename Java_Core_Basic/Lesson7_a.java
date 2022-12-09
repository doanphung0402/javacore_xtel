package Java_Core_Basic;

import java.util.Scanner;

public class Lesson7_a {

    public void checkNumber(int correctNumber){
        int i =1 ;
        while(i<=5){
            if (i==1){
                System.out.println("Nhap so cua ban : ");
            }else{
                System.out.println("Nhap lai lan : "+i);
            }
            String numberEnter ="";
            numberEnter =  new Scanner(System.in).nextLine();
            if (String.valueOf(correctNumber).equals(numberEnter)){
                System.out.println("Thanh cong !" );
                break;
            } else if (i==5){
                System.out.println("Nhap loi ! ");
                break ;
            }
            else{
                System.out.println("That bai , con " + (5-i) + " lan nua ");
            }
            i++;
        }

    }
    public static void main(String[] args) {
        System.out.println("so can nhap cua ban : ");
        int correctNumber = new Scanner(System.in).nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        new Lesson7_a().checkNumber(correctNumber);

    }
}
