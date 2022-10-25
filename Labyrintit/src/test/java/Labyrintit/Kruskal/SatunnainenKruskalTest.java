
package Labyrintit.Kruskal;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SatunnainenKruskalTest {

//    @Before
//    public void setUp() {
//        SatunnainenKruskal kruskal = new SatunnainenKruskal();
//        int[][] labyrintti = new int[10][10];
//    }
    
    @Test
    public void metodiALustaaLabyrintin() {
        SatunnainenKruskal kruskal = new SatunnainenKruskal();
        int[][] labyrintti = new int[10][10];
        kruskal.alustaLabyrintti(labyrintti);
        assertEquals(1, labyrintti[2][2]);
    }
    
}
