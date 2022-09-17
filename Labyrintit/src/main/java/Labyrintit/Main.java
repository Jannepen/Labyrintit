package Labyrintit;

import Labyrintit.Tekstikayttoliittyma;
import java.util.*;


public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world");
        
        IO konsoliIO = new KonsoliIO(new Scanner(System.in));
        
        Tekstikayttoliittyma tekstikayttoliittyma = new Tekstikayttoliittyma(konsoliIO);
        
        while (!tekstikayttoliittyma.poistu()) {
            tekstikayttoliittyma.aloita();
        }
    }
}