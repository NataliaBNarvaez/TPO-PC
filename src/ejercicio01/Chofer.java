/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio01;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author constanza.ibarra
 */
public class Chofer implements Runnable {

    Transbordador transbordador;
    int cantViajes = 2;

    public Chofer(Transbordador transbordador) {
        this.transbordador = transbordador;
    }

    public void run() {
        while (cantViajes > 0) {
            transbordador.verificar();
            if (!transbordador.hayLugar()) {
                transbordador.terminarVerificar();
                transbordador.cruzar();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Chofer.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("empezo a verificar");
                transbordador.verificar();
                transbordador.liberarEspacio();
                transbordador.volver();
                transbordador.liberarEspera();
                transbordador.terminarVerificar();
                cantViajes--;
            }
        }
    }
}
