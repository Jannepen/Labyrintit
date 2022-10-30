
package Labyrintit.Prim;

import java.util.ArrayList;
import java.util.Random;

/**
 * Tämä luokka luo labyrintin käyttäen satunnaista Primin algoritmia
 */

public class SatunnainenPrim {
    private int ruudukko[][];
    private int leveys;
    private int korkeus;
    
    /**
     * Konstruktori alustaa labyrintin koon sekä ruudukon
     * @param leveys
     * @param korkeus 
     */
    
    public SatunnainenPrim(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudukko = new int[leveys][korkeus];
    }
    
    /**
     * Metodi, joka luo labyrintin
     * @return palauttaa lopullisen labyrintin
     */
    
    public int[][] luoLabyrintti() {
        ArrayList<int[]> tunnelit = new ArrayList<>();
        Random r = new Random();
        
        // valitaan satunnainen aloituspiste
        int x = r.nextInt(leveys);
        int y = r.nextInt(korkeus);
        int[] alkutunneli = new int[]{x,y,x,y};
        tunnelit.add(alkutunneli);
        
        int alkux = x;
        int alkuy = y;
        
        //laajennetaan labyrinttia niin kauan, että laajenemissuuntia ei ole jäljellä
        while (!tunnelit.isEmpty()) {
            int[] tunneli = tunnelit.remove(r.nextInt(tunnelit.size()));
            x = tunneli[2];
            y = tunneli[3];
            
            //luodaan tunneli, lisätään laajenemissuuntia mikäli mahdollista
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
        
        //merkitään aloituspistettä numerolla 4
        ruudukko[alkux][alkuy] = 4;
        
        return ruudukko;
    }
    
    
}

