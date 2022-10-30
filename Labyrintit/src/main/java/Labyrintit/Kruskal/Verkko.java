
package Labyrintit.Kruskal;

import java.util.ArrayList;
import java.util.Random;

/**
 * Verkkoa kuvaava luokka
 * @author jannepen
 */

public class Verkko {
    private int solujenMaara;
    private ArrayList<Kaari> kaaret;
    
    /**
     * Konstruktori alustaa labyrintin koon ja kaarilistan
     * @param solut 
     */
            
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
        
        // Käy läpi kaaria ja poistaa seiniä niin kauan kuin kaaria on jäljellä
        while (!kaaret.isEmpty()) {
            int randomKaari = random.nextInt(kaaret.size());
            Kaari kaari = kaaret.remove(randomKaari);
                    
            int aVanhempi = etsi(vanhempi, kaari.getAlku());
            int bVanhempi = etsi(vanhempi, kaari.getLoppu());
            if (aVanhempi != bVanhempi) {
                poistaSeina(labyrintti, kaari.getAlku(), kaari.getLoppu());
                yhdista(vanhempi, aVanhempi, bVanhempi);
            }
            indeksi++;
        }
        return labyrintti;
    }
            
    /**
     * Poistaa seinän (eli luo reitin) kahden solun välille visualisoidussa labyrintissa
     * @param labyrintti
     * @param alku
     * @param loppu
     * @return palauttaa labyrintin, jossa yksi uusi reitti
     */
    
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

