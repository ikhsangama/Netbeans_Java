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
public class HighScore {

    private int id;
    private int skor;
    private Pemain pemain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HighScore() {
        this(0, null);
    }

    public HighScore(int skor, Pemain pemain) {
        this.skor = skor;
        this.pemain = pemain;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public Pemain getPemain() {
        return pemain;
    }

    public void setPemain(Pemain pemain) {
        this.pemain = pemain;
    }

}
