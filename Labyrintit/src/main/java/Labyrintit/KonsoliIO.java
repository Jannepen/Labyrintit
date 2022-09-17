package Labyrintit;

import java.util.Scanner;

public class KonsoliIO implements IO {
    private final Scanner konsoliInput;
    
    public KonsoliIO(Scanner input) {
        konsoliInput = input;
    }
    
    public Scanner getkonsoliInput() {
        return konsoliInput;
    }
    
    public int nextInt() {
        return Integer.parseInt(konsoliInput.nextLine());
    }
    
    public String nextLine() {
        return konsoliInput.nextLine();
    }
    
    public void print(String viesti) {
        System.out.println(viesti);
    }
}
