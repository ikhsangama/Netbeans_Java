/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ikhsan
 */
public class MysklUtility {
    private static Connection koneksi;

    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/kamus";
                String user = "root", password = "";
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                System.out.println("gagal utilities, ClassNotFoundEx: "+ e.getMessage());
            } catch (SQLException e) {
                System.out.println("gagal utilities,SKLEx: "+ e.getMessage());
            }
        }
        return koneksi;
    }
}
