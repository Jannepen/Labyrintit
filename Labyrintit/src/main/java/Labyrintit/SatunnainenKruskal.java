
package Labyrintit;

import java.util.ArrayList;
import java.util.Random;

/**
 * Tämä luokka luo labyrintin käyttäen satunnaista Kruskalin algoritmia
 * Labyrintille ei ole vielä luotu visualisointia, ohjelman ajettua verkon olio kaaret sisältää labyrintin lopulliset seinät
 */

public class SatunnainenKruskal {
    
    /**
     * Kaaret ovat labyrintin seiniä
     */
    
    private static class Kaari {
        private int alku;
        private int loppu;
    
        public Kaari(int alku, int loppu) {
            this.alku = alku;
            this.loppu = loppu;
        }
    }
    
    /**
     * 
     */
    
    private static class Verkko {
            private int solujenMaara;
            private ArrayList<Kaari> kaaret;
            
            public Verkko(int solut) {
                this.solujenMaara = solut;
                this.kaaret = new ArrayList<>();
            }
            
            /**
             * Poistaa seiniä käyttäen etsi-yhdistä tietorakennetta (union find)
             */
            
            public int[][] luoVerkko(int[][] labyrintti) {
                
                int[] vanhempi = new int[solujenMaara];
                
                alustaVanhemmat(vanhempi);
                
                Random random = new Random();
                
                int indeksi = 0;
                while (!kaaret.isEmpty()) {
                    int randomKaari = random.nextInt(kaaret.size());
                    Kaari kaari = kaaret.remove(randomKaari);
                    
                    int aVanhempi = etsi(vanhempi, kaari.alku);
                    int bVanhempi = etsi(vanhempi, kaari.loppu);
                    if (aVanhempi != bVanhempi) {
                        poistaSeina(labyrintti, kaari.alku, kaari.loppu);
                        System.out.print(kaari.alku + " ");
                        System.out.println(kaari.loppu);
                        yhdista(vanhempi, aVanhempi, bVanhempi);
                    }
                    indeksi++;
                }
                return labyrintti;
            }
            
            private int[][] poistaSeina(int[][] labyrintti, int alku, int loppu) {
                int koko = (labyrintti.length + 1) / 2;

                int x = alku % koko;
                int y = (alku - x) / koko;
                if (alku + 1 == loppu) {
                    labyrintti[x * 2 + 1][y * 2] = 1;
                } else {
                    labyrintti[x * 2][y * 2 + 1] = 1;
                }
                
                return labyrintti;
            }
            
            /**
             * Etsii annetun solmun juuren
             * @param vanhempi
             * @param solmu
             * @return palauttaa juuren arvon
             */
            
            private int etsi(int[] vanhempi, int solmu) {
                if (vanhempi[solmu] != solmu) {
                    return etsi(vanhempi, vanhempi[solmu]);
                } else {
                    return solmu;
                }
            }
            
            /**
             * Yhdistää kaksi joukkoa (sen jälkeen, kun niiden välistä poistettu seinä)
             * @param vanhempi
             * @param a
             * @param b 
             */
            
            private void yhdista(int[] vanhempi, int a, int b) {
                int aVanhempi = etsi(vanhempi, a);
                int bVanhempi = etsi(vanhempi, b);
                vanhempi[bVanhempi] = aVanhempi;
            }
            
            /**
             * Alustaa oman joukon jokaiselle solmulle
             * @param vanhempi 
             */
            
            private void alustaVanhemmat(int[] vanhempi) {
                for (int i = 0; i < vanhempi.length; i++) {
                    vanhempi[i] = i;
                }
            }
            
            /**
             * Lisää kaaren verkkoon
             * @param alku
             * @param loppu 
             */
            
            private void lisaaKaari(int alku, int loppu) {
                Kaari kaari = new Kaari(alku, loppu);
                kaaret.add(kaari);
            }
            
    }
    
    /**
     * Alustaa ruudukon labyrintin tekoa varten, jonka jälkeen seiniä poistamalla luo labyrintin
     * @param x
     * @param y
     */
    public int[][] luoLabyrintti(int x, int y) {
        int solujenMaara = x*y;
        
        int[][] labyrintti = new int[x + x - 1][y + y - 1];
        
        alustaLabyrintti(labyrintti);
        
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
        verkko.luoVerkko(labyrintti);
        
        return labyrintti;
    }
    
    private int[][] alustaLabyrintti(int[][] labyrintti) {
        
        for (int i = 0; i < labyrintti.length; i +=2) {
            for (int j = 0; j < labyrintti.length; j += 2) {
                labyrintti[i][j] = 1;
            }
        }
        
        return labyrintti;
    }
    
}
