package Java_Core_Advance.src.Lesson6_d;

import Utils.ConnectProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class Server {
    final static int RECEIVE_TIME_OUT  =
             Integer.parseInt(new ConnectProperties().createProperties()
                                                     .getProperty("RECEIVE_TIME_OUT")); //10000
    public static final int PORT = Integer.parseInt(
            new ConnectProperties().createProperties().getProperty("PORT")
    );
    public static void main(String[] args){
         ServerSocket serverSocket ;
         Socket clientSocket ;
         BufferedReader in;
         PrintWriter out;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Dang doi ket noi tại cong "+String.valueOf(PORT));
            clientSocket = serverSocket.accept();
            clientSocket.setSoTimeout(RECEIVE_TIME_OUT);
            System.out.println("Da ket noi");
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
            Thread receive= new Thread(new Runnable() {
                String msg ;
                @Override
                public void run() {
                    try {
                        msg = in.readLine();
                        while(msg!=null){
                            System.out.println("Client : "+msg);
                            msg = in.readLine();
                        }
                        System.out.println("Ngat ket noi");
                        out.close();
                        clientSocket.close();
                        serverSocket.close();
                    } catch (SocketTimeoutException e) {
                        System.out.println("Qua thoi gian nhan.Ket thuc!");
                    }catch ( IOException e){
                        e.printStackTrace();
                    }
                }
            });
            receive.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
