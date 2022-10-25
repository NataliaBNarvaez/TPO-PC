/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01_2;

/**
 *
 * @author constanza.giacoboni
 */
public class Auto implements Runnable{
    Transbordador buque;
    int nombre;
    boolean viajo = false;
    
    public Auto(Transbordador t, int n){
        this.buque = t;
        this.nombre = n;
    }
    
    public void run(){
        while(!viajo){
            if(buque.hayLugar() && buque.esteLado()){
                buque.subir(nombre);
                viajo = true;
            }
        }
    }
}
