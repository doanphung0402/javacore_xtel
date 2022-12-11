package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
     String dbURL ;
     String userName ;
     String password ;

    public ConnectDB(String dbURL, String userName, String password) {
        this.dbURL = dbURL;
        this.userName = userName;
        this.password = password;
    }

    public Connection getConnection(){
         Connection conn = null;
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             conn = DriverManager.getConnection(this.dbURL, this.userName,this.password);
//             System.out.println("connect successfully!");
         } catch (Exception ex) {
             System.out.println("connect failure!");
             ex.printStackTrace();
         }
         return conn;
     }

}
