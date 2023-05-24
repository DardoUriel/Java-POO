/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria;

import java.util.Scanner;
import libreria.servicios.Menu;

/**
 * S
 *
 * @author FlowUser
 */
public class Libreria {

    /**
     * @throws java.lang.Exception
     */
    public static Scanner l = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) throws Exception {
        Menu m = new Menu();    
        m.menu();

    }

//    public void presioneTecla() {
//        System.out.println("");
//        System.out.println("Presione ENTER para continuar...");
//        String letra = scan.next();
//    }
}
