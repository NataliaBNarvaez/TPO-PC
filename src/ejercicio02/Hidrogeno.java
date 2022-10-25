package TPO.punto2;

import java.util.Random;

public class Hidrogeno implements Runnable{
    Buffer buff = new Buffer();

    public Hidrogeno(Buffer unBuffer) {

        this.buff = unBuffer;
    }

    public void hListo(){
        buff.agregar();

        buff.usar();
        buff.producirH();

        buff.liberar();
        if(buff.lleno()){
            System.out.println("Esta lleno");
            buff.avisaConsumidor();
        }else{
            buff.avisaProductor();
        }
    }

    public void run(){
        Random random = new Random();
        //int hora = random.nextInt(max-min-1)+min)
        int tiempo = random.nextInt((10-1-1)+1);
        try {
            Thread.sleep(tiempo*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hListo();

    }
}
