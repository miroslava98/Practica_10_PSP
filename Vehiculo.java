public class Vehiculo implements Runnable {

    private String nombre;
    private String direccion;
    private Puente puente;

    public Vehiculo(String nombre, String direccion, Puente puente) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.puente = puente;

        System.out.println("Vehiculo " + Thread.currentThread().getName() + " llega al Puente");
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()
                + " quiere atravesar el puente para ir a la " + direccion);

        if (puente.isPuenteDisponible()) {

            puente.cruzarPuente();

            puente.entrarPuente(direccion);

            puente.salirPuente();

        } else {
            System.out.println("El puente no está disponible, espera");
        }
    }

}