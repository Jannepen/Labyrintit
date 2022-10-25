
package Labyrintit.Kruskal;

import java.util.ArrayList;
import java.util.Random;


public class Verkko {
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
                    
            int aVanhempi = etsi(vanhempi, kaari.getAlku());
            int bVanhempi = etsi(vanhempi, kaari.getLoppu());
            if (aVanhempi != bVanhempi) {
                poistaSeina(labyrintti, kaari.getAlku(), kaari.getLoppu());
                System.out.print(kaari.getAlku() + " ");
                System.out.println(kaari.getLoppu());
                yhdista(vanhempi, aVanhempi, bVanhempi);
            }
            indeksi++;
        }
        return labyrintti;
    }
            
    public int[][] poistaSeina(int[][] labyrintti, int alku, int loppu) {
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

    public ArrayList<Kaari> getKaaret() {
        return kaaret;
    }
            
    /**
     * Etsii annetun solmun juuren
     * @param vanhempi
     * @param solmu
     * @return palauttaa juuren arvon
     */
            
    public int etsi(int[] vanhempi, int solmu) {
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
            
    public void yhdista(int[] vanhempi, int a, int b) {
        int aVanhempi = etsi(vanhempi, a);
        int bVanhempi = etsi(vanhempi, b);
        vanhempi[bVanhempi] = aVanhempi;
    }
            
    /**
     * Alustaa oman joukon jokaiselle solmulle
     * @param vanhempi 
     */
            
    public void alustaVanhemmat(int[] vanhempi) {
        for (int i = 0; i < vanhempi.length; i++) {
            vanhempi[i] = i;
        }
    }
            
    /**
     * Lisää kaaren verkkoon
     * @param alku
     * @param loppu 
     */
            
    public void lisaaKaari(int alku, int loppu) {
        Kaari kaari = new Kaari(alku, loppu);
        kaaret.add(kaari);
    }
    
}
