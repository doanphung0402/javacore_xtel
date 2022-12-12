package Java_Core_Advance.src.Lesson6_d;

import Utils.ConnectProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static final int PORT = Integer.parseInt(
            new ConnectProperties().createProperties().getProperty("PORT")
    );
    public static final String IP = new ConnectProperties().createProperties().getProperty("IP");
    public String getRandomString() {   //Tao chuoi ngau nhien
        byte[] array = new byte[7]; // chieu dai chuoi la 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        System.out.println(generatedString);
        return generatedString ;
    }
    public static void main(String[] args){
         Socket clientSocket;
         BufferedReader in;
         PrintWriter out;
         Scanner sc = new Scanner(System.in);
        try {
            clientSocket = new Socket(IP,PORT);
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread sender = new Thread(new Runnable() {
                int  i =0 ;
                @Override
                public void run() {
                    while(true){
                        String msg = new Client().getRandomString();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        out.println(msg);
                        System.out.println("Gui message " + i++);
                        out.flush();
                    }
                }
            });
            sender.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
