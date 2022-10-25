
package Labyrintit.Kruskal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VerkkoTest {
    
    @Test
    public void lisaaKaarenVerkkoon() {
        Verkko verkko = new Verkko(9);
        verkko.lisaaKaari(5,6);
        assertEquals(1, verkko.getKaaret().size());
    }
    
//    @Test
//    public void poistaaSeinanLabyrintista() {
//        Verkko verkko = new Verkko(25);
//        int[][] labyrintti = new int[5][5];
//        verkko.poistaSeina(labyrintti, 5, 6);
//        assertEquals(1, labyrintti[4][3]);
//    }
    
}
