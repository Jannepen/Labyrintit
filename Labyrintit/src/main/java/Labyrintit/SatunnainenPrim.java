
package Labyrintit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Tämä luokka luo labyrintin käyttäen satunnaista Primin algoritmia
 * Luotu labyrintti ei vielä tulostu näkyviin, mutta algoritmin toimiminen on testattu
 */

public class SatunnainenPrim {
    private boolean ruudukko[][];
    private int leveys;
    private int korkeus;
    
    public SatunnainenPrim(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudukko = new boolean[leveys][korkeus];
    }
    
    public void luoLabyrintti() {
        LinkedList<int[]> tunnelit = new LinkedList<>();
        Random r = new Random();
        
        int x = r.nextInt(leveys);
        int y = r.nextInt(korkeus);
        int[] alkutunneli = new int[]{x,y,x,y};
        tunnelit.add(alkutunneli);
        
        while (!tunnelit.isEmpty()) {
            int[] tunneli = tunnelit.remove(r.nextInt(tunnelit.size()));
            x = tunneli[2];
            y = tunneli[3];
            
            if (ruudukko[x][y] == false) {
                ruudukko[tunneli[0]][tunneli[1]] = true;
                ruudukko[x][y] = true;
                
                if (y >= 2 && ruudukko[x][y-2] == false) {
                    int[] uusiTunneli = new int[]{x,y-1,x,y-2};
                    tunnelit.add(uusiTunneli);
                }
                
                if (y < korkeus - 2 && ruudukko[x][y+2] == false) {
                    int[] uusiTunneli = new int[]{x,y+1,x,y+2};
                    tunnelit.add(uusiTunneli);
                }
                
                if (x >= 2 && ruudukko[x-2][y] == false) {
                    int[] uusiTunneli = new int[]{x-1,y,x-2,y};
                    tunnelit.add(uusiTunneli);
                }
                
                if (x < korkeus - 2 && ruudukko[x+2][y] == false) {
                    int[] uusiTunneli = new int[]{x+1,y,x+2,y};
                    tunnelit.add(uusiTunneli);
                }
                
            }
        }
        
    }
    
    
}
