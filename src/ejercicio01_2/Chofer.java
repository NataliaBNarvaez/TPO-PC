/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author constanza.giacoboni
 */
public class Chofer implements Runnable {

    Transbordador buque;
    int cantViajes = 3;

    public Chofer(Transbordador t) {
        this.buque = t;
    }

    public void run() {
        //System.out.println("El chofer puede salir " + buque.hayLugar());
        while (true) {
            //System.out.println("El chofer puede salir " + !buque.hayLugar());
            if (!buque.hayLugar()) {
                //System.out.println("El chofer puede salir " + buque.hayLugar());
                buque.cruzar();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Chofer.class.getName()).log(Level.SEVERE, null, ex);
                }
                buque.bajar();
                buque.volver();
            }
            //cantViajes--;
        }
    }
}
