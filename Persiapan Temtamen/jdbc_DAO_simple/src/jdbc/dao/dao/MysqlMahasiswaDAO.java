package jdbc.dao.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.dao.transferObject.Mahasiswa;
import jdbc.utilities.MysqlUtility;

public class MysqlMahasiswaDAO {

    Connection koneksi = null;

    public MysqlMahasiswaDAO() {
        koneksi = MysqlUtility.getConnection();
    }
    
    public Mahasiswa makeMhsObject(){
        return new Mahasiswa();
    }

    /**
     * CRUD: Create/add/insert, Read/getById/select, Update, Delete
     */
    public void add(Mahasiswa mhs) {
        Statement statement = null;

        try {
            statement = koneksi.createStatement();
            String sql = "INSERT into mahasiswa(id, nama) VALUES(" + mhs.getId() + ",'" + mhs.getNama() + "')";
            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Berhasil insert");
            } else {
                System.out.println("Gagal insert");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Gagal menutup statement");
                }
            }
        }
    }

    public void update(Mahasiswa mhs) {
        Statement statement = null;
        try {
            statement = koneksi.createStatement();
            String sql = "UPDATE mahasiswa SET nama='" + mhs.getNama() + "' WHERE id='" + mhs.getId()+ "'";
            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Berhasil update");
            } else {
                System.out.println("Gagal update");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } 
    }

    public void delete(int id) {
        Statement statement = null;
        try {
            statement = koneksi.createStatement();
            String sql = "DELETE FROM mahasiswa WHERE id = '" + id + "'";
            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Berhasil delete");
            } else {
                System.out.println("Gagal delete");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Gagal menutup statement");
                }
            }
        }
    }

    public Mahasiswa getById(int id) {
        Statement statement = null;
        try {
            statement = koneksi.createStatement();
            String sql = "select * from mahasiswa where id='" + id + "'";
            ResultSet result = statement.executeQuery(sql);

            Mahasiswa mhs = new Mahasiswa();

            if (result.next()) {
                mhs.setId(result.getInt("id"));
                mhs.setNama(result.getString("nama"));

                return mhs;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("Koneksi gagal");

            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Gagal menutup statement");
                }
            }
        }
    }

    public List<Mahasiswa> getAll() {
        Statement statement = null;
        ResultSet result = null;
        List<Mahasiswa> list = new ArrayList<>();
        try {
            statement = koneksi.createStatement();
            String sql = "select * from mahasiswa";
            result = statement.executeQuery(sql);

            while (result.next()) {
                Mahasiswa person = new Mahasiswa();
                person.setId(result.getInt("id"));
                person.setNama(result.getString("nama"));
                list.add(person);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("Objek Statement berhasil dibuat");
            System.out.println("Objek Statement gagal dibuat");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Gagal menutup statement");
                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    System.out.println("ResultSet gagal ditutup");
                }
            }
        }
    }

}
