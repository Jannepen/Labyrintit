
package Labyrintit.Kruskal;

import org.junit.Test;
import static org.junit.Assert.*;

public class SatunnainenKruskalTest {
    
    @Test
    public void reittiVasempaanYlakulmaan() {
        SatunnainenKruskal kruskal = new SatunnainenKruskal();
        int[][] labyrintti = kruskal.luoLabyrintti(8,8);
        
        boolean[][] taulukko = luoTotuusTaulukko(labyrintti);
        
        assertEquals(true, taulukko[taulukko.length - 1][0]);
    }
    
    @Test
    public void reittiOikeaanAlakulmaan() {
        SatunnainenKruskal kruskal = new SatunnainenKruskal();
        int[][] labyrintti = kruskal.luoLabyrintti(8,8);
        
        boolean[][] taulukko = luoTotuusTaulukko(labyrintti);
        
        assertEquals(true, taulukko[taulukko.length - 1][taulukko.length - 1]);
    }
    
    @Test
    public void reittiVasempaanAlakulmaan() {
        SatunnainenKruskal kruskal = new SatunnainenKruskal();
        int[][] labyrintti = kruskal.luoLabyrintti(8,8);
        
        boolean[][] taulukko = luoTotuusTaulukko(labyrintti);
        
        assertEquals(true, taulukko[0][taulukko.length - 1]);
    }
    
    //palauttaa taulukon, jonka reitti tarkistettu syvyyshaulla
    private boolean[][] luoTotuusTaulukko(int[][] labyrintti) {
        
        boolean[][] vierailtu = new boolean[labyrintti.length][labyrintti.length];
        
        haku(0, 0, labyrintti, vierailtu);
        
        return vierailtu;
    }
    
    //syvyyshaku
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

