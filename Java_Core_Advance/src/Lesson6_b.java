package Java_Core_Advance.src;

import Utils.ConnectProperties;

import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Lesson6_b  {
    public static void main(String[] args) {
        //so ngau nhien lon nhat
        final String MAX_RANDOM = new ConnectProperties().createProperties().getProperty("MAX_RANDOM");
        //thoi gian chay chuong trinh
        final String LESSON6_B_N = new ConnectProperties().createProperties().getProperty("LESSON6_B_N");
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int count =0 ;
            @Override
            public void run() {
                if((count+=5000)<=Integer.parseInt(LESSON6_B_N)){
                    int number_random = new Random().nextInt(Integer.parseInt(MAX_RANDOM));
                    System.out.println(number_random);
                }else{
                    timer.cancel();
                    System.out.println("Ket thuc");
                }
            }
        };
        timer.schedule(timerTask,new Date(),5000);
    }
}
