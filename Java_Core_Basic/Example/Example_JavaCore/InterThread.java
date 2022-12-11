package Java_Core_Basic.Example.Example_JavaCore;

import java.util.Scanner;

public class InterThread {
     // Mo phong giao tiep giua 2 thread
     // vi du ve 2 ham rut tien va gui tien
    int amount_money;   //so tien hien co trong tai khoan
     public InterThread(int amount){
          this.amount_money = amount ;
     }

    public void setAmount_money(int amount_money) {
        this.amount_money = amount_money;
    }

    public int getAmount_money() {
        return amount_money;
    }

    synchronized void withdraw(long amount)  {   //ham rut tien
            if(amount  > this.amount_money+50000){
                System.out.println("Tai khoan khong du ");
                try{
                     wait(3000);    //cho 3s neu so du tai khoan khong du thi ket thuc chuong chinh
                     if(this.getAmount_money()<amount){
                         System.out.println("Ket thuc giao dich");
                          return ;
                     }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Đang rút tiền ...");
                this.amount_money -=amount;
                System.out.println("Vui long nhan tien ...");
            }
    }
    synchronized void deposit(int amount){   //ham gui tien vao tai khoan
          if(amount <= 0){
              System.out.println("so tien gui khong hop le");
              return ;
          }
          this.amount_money +=amount ;
          notify();
    }

    public static void main(String[] args) {
         InterThread customer = new InterThread(50000);
         System.out.println("Nhap so tien can rut ");
         int money_draw = new Scanner(System.in).nextInt();  //so tien can rut

         new Thread(){
             public void run(){
                   customer.withdraw(500000);
            }
         }.start();

    }

}
