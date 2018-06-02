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
import transferObject.HighScore;
import transferObject.Pemain;
import utilities.MysqlUtility;

/**
 *
 * @author Ikhsan
 */
public class HighScoreDAO {

    Connection koneksi;

    public HighScoreDAO() {
        koneksi = MysqlUtility.getConnection();
    }

    public HighScore makeHighScoreObj() {
        return new HighScore();
    }

    public void insert(HighScore highScore) {
            PreparedStatement prepare = null;

        try {
            String sql = "INSERT INTO highscore (skor, pemain_id) VALUES (?,?);";
            prepare = koneksi.prepareStatement(sql);
            prepare.setInt(1, highScore.getSkor());
            prepare.setInt(2, highScore.getPemain().getId());
            prepare.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("HighScoreDAO Gagal membuat prepare : " + ex.getMessage());
        } finally {
            if (prepare != null) {
                try {
                    prepare.close();
                    System.out.println("Sukses menutup prepare");
                } catch (Exception e) {
                    System.out.println("Gagal menutup prepare");
                }
            }
        }
    }

    public List<HighScore> selectAll() {
        PreparedStatement prepare = null;
        Statement st = null;
        ResultSet rs = null;
        List<HighScore> highscores = new ArrayList<>();
        
        try {
            String sql = "SELECT * from highscore;";
            prepare = koneksi.prepareStatement(sql);

            rs = prepare.executeQuery();
            while (rs.next()) {
                HighScore highscore = new HighScore();
                int idPemain = rs.getInt("pemain_id");
                PemainDAO dsnService = new PemainDAO();
                highscore.setPemain(dsnService.selectById(idPemain));// ambil objek dosen
                highscore.setId(rs.getInt("id"));
                highscore.setSkor(rs.getInt("skor"));

                highscores.add(highscore);
            }
            return highscores;

        } catch (SQLException ex) {
            System.out.println("Gagal membuat prepare : " + ex.getMessage());
            return highscores;
        } finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (Exception e) {
                    System.out.println("Gagal menutup prepare");
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}
