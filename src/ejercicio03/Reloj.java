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
public class Reloj {

    int hora = 0;
    int posActual = 0;
    int total = 0;
    int revisaron = 0;
    int revisandoCont = 0;
//    int revisandoDurm = 0;

    public Reloj(int tot) {
        this.total = tot;
    }

    public synchronized void despertarVecino() {
        this.notifyAll();
    }

    public synchronized boolean irATrabajar(int unaHora, int posPropia) {
        boolean tieneQueIr = false;
        revisoUno();
        if (revisandoCont == 0 && this.cuantosRevisaron() < 11) {
//            revisandoDurm++;
            if (this.soyElVecino(posPropia)) {
                this.aumentarPosActual();
                if (hora == unaHora) {
                    System.out.println("Hilo " + posPropia + " debe trabajar. HORA DE TRABAJO: " + unaHora + "  HORA ACTUAL: " + hora);
                    tieneQueIr = true;
                } else {
                    try {
                        System.out.println("Hilo " + posPropia + " aun NO puede trabajar. HORA DE TRABAJO: " + unaHora + "  HORA ACTUAL: " + hora);
                        this.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                try {
                    System.out.println("Hilo " + posPropia + " NO es vecino");
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            revisandoDurm--;           
        } else {
            System.out.println(posPropia + " Debe esperar a que cambie la hora...");
//            revisandoDurm--;
            if (hora <= 24) {
                cambiarHora();
                resetearRevisaron();
            }
        }
        return tieneQueIr;
    }

    public synchronized void cambiarHora() {
//        if (revisandoDurm == 0) {
        if (hora < 24) {
            revisandoCont++;
            hora++;
            System.out.println("[...Cambio hora a " + hora + "...]");
            revisandoCont--;
        }
//        }
    }

    public synchronized void volverDeTrabajar() {
        try {
            System.out.println("Volvio de trabajar");
            this.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean soyElVecino(int posPropia) {
        boolean esElVecino = false;
        if (posActual != total - 1) {
            esElVecino = (posPropia == posActual + 1);
        } else if (posPropia == total - 1 && posActual == total - 1) {
            esElVecino = true;
        }
        System.out.println("--> Preguntando: " + posPropia + ", vecino: " + posActual);
        return esElVecino;
    }

    public synchronized void aumentarPosActual() {
        posActual++;
        if (posActual == total) {
            posActual = 0;
        }
    }

    public synchronized boolean seTerminoDia() {
        return hora == 24;
    }

    public synchronized int cuantosRevisaron() {
        return revisaron;
    }

    public synchronized void revisoUno() {
        revisaron++;
    }

    public synchronized void resetearRevisaron() {
        revisaron = 0;
    }

    public synchronized int getHora() {
        return hora;
    }
}
