package EjercicioHilos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nombres = new String[3];
        Thread[] hilos = new Thread[3];

        
        for (int i = 0; i < 3; i++) {
            System.out.print("Introduce el nombre del alumno " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }

        
        for (int i = 0; i < 3; i++) {
            Alumno alumno = new Alumno(nombres[i]);
            hilos[i] = new Thread(alumno);

            // Criterio de interrupción: si el nombre contiene la letra "e"
            if (nombres[i].toLowerCase().contains("e")) {
                System.out.println("Interrumpiendo a " + nombres[i] + " por contener la letra 'e'.");
                hilos[i].start();
                hilos[i].interrupt();
            } else {
                hilos[i].start();
                try {
                    hilos[i].join(); 
                } catch (InterruptedException e) {
                    System.out.println("El hilo principal fue interrumpido.");
                }
            }
        }

        scanner.close();
    }
}