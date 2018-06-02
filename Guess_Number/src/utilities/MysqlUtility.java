package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtility {

    private static Connection koneksi;

    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    System.out.println("error : " + ex.getMessage());
                }
                String url = "jdbc:mysql://localhost:3306/guess_game";
                String user = "root";
                String password = "";
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Sukses");
            } catch (SQLException ex) {
                System.out.println("Koneksi Gagal...." + ex.getMessage());
            }
        }
        return koneksi;
    }

    /**
     * Menutup koneksi ke DB
     */
    public static void closeConnection() {
        if (koneksi != null) {
            try {
                koneksi.close();
                System.out.println("Koneksi Berhasil ditutup.");
            } catch (SQLException ex) {
                System.out.println("Gagal Menutup koneksi : " + ex.getMessage());
            }
        } else{
            System.out.println("Tidak ada objek koneksi");
        }
    }
}
