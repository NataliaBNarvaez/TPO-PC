/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio01;

/**
 *
 * @author constanza.ibarra
 */
public class Auto implements Runnable {

    Transbordador transbordador;
    int nombre;
    int cant = 4;
    boolean viajo = false;

    public Auto(Transbordador transbordado, int nombre) {
        this.transbordador = transbordado;
        this.nombre = nombre;
    }
    
    //la funcion verificar() es para adquirir el semaforo que protege al contador del transbordador
    public void run() {
        while (!viajo) {
            
            transbordador.verificar();
            System.out.println("Auto " + nombre + " quiere viajar en la vuelta " + transbordador.getViajes());
            if (transbordador.esteLado(this.nombre)) {
                transbordador.terminarVerificar();
                
                transbordador.verificar();
                if (transbordador.hayLugar()) {
                    transbordador.ocuparLugar();
                    transbordador.terminarVerificar();
                    
                    transbordador.subir(this.nombre);
                    viajo = true;
                    
                    transbordador.verificar();
                    if (transbordador.enEspera() && transbordador.getViajes() > 1) {
                        System.out.println("Hay alguien en espera " + transbordador.enEspera());
                        transbordador.liberarEspera();
                    }
                    transbordador.terminarVerificar();    
                } else {
                    transbordador.terminarVerificar();
                    
                    transbordador.empezarViajar();
                    transbordador.esperar(this.nombre);
                }
            } else {
                transbordador.terminarVerificar();
                transbordador.esperar(this.nombre);
            }
        }
    }
}
