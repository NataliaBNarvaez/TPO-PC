package TPO.punto2;

import java.util.Random;

public class Oxigeno implements Runnable{

    Buffer buff = new Buffer();

    public Oxigeno(Buffer buff) {
        this.buff = buff;
    }

    public void oListo(){
        buff.agregar();

        buff.usar();
        buff.producirO();
        buff.liberar();
        if(buff.lleno()){
            buff.avisaConsumidor();
        }else{
            buff.avisaProductor();
        }
    }
    public void run(){
        Random random = new Random();
        int tiempo = random.nextInt((10-1-1)+1);
        try {
            Thread.sleep(tiempo*1000);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        oListo();
    }
}
