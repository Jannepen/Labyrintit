
package Labyrintit.Prim;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Tämä luokka luo labyrintin käyttäen satunnaista Primin algoritmia
 * Luotu labyrintti ei vielä tulostu näkyviin, mutta algoritmin toimiminen on testattu
 */

public class SatunnainenPrim {
    private int ruudukko[][];
    private int leveys;
    private int korkeus;
    
    public SatunnainenPrim(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudukko = new int[leveys][korkeus];
    }
    
    public int[][] luoLabyrintti() {
        ArrayList<int[]> tunnelit = new ArrayList<>();
        Random r = new Random();
        
        int x = r.nextInt(leveys);
        int y = r.nextInt(korkeus);
        int[] alkutunneli = new int[]{x,y,x,y};
        tunnelit.add(alkutunneli);
        
        int alkux = x;
        int alkuy = y;
        
        while (!tunnelit.isEmpty()) {
            int[] tunneli = tunnelit.remove(r.nextInt(tunnelit.size()));
            x = tunneli[2];
            y = tunneli[3];
            
            if (ruudukko[x][y] == 0) {
                ruudukko[tunneli[0]][tunneli[1]] = 1;
                ruudukko[x][y] = 1;
                
                if (y >= 2 && ruudukko[x][y-2] == 0) {
                    int[] uusiTunneli = new int[]{x,y-1,x,y-2};
                    tunnelit.add(uusiTunneli);
                }
                
                if (y < korkeus - 2 && ruudukko[x][y+2] == 0) {
                    int[] uusiTunneli = new int[]{x,y+1,x,y+2};
                    tunnelit.add(uusiTunneli);
                }
                
                if (x >= 2 && ruudukko[x-2][y] == 0) {
                    int[] uusiTunneli = new int[]{x-1,y,x-2,y};
                    tunnelit.add(uusiTunneli);
                }
                
                if (x < korkeus - 2 && ruudukko[x+2][y] == 0) {
                    int[] uusiTunneli = new int[]{x+1,y,x+2,y};
                    tunnelit.add(uusiTunneli);
                }
                
            }
        }
        
        ruudukko[alkux][alkuy] = 4;
        
        return ruudukko;
    }
    
    
}
