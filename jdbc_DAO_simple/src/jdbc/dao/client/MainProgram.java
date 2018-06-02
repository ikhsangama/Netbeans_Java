/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao.client;

import jdbc.dao.dao.MysklMahasiswaDAO;
import jdbc.dao.transferObject.Mahasiswa;
import jdbc.utilities.MysklUtility;

/**
 *
 * @author Ikhsan
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MysklUtility.getConnection();
        //Membuat objek DAO dengan MySKL
        MysklMahasiswaDAO mhsDAO = new MysklMahasiswaDAO();
        //Menampilkan isi awal tabel mahasiswa
        System.out.println("Sebelum: "+mhsDAO.getAll());
        System.out.println("");
        
//        Create
        Mahasiswa mhsAdd = mhsDAO.MakeMhsObject();
        mhsAdd.setId(15);
        mhsAdd.setNama("Gusti");
        mhsDAO.add(mhsAdd);
        System.out.println("Setelah add:"+mhsDAO.getAll());
        
        Mahasiswa mhsAdd2 = mhsDAO.MakeMhsObject();
        mhsAdd.setId(16);
        mhsAdd.setNama("Ngurah");
        mhsDAO.add(mhsAdd);
        System.out.println("Setelah add:"+mhsDAO.getAll());
//        Update
        Mahasiswa mhsUpdate = mhsDAO.MakeMhsObject();
        mhsUpdate.setId(15);
        mhsUpdate.setNama("Arjuna");
        mhsDAO.update(mhsUpdate);
        System.out.println("setelah update: "+mhsDAO.getAll());
//        Delete
        mhsDAO.delete(15);
        System.out.println("setelah delete: "+mhsDAO.getAll());
    }
    
}
