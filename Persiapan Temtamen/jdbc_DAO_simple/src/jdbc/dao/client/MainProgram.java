package jdbc.dao.client;

import jdbc.dao.dao.MysqlMahasiswaDAO;
import jdbc.dao.transferObject.Mahasiswa;
import jdbc.utilities.MysqlUtility;

public class MainProgram {
    public static void main(String[] args) {
        MysqlUtility.getConnection();
        //Membuat objek DAO dengan MySQL DBMS
        MysqlMahasiswaDAO mhsDAO = new MysqlMahasiswaDAO();
        //Menampilkan isi awal tabel mahasiswa
        System.out.println("Sebelum: " + mhsDAO.getAll());
        System.out.println("");
        //create, menambahkan 1 baris data mahasiswa
        Mahasiswa mhsAdd = mhsDAO.makeMhsObject();
        mhsAdd.setId(15);
        mhsAdd.setNama("Gusti");
        mhsDAO.add(mhsAdd);
        System.out.println("Setelah add: " + mhsDAO.getAll());
        //update, mengupdate mahasiswa
        Mahasiswa mhsUpdate = mhsDAO.makeMhsObject();
        mhsUpdate.setId(15);
        mhsUpdate.setNama("Arjuna");
        mhsDAO.update(mhsUpdate);
        System.out.println("setelah update: " + mhsDAO.getAll());
        //delete, menghapus mahasiswa
        mhsDAO.delete(15);
        System.out.println("Setelah delete: " + mhsDAO.getAll());
    }
}
