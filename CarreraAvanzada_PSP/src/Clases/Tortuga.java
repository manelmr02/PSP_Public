package Clases;

import java.util.concurrent.Semaphore;

public class Tortuga extends Animal{

	public Tortuga(Semaphore tunel,Clima clima){
        super(2,"Tortuga",tunel,clima);
    }

	@Override
    public void run(){
        try {
            while(this.posicion<DISTANCIA){
                Thread.sleep(1000);
                entrarTunel();
                if(hayCharco()){
                    this.posicion+=5; // le sumo 5 a la posicion para que durante ese segundo la velocidad sea 5, aunque sea de forma artificial ya que lo que hago es adelantar su posicion
                    System.out.println(this.nombre+" ha pisado un charco y ahora va más rápido (+5m)");
                } else {
                    posicion+=velocidad;
                }
                salirTunel();
                mostrarPosicion();
            }
            System.out.println(this.nombre+" ha llegado a la meta!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
