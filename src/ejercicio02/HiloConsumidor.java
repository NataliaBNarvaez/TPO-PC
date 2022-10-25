package TPO.punto2;

public class HiloConsumidor implements Runnable{
    Buffer buff = new Buffer();

    public HiloConsumidor(Buffer buff) {
        this.buff = buff;
    }

    public void run(){
        while(!buff.lleno()) {


            buff.sacar();
            buff.usar();
            buff.consumir();
            System.out.println("Envase el agua");
            buff.liberar();
            buff.avisaProductor();
        }
    }
}
