package penjualan;

import java.sql.*; // membaca komponen paket yang dibutuhkan untuk koneksi database
import javax.swing.JOptionPane; //membaca JFrame JOptionPane

public class koneksi {
    //deklarasi variabel connection database
        private static Connection KoneksiDatabase;
    //fungsi/method connection
        public static Connection koneksiDB() throws SQLException {
            try {
                String DB ="jdbc:mysql://localhost/sff_java-penjualan";
                String user="admin";
                String pass="admin123";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                KoneksiDatabase = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Tidak ada koneksi","Error",
                JOptionPane.INFORMATION_MESSAGE);
                System.err.println(e.getMessage());
                System.exit(0);
            }
             return KoneksiDatabase;
        }

}
