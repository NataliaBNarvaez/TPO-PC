/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01_2;

/**
 *
 * @author constanza.giacoboni
 */
public class Transbordador {
    int capacidad = 10;
    int espaciosOcupados = 0;
    boolean sePuede = true;
    
    public Transbordador(){
        
    }
    
    public synchronized boolean hayLugar(){
        return espaciosOcupados < capacidad;
    }
    
    public synchronized boolean esteLado(){
        return sePuede;
    }
    
    public synchronized boolean subir(int nombre){
    	boolean subio = false;
    	if(espaciosOcupados < capacidad) {
    		System.out.println("El auto " + nombre + " subio.");
            espaciosOcupados++;
            subio = true;
    	} else {
    		System.out.println("El auto " + nombre + " no pudo subir.");
    	}
    	return subio;        
    }
    
    public synchronized void bajar(){
        System.out.println("Se libero el buque.");
        espaciosOcupados = 0;
    }
    
    public synchronized void cruzar(){
        System.out.println("El buque empezo a cruzar con " + espaciosOcupados + " espacios ocupados.");
        sePuede = false;
    }
    
    public synchronized void volver(){
        System.out.println("El buque volvio.");
        sePuede = true;
    }
}
