/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferObject;

/**
 *
 * @author Ikhsan
 */
public class Pemain {
    private int id;
    private String nama;
    
    public Pemain(int id, String nama){
        this.id = id;
        this.nama = nama;
    }
    
    public Pemain(){
        this(0, "");
    }

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
        return "Pemain{" + "id=" + id + ", nama=" + nama+ "}";
    }
    
    
}
