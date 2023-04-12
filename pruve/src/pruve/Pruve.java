/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruve;

import java.util.Scanner;

/**
 *
 * @author FlowUser
 */
public class Pruve {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in).useDelimiter("\n");
        System.out.println("menu");
        int num = l.nextInt();
        int suma = 0;
        tula(num, suma);
    }

    public static void tula(int num, int suma) {
        System.out.println("terminamos brotheeer"); 
        if (suma< num) {
            System.out.println(suma);
           
            tula(num, suma+1);
            
        }
        
    }
}
