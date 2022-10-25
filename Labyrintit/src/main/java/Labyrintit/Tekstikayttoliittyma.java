package Labyrintit;

import java.util.*;


public class Tekstikayttoliittyma {
    private final IO io;
    private boolean poistumisTila = false;
    
    public Tekstikayttoliittyma(IO io){
        this.io = io;
    }
    
    public boolean poistu() {
        return this.poistumisTila;
    }
    
    public void aloita() {
        io.print("Tervetuloa labyrintinluontiohjelmaan! Valitse toiminto: \n" + 
                "1) Luo labyrintti Kruskalin algoritmilla \n" + 
                "2) Luo labyrintti Primin algoritmilla \n" + 
                "3) Poistu");
        int komento = io.nextInt();
        
        switch(komento) {
            case 1:
                io.print("Anna labyrintin koko:");
                int kruskalKoko = io.nextInt();
                if (kruskalKoko > 2) {
                    io.print("Luodaan labyrinttia");
                    SatunnainenKruskal kruskal = new SatunnainenKruskal();
                    tulostaLabyrintti(kruskal.luoLabyrintti((kruskalKoko + 1) / 2, (kruskalKoko + 1) / 2));
                } else {
                    io.print("Virheellinen koko");
                }
                break;
            case 2:
                io.print("Anna labyrintin koko:");
                int primKoko = io.nextInt();
                if (primKoko > 2) {
                    io.print("Luodaan labyrinttia");
                    SatunnainenPrim prim = new SatunnainenPrim(primKoko, primKoko);
                    int[][] labyrintti = prim.luoLabyrintti();
                    tulostaLabyrintti(labyrintti);
                } else {
                    System.out.println("Virheellinen koko");
                }
                break;
            case 3:
                this.poistumisTila = true;
                this.poistu();
        }
        
    }
    
    private void tulostaLabyrintti(int[][] labyrintti) {
        for (int i = -1; i <= labyrintti.length; i++) {
            for (int j = 0; j < labyrintti.length; j++) {
                if (i == -1) {
                    if (j == 0) {
                        System.out.print(" ");
                    }
                    System.out.print("--");
                    continue;
                }
                if (i == labyrintti.length) {
                    if (j == 0) {
                        System.out.print(" ");
                    }
                    System.out.print("--");
                    continue;
                }
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(labyrintti[i][j] + " ");
                if (j == labyrintti.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
