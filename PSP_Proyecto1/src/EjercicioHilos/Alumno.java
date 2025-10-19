package EjercicioHilos;


class Alumno implements Runnable {
    private String mensaje;
    private String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.mensaje = "Hola soy " + nombre + " y este es mi mensaje número ";
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(nombre + " ha sido interrumpido.");
                return;
            }
            System.out.println(mensaje + i);
            try {
                Thread.sleep(500); // 0.5 segundos
            } catch (InterruptedException e) {
                System.out.println(nombre + " fue interrumpido durante el sleep.");
                return;
            }
        }
    }
}


