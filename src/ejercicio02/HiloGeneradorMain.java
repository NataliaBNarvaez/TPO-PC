package TPO.punto2;

public class HiloGeneradorMain {
    public static void main(String[] args) {
        Buffer unBuffer = new Buffer();
        Oxigeno[] oxigenos = new Oxigeno[10];
        Hidrogeno[] hidrogenos = new Hidrogeno[20];
        HiloConsumidor unConsumidor ;
        int cantOx = oxigenos.length;
        int cantHid = hidrogenos.length;
        Thread[] hilosOxigeno = new Thread[cantOx];
        Thread[] hilosHidrogeno = new Thread[cantHid];
        Thread hiloConsumidor;

        unConsumidor = new HiloConsumidor(unBuffer);
        hiloConsumidor = new Thread(unConsumidor);
        hiloConsumidor.start();

        for (int i = 0; i <cantOx ; i++) {
            oxigenos[i] = new Oxigeno(unBuffer);
        }
        for (int i = 0; i <cantHid ; i++) {
            hidrogenos[i]=new Hidrogeno(unBuffer);
        }
        for (int i = 0; i <cantOx ; i++) {
            hilosOxigeno[i] = new Thread(oxigenos[i]);
        }
        for (int i = 0; i <cantHid ; i++) {
            hilosHidrogeno[i] = new Thread(hidrogenos[i]);
        }
        for (int i = 0; i <cantOx ; i++) {
            hilosOxigeno[i].start();
        }
        for (int i= 0; i <cantHid ; i++) {
            hilosHidrogeno[i].start();
        }

    }
}
