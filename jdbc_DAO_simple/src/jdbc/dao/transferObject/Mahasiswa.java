package jdbc.dao.transferObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ikhsan
 */
public class Mahasiswa {
    private int id;
    private String nama;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Mahasiswa{"+"id="+id+", nama="+nama+"}"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
