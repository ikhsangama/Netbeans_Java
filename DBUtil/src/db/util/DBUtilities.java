package db.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ikhsan
 */
public class DBUtilities {

    private static Connection koneksi;

    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/jdbc_data";
                String user = "root", password = "";
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                System.out.println("gagal 1");
            } catch (SQLException sqle) {
                System.out.println("gagal 2");
            }
        }
        return koneksi;
    }
}
