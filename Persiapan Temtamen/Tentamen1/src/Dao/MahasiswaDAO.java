/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import TransferObject.Mahasiswa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilities.MysklUtilities;

/**
 *
 * @author Ikhsan
 */
public class MahasiswaDAO {

    Connection koneksi = null;

    public MahasiswaDAO() {
        koneksi = MysklUtilities.getConnection();
    }

    public Mahasiswa MakeMhsObject() {
        return new Mahasiswa();
    }

    //    CRUD
    public void add(Mahasiswa mhs) {
        Statement st = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj berhasil");
            String kueri = "INSERT into mahasiswa(nama,umur,jeniskelamin) VALUES ('" + mhs.getNama() + "'," + mhs.getUmur() + ",'"+mhs.getJeniskelamin()+"')";
            st.execute(kueri);
        } catch (SQLException e) {
            System.out.println("Add gagal: " + e.getMessage());
        }
    }

    public void update(Mahasiswa mhs) {
        Statement st = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj berhasil");
            String kueri = "UPDATE mahasiswa SET nama='" + mhs.getNama() + "',umur="+mhs.getUmur()+", jeniskelamin='"+mhs.getJeniskelamin()+"' WHERE id='" + mhs.getId() + "'";
            st.execute(kueri);
        } catch (SQLException e) {
            System.out.println("Update gagal: " + e.getMessage());
        }
    }

    public void delete(int id) {
//        String kueri = "DELETE FROM mahasiswa WHERE id='" + id + "'";
        Statement st = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj berhasil");
            String kueri = "DELETE FROM mahasiswa WHERE id='" + id + "'";
            st.execute(kueri);
        } catch (SQLException e) {
            System.out.println("delete gagal: " + e.getMessage());
        }
    }

    public Mahasiswa getById(int id) {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj Select berhasil dibuat");
            String kueri = "SELECT * FROM mahasiswa WHERE id='" + id + "'";
            rs = st.executeQuery(kueri);

            Mahasiswa mhs = new Mahasiswa();

            if (rs.next()) {
                mhs.setId(rs.getInt("id"));
                mhs.setNama(rs.getString("nama"));
                mhs.setUmur(rs.getInt("umur"));
                mhs.setJeniskelamin(rs.getString("jeniskelamin"));
                return mhs;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("getByID gagal:" + e.getMessage());
        }
        return null;
    }

    public List<Mahasiswa> getAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Mahasiswa> list = new ArrayList<>();
        try {
            st = koneksi.createStatement();
            System.out.println("Objek Statement berhasil dibuat");
            String kueri = "select * from mahasiswa";
            rs = st.executeQuery(kueri);

            while (rs.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setId(rs.getInt("id"));
                mhs.setNama(rs.getString("nama"));
                mhs.setUmur(rs.getInt("umur"));
                mhs.setJeniskelamin(rs.getString("jeniskelamin"));
                list.add(mhs);
            }
        } catch (SQLException ex) {
            System.out.println("gagal MySklMahasiswaDAO: " + ex.getMessage());
        }
        return list;
    }

    public void truncate() {
        Statement st = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj berhasil");
            String kueri = "TRUNCATE TABLE mahasiswa";
            st.execute(kueri);
        } catch (SQLException e) {
            System.out.println("Truncate gagal: " + e.getMessage());
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
