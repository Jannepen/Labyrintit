
package Labyrintit;

import java.util.ArrayList;
import java.util.Random;

public class SatunnainenKruskal {
    
    private static class Kaari {
        private final int alku;
        private final int loppu;
    
        public Kaari(int alku, int loppu) {
            this.alku = alku;
            this.loppu = loppu;
        }
    }
    
    private static class Verkko {
            private int solujenMaara;
            private ArrayList<Kaari> kaaret;
            
            public Verkko(int solut) {
                this.solujenMaara = solut;
                this.kaaret = new ArrayList<>();
            }
            
            public void luoVerkko() {
                
                int[] vanhempi = new int[solujenMaara];
                
                alustaVanhemmat(vanhempi);
                
                Random random = new Random();
                
                int indeksi = 0;
                while (indeksi < solujenMaara - 1) {
                    int randomKaari = random.nextInt(kaaret.size());
                    Kaari kaari = kaaret.remove(randomKaari);
                    
                    int aVanhempi = etsi(vanhempi, kaari.alku);
                    int bVanhempi = etsi(vanhempi, kaari.loppu);
                    if (aVanhempi != bVanhempi) {
                        yhdista(vanhempi, aVanhempi, bVanhempi);
                    }
                    indeksi++;
                }
            }
            
            private int etsi(int[] vanhempi, int solmu) {
                if (vanhempi[solmu] != solmu) {
                    return etsi(vanhempi, vanhempi[solmu]);
                } else {
                    return solmu;
                }
            }
            
            private void yhdista(int[] vanhempi, int a, int b) {
                int aVanhempi = etsi(vanhempi, a);
                int bVanhempi = etsi(vanhempi, b);
                vanhempi[bVanhempi] = aVanhempi;
            }
            
            private void alustaVanhemmat(int[] vanhempi) {
                for (int i = 0; i < vanhempi.length; i++) {
                    vanhempi[i] = i;
                }
            }
            
            private void lisaaKaari(int alku, int loppu) {
                Kaari kaari = new Kaari(alku, loppu);
                kaaret.add(kaari);
            }
            
    }
    
    public void luoLabyrintti(int x, int y) {
        int solujenMaara = x*y;
        
        Verkko verkko = new Verkko(solujenMaara);
        
        int luku = 0;
        for (int j = 1; j < y + 1; j++) {
            for (int i = 1; i < x + 1; i++) {
                if (i != x) {
                    verkko.lisaaKaari(luku, luku + 1);
                }
                if (j != y) {
                    verkko.lisaaKaari(luku, luku + x);
                }
                luku++;
            }
        }
        verkko.luoVerkko();
    }
    
}
