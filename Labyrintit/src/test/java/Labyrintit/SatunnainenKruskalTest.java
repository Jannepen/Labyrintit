
package Labyrintit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SatunnainenKruskalTest {

    @Before
    public void setUp() {
        SatunnainenKruskal kruskal = new SatunnainenKruskal();
        Verkko verkko = new Verkko(25);
        Kaari kaari = new Kaari(0,1);
    }
    
}
