
package Labyrintit;

import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

public class KonsoliIOTest {
    
    public KonsoliIOTest() {
    }
    
    @Test
    public void konstruktoriLuoSkannerin() {
        KonsoliIO konsoliTestiIO = new KonsoliIO(new Scanner(System.in));
        assertNotNull(konsoliTestiIO.getkonsoliInput());
    }
    
}
