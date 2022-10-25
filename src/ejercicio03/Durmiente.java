/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO;

/**
 *
 * @author Usuario
 */
public class Durmiente implements Runnable {

    Reloj reloj;
    int horaLevantarse;
    int posicion;
    boolean fueATrabajar = false;

    public Durmiente(Reloj reloj, int hora, int pos) {
        this.horaLevantarse = hora;
        this.reloj = reloj;
        this.posicion = pos;
    }

    public void run() {
        while (!reloj.seTerminoDia()) {
            reloj.despertarVecino();
            fueATrabajar = reloj.irATrabajar(horaLevantarse, posicion);
            if (fueATrabajar) {
                reloj.volverDeTrabajar();
            }
        }
    }


}
