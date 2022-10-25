
package Labyrintit.Kruskal;

import java.util.ArrayList;
import java.util.Random;

/**
 * Tämä luokka luo labyrintin käyttäen satunnaista Kruskalin algoritmia
 * Labyrintille ei ole vielä luotu visualisointia, 
 * ohjelman ajettua verkon olio kaaret sisältää labyrintin lopulliset seinät
 */

public class SatunnainenKruskal {
    
    /**
     * Alustaa ruudukon labyrintin tekoa varten, jonka jälkeen seiniä poistamalla luo labyrintin
     * @param x
     * @param y
     */
    public int[][] luoLabyrintti(int x, int y) {
        int solujenMaara = x*y;
        
        int[][] labyrintti = new int[x + x - 1][y + y - 1];
        
        alustaLabyrintti(labyrintti);
        
        Verkko verkko = new Verkko(solujenMaara);
        
        int luku = 0;
        for (int j = 1; j < y + 1; j++) {
            for (int i = 1; i < x + 1; i++) {
                if (i != x) {
                    verkko.lisaaKaari(luku, luku + 1);
                }
                if (j != y) {
                    verkko.lisaaKaari(luku, luku + x);
                }
                luku++;
            }
        }
        verkko.luoVerkko(labyrintti);
        
        return labyrintti;
    }
    
    public int[][] alustaLabyrintti(int[][] labyrintti) {
        
        for (int i = 0; i < labyrintti.length; i +=2) {
            for (int j = 0; j < labyrintti.length; j += 2) {
                labyrintti[i][j] = 1;
            }
        }
        
        return labyrintti;
    }
    
}
