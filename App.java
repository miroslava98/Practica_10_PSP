public class App {
    public static void main(String[] args) {

        Puente puente = new Puente("Puente", false);

        Thread vehiculo1 = new Thread(new Vehiculo("Coche1", "derecha", puente));
        Thread vehiculo2 = new Thread(new Vehiculo("Furgoneta1", "izquierda", puente));
        Thread vehiculo3 = new Thread(new Vehiculo("Furgoneta2", "derecha", puente));
        Thread vehiculo4 = new Thread(new Vehiculo("Furgoneta3", "derecha", puente));
        Thread vehiculo5 = new Thread(new Vehiculo("Coche2", "izquierda", puente));

        vehiculo1.start();
        vehiculo2.start();
        vehiculo3.start();
        vehiculo4.start();
        vehiculo5.start();

        try {
            vehiculo1.join();
            vehiculo2.join();
            vehiculo3.join();
            vehiculo4.join();
            vehiculo5.join();
        } catch (Exception e) {
        }

    }
}
