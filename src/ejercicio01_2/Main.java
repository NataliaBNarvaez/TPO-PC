/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio01_2;

/**
 *
 * @author constanza.giacoboni
 */
public class Main {

    public static void main(String[] args) {
        Transbordador transbordador = new Transbordador();
        int cantAutos = 60;
        Auto[] autos = new Auto[cantAutos];
        Chofer chofer = new Chofer(transbordador);
        Thread hiloChofer = new Thread(chofer);
        Thread[] hilosAutos = new Thread[cantAutos];

        for (int i = 0; i < cantAutos; i++) {
            autos[i] = new Auto(transbordador, i);
        }

        for (int j = 0; j < cantAutos; j++) {
            hilosAutos[j] = new Thread(autos[j]);
        }
        
        hiloChofer.start();
        
        for (int k = 0; k < cantAutos; k++) {
            hilosAutos[k].start();
        }
    }
}
