/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ikhsan
 */
public class JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc_data";
            String user = "root", password = "";
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Berhasil");
            
            Statement st = conn.createStatement();
            String kuery = "Select * from mahasiswa";
            ResultSet rs = st.executeQuery(kuery);
            while (rs.next()){
                System.out.println("id: "+ rs.getInt(1)+ ", nama: "+rs.getString(2));
            }
            
        }
        catch(ClassNotFoundException e){
            System.out.println("gagal 1:"+ e.getMessage());
        }
        catch(SQLException e){
            System.out.println("gagal 2:"+ e.getMessage());
        }
        finally{
            if (conn != null) {
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("gagal 3"+ e.getMessage());
                }
            }
        }
    }
    
}
