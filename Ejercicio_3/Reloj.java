/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Reloj {

    int hora = 0;
    int revisando = 0;

    public synchronized void despertarVecino() {
        this.notify();
    }

    public synchronized boolean irATrabajar(int unaHora) {
        boolean tieneQueIr = false;
        if (revisando == 0) {

            if (hora == unaHora) {
                System.out.println(Thread.currentThread().getName() + " debe ir a trabajar, tiene hora " + unaHora + "  hora: " + hora);
                tieneQueIr = true;
            } else {
                try {
                    System.out.println(Thread.currentThread().getName() + " No puede trabajar, esperando... tiene hora " + unaHora + "  hora: " + hora);
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tieneQueIr;
    }

    public synchronized void cambiarHora() {
        revisando++;
        hora++;
        System.out.println("Cambio hora a " + hora);
        revisando--;
    }
//    }

    public synchronized void volverDeTrabajar() {
        try {
            System.out.println("Volviendo de trabajar");
            this.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int n = 0;

    public synchronized void aumentarN() {
        n++;
        System.out.println("Trabajo " + n);
    }

    public synchronized int getN() {
        return n;
    }

}
