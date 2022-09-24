
package Labyrintit;

import java.util.ArrayList;
import java.util.Random;

public class SatunnainenKruskal {
    
    private static class Seina {
        private final int alku;
        private final int loppu;
    
        public Seina(int alku, int loppu) {
            this.alku = alku;
            this.loppu = loppu;
        }
    }
    
    private static class Verkko {
            private int solut;
            private ArrayList<Seina> seinat;
            
            private void lisaaSeina(int alku, int loppu) {
                Seina seina = new Seina(alku, loppu);
                seinat.add(seina);
            }
            
    }
    
}
