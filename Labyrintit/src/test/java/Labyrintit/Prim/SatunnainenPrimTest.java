
package Labyrintit.Prim;

import org.junit.Test;
import static org.junit.Assert.*;

public class SatunnainenPrimTest {
    
    @Test
    public void reittiOikeaanYlakulmaan() {
        SatunnainenPrim prim = new SatunnainenPrim(15,15);
        int[][] labyrintti = prim.luoLabyrintti();
        
        int alkuX = 0;
        for (int i = 0; i < labyrintti.length; i++) {
            if (labyrintti[i][1] == 1) {
                alkuX = i;
                break;
            }
        }
        
        boolean[][] taulukko = luoTotuusTaulukko(labyrintti, alkuX, 1);
        
        int loppuX = 0;
        for (int i = labyrintti.length - 1; i >= 0; i--) {
            if (labyrintti[i][2] == 1) {
                loppuX = i;
                break;
            }
        }
        
        assertEquals(true, taulukko[loppuX][2]);
    }
    
    @Test
    public void reittiVasempaanAlakulmaan() {
        SatunnainenPrim prim = new SatunnainenPrim(15,15);
        int[][] labyrintti = prim.luoLabyrintti();
        
        int alkuX = 0;
        for (int i = 0; i < labyrintti.length; i++) {
            if (labyrintti[i][1] == 1) {
                alkuX = i;
                break;
            }
        }
        
        boolean[][] taulukko = luoTotuusTaulukko(labyrintti, alkuX, 1);
        
        int loppuX = 0;
        for (int i = 0; i < labyrintti.length; i++) {
            if (labyrintti[i][labyrintti.length - 3] == 1) {
                loppuX = i;
                break;
            }
        }
        
        assertEquals(true, taulukko[loppuX][labyrintti.length - 3]);
    }
    
    @Test
    public void reittiOikeaanAlakulmaan() {
        SatunnainenPrim prim = new SatunnainenPrim(15,15);
        int[][] labyrintti = prim.luoLabyrintti();
        
        int alkuX = 0;
        for (int i = 0; i < labyrintti.length; i++) {
            if (labyrintti[i][1] == 1) {
                alkuX = i;
                break;
            }
        }
        
        boolean[][] taulukko = luoTotuusTaulukko(labyrintti, alkuX, 1);
        
        int loppuX = 0;
        for (int i = labyrintti.length - 1; i >= 0; i--) {
            if (labyrintti[i][labyrintti.length - 2] == 1) {
                loppuX = i;
                break;
            }
        }
        
        assertEquals(true, taulukko[loppuX][labyrintti.length - 2]);
    }
    
    private boolean[][] luoTotuusTaulukko(int[][] labyrintti, int x, int y) {
        
        boolean[][] vierailtu = new boolean[labyrintti.length][labyrintti.length];
        
        haku(x, y, labyrintti, vierailtu);
        
        return vierailtu;
    }
    
    private void haku(int x, int y, int[][] labyrintti, boolean[][] vierailtu) {
        if (x < 0 || y < 0 || x >= vierailtu.length || y >= vierailtu.length) {
            return;
        }
        if (labyrintti[x][y] == 0 || vierailtu[x][y] == true) {
            return;
        }
        vierailtu[x][y] = true;
        haku(x + 1, y, labyrintti, vierailtu);
        haku(x - 1, y, labyrintti, vierailtu);
        haku(x, y + 1, labyrintti, vierailtu);
        haku(x, y - 1, labyrintti, vierailtu);
    }
    
}
