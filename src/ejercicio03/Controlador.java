/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natalia.narvaez
 */
public class Controlador implements Runnable {

    Reloj reloj;
    int cantCambiar = 24;

    public Controlador(Reloj reloj) {
        this.reloj = reloj;
    }

    public void run() {
        while (cantCambiar > 0) {
            reloj.cambiarHora();
            cantCambiar--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (cantCambiar == 0) {
                System.out.println("Se termino el dia");
            }
        }

    }

}
