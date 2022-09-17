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
                io.print("Luodaan labyrinttia");
                break;
            case 2:
                io.print("Luodaan labyrinttia");
                break;
            case 3:
                this.poistumisTila = true;
                this.poistu();
        }
        
    }
}
