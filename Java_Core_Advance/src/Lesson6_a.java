package Java_Core_Advance.src;

import Utils.ConnectProperties;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lesson6_a extends Thread {
    //chuong trinh real time in random number vao file output.txt
     private String number_random ;
    File file = new File("Java_Core_Advance/resources/output.txt");
     public static final String MAX_RANDOM = new ConnectProperties().
             createProperties().getProperty("MAX_RANDOM");  // so ngau nhien lon nhat co the co
     public String createNumberRandom(){   // sinh so ngau nhien
            this.number_random  = String.valueOf(new Random().nextInt(Integer.parseInt(MAX_RANDOM)))+" ";
            return this.number_random ;
     }
     public boolean writeFileRandomNumber(String number_random) throws IOException {   //ghi vao file
             PrintWriter pw = null;
             if (number_random != null) {
                 FileWriter fw = new FileWriter(file, true);
                 pw = new PrintWriter(fw);
                 pw.print(number_random);
                 pw.close();
             } else {
                 return false;
             }
             return true;
     }
         @Override
         public void run () {
             try {
                 System.out.println("dang ghi ... ");
                 System.out.println("Nhap stop de ket thuc");
                     while(true){
                         if(!Thread.interrupted()){   //Kiem tra luong da bi interrup chua
                         String number_random = this.createNumberRandom() ;
                         this.writeFileRandomNumber(number_random);
                     }else{
                             System.out.println("Chuong trinh ket thuc");
                             break;
                         }
                 }
             } catch (IOException e) {
                 System.out.println("Chuong trinh dung ,co loi ! ");
                 e.printStackTrace();
             }
         }
         public static void main (String[]args){
             Thread t1 = new Lesson6_a(); t1.start();
             String entry = new Scanner(System.in).nextLine();
             if("stop".equals(entry)) {    //go "stop" de ket thuc ctrinh
                 System.out.println("Dang dung chuong trinh ");
                 t1.interrupt();
             }
         }
     }

