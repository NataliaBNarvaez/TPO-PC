/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de hilos durmientes");
        int nroDurmientes = sc.nextInt();
        
        Durmiente[] arDurmientes = new Durmiente[nroDurmientes];
        int cantDurmientes = arDurmientes.length;
        Random random = new Random();       
        
        Reloj reloj = new Reloj(cantDurmientes);
        Controlador controlador = new Controlador(reloj);
        Thread cont = new Thread(controlador);   

        for (int i = 0; i < cantDurmientes; i++) {
            int hora = random.nextInt((24 - 1 + 1) + 1);
            arDurmientes[i] = new Durmiente(reloj, hora, i);
        }

        Thread[] arHilos = new Thread[cantDurmientes];
        for (int j = 0; j < cantDurmientes; j++) {
            arHilos[j] = new Thread(arDurmientes[j]);
        }

        cont.start();
        for (int n = 0; n < cantDurmientes; n++) {
            arHilos[n].start();
        }



    }

}
