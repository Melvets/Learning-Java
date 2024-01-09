package db;

//Class bufferreader dan inputstreamreader guna menginputkan dari keyboard
import java.io.BufferedReader;
import java.io.InputStreamReader;
//Import driver & koneksi jadi satu
import java.sql.*;


public class latihanKoneksi {
    
//    Menyiapkan parameter JDBC untuk koneksi ke database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/pbo_koneksi" ;
    static final String USER = "root";
    static final String PASS = "";
    
//    Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    
//    Menyiapkan objek agar mengambil data yang kita inputkan
    static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(is);
    
    public static void main (String [] args) {
        
    }

    
}
