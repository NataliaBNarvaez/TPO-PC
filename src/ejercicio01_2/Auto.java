/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01_2;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author constanza.giacoboni
 */
public class Auto implements Runnable{
    Transbordador buque;
    int nombre;
    boolean viajo = false;
    boolean pudoSubir = false;
    
    public Auto(Transbordador t, int n){
        this.buque = t;
        this.nombre = n;
    }
    
    public void run(){
        while(!viajo){
            if(buque.esteLado()){
                pudoSubir = buque.subir(nombre);
                if(pudoSubir) {
                	viajo = true;
                }
            }
            try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(Chofer.class.getName()).log(Level.SEVERE, null, ex);
			}
        }
    }
}
