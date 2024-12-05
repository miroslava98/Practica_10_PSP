import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TransferQueue;

public class Puente {

    private String nombre;
    private boolean disponible;

    public Puente(String nombre, boolean disponible) {
        this.nombre = nombre;
        this.disponible = true;
    }

    public boolean isPuenteDisponible() {

        if (disponible) {
            return true;
        } else {
            return false;
        }
    }

    public void cruzarPuente() {
        for (int i = 0; i < 2000; i++) {

        }

        this.disponible = false;
        System.out.println(Thread.currentThread().getName() +
                " está cruzando el puente "
                + this.nombre);
    }

    public void entrarPuente(String direccion) {
        try {
            System.out.println(Thread.currentThread().getName()
                    + " Cruzando el puente para ir dirección " + direccion);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Puente libre para que pasen otros vehiculos
    public void salirPuente() {
        System.out.println(Thread.currentThread().getName() +
                " El puente ya está disponible ");

        disponible = true;
    }

    public synchronized void metodoWait() {
        try {
            while (!isPuenteDisponible()) {
                System.out.println(Thread.currentThread().getName() +
                        " metodoWait(): El puente no está disponible espera, zZZZzzzzZZZZZ");
                wait();
            }
            cruzarPuente();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void metodoCambioDisponibilidad() {

        salirPuente();
        System.out.println(Thread.currentThread().getName()
                + " metodoCambioDisponibilidad(): El puente está disponible. Despierta hilos: ");
        notifyAll();
    }
}
