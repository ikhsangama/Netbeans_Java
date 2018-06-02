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
import transferObject.Pemain;
import utilities.MysqlUtility;

/**
 *
 * @author Ikhsan
 */
public class PemainDAO {

    Connection koneksi;

    public PemainDAO() {
        koneksi = MysqlUtility.getConnection();
    }

    public Pemain makePemainObj() {
        return new Pemain();
    }

    public void insert(Pemain pemain) {
        Statement st = null;
        try {
            st = koneksi.createStatement();
            System.out.println("Obj berhasil");
            String kueri = "INSERT into pemain(nama) VALUES ('" + pemain.getNama() + "')";
            st.execute(kueri);
        } catch (SQLException e) {
            System.out.println("Add gagal: " + e.getMessage());
        }
    }

    public void update(Pemain pemain) {

    }

    public void delete(int pemainId) {
        PreparedStatement prepare = null;
        try {
            String skl = "DELETE from pemain WHERE id = ?;";
            prepare = koneksi.prepareStatement(skl);
            prepare.setInt(1, pemainId);
            prepare.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal prepare delete: " + e.getMessage());
        } finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (Exception e) {
                    System.out.println("Gagal menutup prepare delete" + e.getMessage());
                }
            }
        }
    }

    public Pemain selectById(int idPemain) {
        PreparedStatement prepare = null;
        ResultSet result = null;
        Pemain pemain = null;

        try {
            String skl = "SELECT * from pemain WHERE id = ?;";
            prepare = koneksi.prepareStatement(skl);
            prepare.setInt(1, idPemain);
            result = prepare.executeQuery();
            if (result.next()) {
                pemain = new Pemain();
                pemain.setId(result.getInt("id"));
                pemain.setNama(result.getString("nama"));
            }
            return pemain;
        } catch (SQLException ex) {
            System.out.println("Gagal membuat prepare : " + ex.getMessage());
            return pemain;
        } finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (Exception e) {
                    System.out.println("Gagal menutup prepare");
                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public Pemain selectByNama(String namaPemain) {
        PreparedStatement prepare = null;
        ResultSet result = null;
        Pemain pemain = null;

        try {
            String sql = "SELECT * from pemain WHERE nama = ?;";
            prepare = koneksi.prepareStatement(sql);

            prepare.setString(1, namaPemain);

            result = prepare.executeQuery();

            if (result.next()) {
                pemain = new Pemain();

                pemain.setId(result.getInt("id"));
                pemain.setNama(result.getString("nama"));
            }

            return pemain;

        } catch (SQLException ex) {
            System.out.println("Gagal membuat prepare : " + ex.getMessage());
            return pemain;
        } finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (Exception e) {
                    System.out.println("Gagal menutup prepare");
                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public List<Pemain> selectAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Pemain> list = new ArrayList<>();
        try {
            st = koneksi.createStatement();
            System.out.println("Objek Statement berhasil dibuat");
            String kueri = "select * from pemain";
            rs = st.executeQuery(kueri);

            while (rs.next()) {
                Pemain pemain = new Pemain();
                pemain.setId(rs.getInt("id"));
                pemain.setNama(rs.getString("nama"));
                list.add(pemain);
            }
        } catch (SQLException ex) {
            System.out.println("gagal MySklMahasiswaDAO: " + ex.getMessage());
        }
        return list;
    }

}
