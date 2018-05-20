/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import db.util.DBUtilities;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ikhsan
 */
public class ProgramJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection koneksi = DBUtilities.getConnection();
        
        Statement st = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj berhasil");
            String kueri = "INSERT into mahasiswa(name, age) VALUES ('Ari',22)";
            st.execute(kueri);
        } catch (SQLException e) {
            System.out.println("Obj gagal");
        } finally{
            if(st!= null){
                try{
                    st.close();
                    System.out.println("st ditutup");
                } catch(SQLException ex){
                    System.out.println("st gagal");
                }
            }
        }
    }
    
}
