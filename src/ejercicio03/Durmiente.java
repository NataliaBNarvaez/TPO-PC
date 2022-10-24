/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03;

/**
 *
 * @author natalia.narvaez
 */
public class Durmiente implements Runnable {

    Reloj reloj;
    int horaLevantarse;
    boolean fueATrabajar = false;

    public Durmiente(Reloj reloj, int hora) {
        this.horaLevantarse = hora;
        this.reloj = reloj;
    }

    int n = 0;

    public void run() {
        while (reloj.getN() < 15) {
            reloj.despertarVecino();
            fueATrabajar = reloj.irATrabajar(horaLevantarse);
            if (fueATrabajar) {
                reloj.volverDeTrabajar();
                reloj.aumentarN();
            }
        }

    }

}
