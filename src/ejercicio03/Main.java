/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reloj reloj = new Reloj();
        Controlador controlador = new Controlador(reloj);
        Durmiente[] arDurmientes = new Durmiente[5];
        Random random = new Random();
        Thread cont = new Thread(controlador);
        cont.start();

        for (int i = 0; i < 5; i++) {
            int hora = random.nextInt((24 - 1 + 1) + 1);
            arDurmientes[i] = new Durmiente(reloj, hora);
        }

        Thread[] arHilos = new Thread[10];
        for (int j = 0; j < 5; j++) {
            arHilos[j] = new Thread(arDurmientes[j]);
        }
        arHilos[0].setName("a");
        arHilos[1].setName("b");
        arHilos[2].setName("c");
        arHilos[3].setName("d");
        arHilos[4].setName("e");
//        arHilos[5].setName("f");
//        arHilos[6].setName("g");
//        arHilos[7].setName("h");
//        arHilos[8].setName("i");
//        arHilos[9].setName("j");

        for (int n = 0; n < 5; n++) {
            arHilos[n].start();
        }

        for (int m = 0; m < 5; m++) {
            try {
                arHilos[m].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Termino el dia dice el main");

    }

}
