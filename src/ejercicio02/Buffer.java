package TPO.punto2;

import java.util.concurrent.Semaphore;

public class Buffer {
    //Deberia tener los metodos synchronized
    private int recipiente = 0;
    private int cantO = 0;
    private int cantH=0;
    private final int CANT_MAX = 5;
    Semaphore semProductor = new Semaphore(1);
    Semaphore semConsumidor = new Semaphore(0);
    Semaphore semVerificar = new Semaphore(1);

    public boolean lleno(){
        return recipiente==CANT_MAX;
    }
    public void hacerAgua(){
        System.out.println("Hice agua");
        cantH=cantH-2;
        cantO--;
        recipiente++;
    }
    public void producirH(){

        cantH++;
        if(cantH>=2 && cantO>=1){
            this.hacerAgua();
        }
    }
    public void producirO(){
        cantO++;
        if(cantH>=2 && cantO>=1){
            this.hacerAgua();
        }
    }

    public void agregar(){
        try {
            semProductor.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void usar(){

        try {
            semVerificar.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void liberar(){
        semVerificar.release();
    }
    public void avisaConsumidor(){
        semConsumidor.release();
    }
    public void sacar(){
        try {
            semConsumidor.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void avisaProductor(){
        semProductor.release();
    }
    public void consumir(){
        System.out.println("Se vacio");
        recipiente=0;
    }
}
