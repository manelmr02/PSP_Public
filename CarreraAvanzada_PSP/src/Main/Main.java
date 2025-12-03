package Main;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import Clases.Clima;
import Clases.Liebre;
import Clases.Mono;
import Clases.Pajaro;
import Clases.Tortuga;

public class Main {
	
	/*
	 * 	 CARRERA - 500 metros
	 *  Tortuga -> 2m/s
	 *  Liebre -> 5m/s avanza 4s y se duerme 10s
	 * 	Pajaro -> 3m/s puede volar de forma aleatoria (cuando vuela va a 10m/s, si vuela en direccion contraria va a -10m/s) 
	 * 	Hay un tunel del metro 50 al 150 donde solo pueden entrar de uno en uno, es decir un Semaphore.
	 * 	Hay posibilidad de que sople el viento, dentro del tunel no afecta, y solo afecta al pajaro si esta volando +5m/s a favor -5m/s si en contra, si sopla el viento
	 * 	la liebre se despierta (dentro del tunel el viento no afecta ni al pajaro (aunque vuele), ni a la libre aunque se duerma)
	 * 	Existen tambien charcos cada 10m, al pisarlos la tortuga obtiene un bonus de 3m/s (ese segundo nada mas), la liebre se resbala y tarda 5sen ponerse de pie y
	 * 	continuar, y al pajaro si esta volando no le afecta pero si esta corriendo se resbala y tarda 5 segundos en continuar (como la liebre)
	 * 
	 * */
	
	private final static int DISTANCIA_CARRERA=500;
    private final static int ENTRADA_TUNEL=50;
    private final static int SALIDA_TUNEL=150;
	
	public static void main(String[] args){
/*
        Semaphore tunel = new Semaphore(1);
        Clima clima = new Clima();
        Tortuga tortuga = new Tortuga(tunel, clima);
        Liebre liebre = new Liebre(tunel, clima);
        Pajaro pajaro = new Pajaro(tunel, clima);
        */
        Semaphore liana1=new Semaphore(1);
        Semaphore liana2=new Semaphore(1);
        Semaphore liana3=new Semaphore(1);
        Semaphore liana4=new Semaphore(1);
        Semaphore liana5=new Semaphore(1);
        ArrayList<Semaphore> lianas=new ArrayList<Semaphore>();
        lianas.add(liana1);
        lianas.add(liana2);
        lianas.add(liana3);
        lianas.add(liana4);
        lianas.add(liana5);
        Mono m1=new Mono(5,"Mono",lianas);
        Mono m2=new Mono(5,"Orangutan",lianas);
        Mono m3=new Mono(5,"Mono veloz",lianas);
        
        System.out.println("¡Comienza la carrera de "+DISTANCIA_CARRERA+" metros!");
        System.out.println("Túnel del metro: "+ENTRADA_TUNEL+ " al "+SALIDA_TUNEL+"m");
        System.out.println("Charcos cada 10 metros");
        System.out.println("Lianas cada 100 metros (desde el metro 0)");
        /*
        clima.start();
        tortuga.start();
        liebre.start();
        pajaro.start();
        */
        m1.start();
        m2.start();
        m3.start();
        try {
        	/*
            tortuga.join();
            liebre.join();
            pajaro.join();
            clima.detenerClima();
            */
            m1.join();
            m2.join();
            m3.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Carrera finalizada!");
    }
}
