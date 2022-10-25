/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio01;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author constanza.ibarra
 */
public class Transbordador {
    int  espacioOcupado = 0;
    int capacidad = 10;
    int enEspera = 0;
    boolean sePuede = true;
    int viajesRealizados = 1;
    Semaphore semCapacidad = new Semaphore(capacidad);
    Semaphore semVerificar = new Semaphore(1);
    Semaphore semViajar = new Semaphore(0);
    Semaphore semEspera = new Semaphore(1);

    public Transbordador() {
    }
    
    public void verificar(){
        try {
            semVerificar.acquire();
                    } catch (InterruptedException ex) {
            Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean hayLugar(){
        return espacioOcupado < capacidad;
    }
    
    public void ocuparLugar(){
        espacioOcupado++;
        System.out.println("Espacios ocupados " + espacioOcupado);
    }
    
    public void terminarVerificar(){
        semVerificar.release();
    }
    
    public void subir(int n){
        try {
            semCapacidad.acquire();
            System.out.println("El auto " + n + " subio al transbordador");
        } catch (InterruptedException ex) {
            Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cruzar(){
        try {
            semViajar.acquire();
            System.out.println("El transbordador empezo a cruzar, espacios ocupados " + espacioOcupado);
            viajesRealizados++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
        }
        sePuede = false;
    }
    
    public int getViajes(){
        return viajesRealizados;
    }
    
    public void liberarEspacio(){
        for(int i = 0; i < espacioOcupado; i++){
            semCapacidad.release();
        }
        espacioOcupado = 0;
        System.out.println("Se libero el transbordador");
    }
    
    public void volver(){
        System.out.println("El transbordador volvio");
        sePuede = true;
    }
    
    public void liberarEspera() {
    	semEspera.release();
    	enEspera--;
    }
    
    public boolean enEspera() {
    	return enEspera > 0;
    }
    
    public boolean esteLado(int n){
        return sePuede;
    }
    
    public void empezarViajar(){
        semViajar.release();
    }
    
    public void esperar(int n){
        try {
            semEspera.acquire();
            enEspera++;
            System.out.println("Entro en espera el auto "+ n);
        } catch (InterruptedException ex) {
            Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
