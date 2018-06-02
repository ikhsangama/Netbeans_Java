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
public class Kamus {
    
    private int id;
    private String eng;
    private String ind;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    @Override
    public String toString() {
        return "id: "+id+ ", Indonesia: "+ ind+", English: "+ eng; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
