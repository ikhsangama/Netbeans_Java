/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferObject.Kamus;
import utilities.MysklUtility;

/**
 *
 * @author Ikhsan
 */
public class KamusDAO {

    Connection koneksi = null;

    public KamusDAO() {
        koneksi = MysklUtility.getConnection();
    }

    public Kamus MakeKamusObject() {
        return new Kamus();
    }

//    CRUD
    public void add(Kamus kms) {
        Statement st = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj berhasil");
            String kueri = "INSERT into tabel(ind,eng) VALUES ('" + kms.getInd() + "','" + kms.getEng() + "')";
            st.execute(kueri);
        } catch (SQLException e) {
            System.out.println("Add gagal: " + e.getMessage());
        }
    }

    public void update(Kamus kms) {
        Statement st = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj berhasil");
            String kueri = "UPDATE tabel SET ind='" + kms.getInd() + "', eng='"+kms.getEng()+"' WHERE id='" + kms.getId() + "'";
//            String kueri = "UPDATE tabel SET ind='" + kms.getInd() + "' WHERE id='" + kms.getId() + "'";
//            st.execute(kueri);
//            kueri = "UPDATE tabel SET eng='" + kms.getEng() + "' WHERE id='" + kms.getId() + "'";
            st.execute(kueri);
        } catch (SQLException e) {
            System.out.println("Update gagal: " + e.getMessage());
        }
    }

    public void delete(int id) {
        Statement st = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj berhasil");
            String kueri = "DELETE FROM tabel WHERE id='" + id + "'";
            st.execute(kueri);
        } catch (SQLException e) {
            System.out.println("delete gagal: " + e.getMessage());
        }
    }

    public Integer searchId(String s) {
        ResultSet rs = null;
        Statement st = null;
        Integer hasil = null;

//        KHUSUS CARI
        PreparedStatement ps = null;
        try {
            ps = koneksi.prepareStatement("SELECT * FROM tabel WHERE ind=?");
            ps.setString(1, s);
            rs = ps.executeQuery();
            if (rs.next()) {
                hasil = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KamusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }

    public Kamus getById(int id) {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj Select berhasil dibuat");
            String kueri = "SELECT * FROM tabel WHERE id='" + id + "'";
            rs = st.executeQuery(kueri);

            Kamus kms = new Kamus();

            if (rs.next()) {
                kms.setId(rs.getInt("id"));
                kms.setInd(rs.getString("ind"));
                kms.setEng(rs.getString("eng"));
                return kms;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("getByID gagal:" + e.getMessage());
        }
        return null;
    }

    public List<Kamus> getAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Kamus> list = new ArrayList<>();
        try {
            st = koneksi.createStatement();
            System.out.println("Objek Statement berhasil dibuat");
            String kueri = "select * from tabel";
            rs = st.executeQuery(kueri);

            while (rs.next()) {
                Kamus kms = new Kamus();
                kms.setId(rs.getInt("id"));
                kms.setInd(rs.getString("ind"));
                kms.setEng(rs.getString("eng"));
                list.add(kms);
            }
        } catch (SQLException ex) {
            System.out.println("gagal MySklMahasiswaDAO: " + ex.getMessage());
        }
        return list;
    }

    public String search(String s) {
        ResultSet rs = null;
        Statement st = null;
        String hasil = null;

//        KHUSUS CARI
        PreparedStatement ps = null;
        try {
            ps = koneksi.prepareStatement("SELECT * FROM tabel WHERE ind=?");
            ps.setString(1, s);
            rs = ps.executeQuery();
            if (rs.next()) {
                hasil = rs.getString("eng");
            } else {
                hasil = "tidak ditemukan";
            }
        } catch (SQLException ex) {
            Logger.getLogger(KamusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}
