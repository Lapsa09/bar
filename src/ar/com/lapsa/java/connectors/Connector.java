package ar.com.lapsa.java.connectors;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connector {
    private static String driver="com.mysql.cj.jdbc.Driver";    // driver mysql 6 o sup
    
    //Localhost
    //private static String url="jdbc:mysql://localhost:3306/colegio";
    //private static String user="root";
    //private static String pass="root";
    
    //remotemysql.com
    private static String url="jdbc:mysql://192.168.100.16:3306/Bares?serverTimezone=UTC";
    private static String user="root";
    private static String pass="";

    private static Connection conn=null;
    private Connector(){}
    public synchronized static Connection getConnection(){
        if(conn==null){
            try {
                Class.forName(driver);
                conn=DriverManager.getConnection(url,user,pass);
            } catch (Exception e) { e.printStackTrace(); }
        }
        return conn;
    }    
}
