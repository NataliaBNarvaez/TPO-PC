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
//    int cantCambiar = 24;

    public Controlador(Reloj reloj) {
        this.reloj = reloj;
    }

    public void run() {
        while (reloj.getHora() < 24) {
            reloj.cambiarHora();
//            cantCambiar--;  //para que el dia solo dure 24hrs
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (reloj.getHora() == 24) {
                System.out.println("< Se termino el dia >");
            }
        }

    }

}
