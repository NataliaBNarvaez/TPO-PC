/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpobligatorio.ejercicio01;

/**
 *
 * @author constanza.ibarra
 */
public class Main {
    public static void main(String[] args) {
        Transbordador transbordador = new Transbordador();
        int cantAutos = 20;
        Auto[] autos = new Auto[cantAutos];
        Chofer chofer = new Chofer(transbordador);
        Thread hiloChofer = new Thread(chofer);
        Thread[] hilosAutos = new Thread[cantAutos];
        
        for(int i = 0; i < cantAutos; i++){
            autos[i] = new Auto(transbordador, i);
        }
        
        for(int j = 0; j < cantAutos; j++){
            hilosAutos[j] = new Thread(autos[j]);
        }
        
        for(int k = 0; k < cantAutos; k++){
            hilosAutos[k].start();
        }
        
        hiloChofer.start();
    }
}
