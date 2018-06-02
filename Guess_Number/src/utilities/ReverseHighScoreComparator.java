/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Comparator;
import transferObject.HighScore;

/**
 *
 * @author Ikhsan
 */
public class ReverseHighScoreComparator implements Comparator<HighScore> {
    
    @Override
    public int compare(HighScore hs1, HighScore hs2) {
        Integer o1 = Integer.parseInt("" + hs1.getSkor());
        Integer o2 = Integer.parseInt("" + hs2.getSkor());

        return -o1.compareTo(o2);
    }

}
