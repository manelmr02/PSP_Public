package Clases;

import java.util.concurrent.Semaphore;

public class Liebre extends Animal {
	
	private int segundosDespierta;
    private boolean durmiendo;
    
    public Liebre(Semaphore tunel,Clima clima){
        super(5,"Liebre",tunel,clima);
        this.segundosDespierta=0;
        this.durmiendo=false;
    }

    @Override
    public void run(){
        try {
            while(posicion < DISTANCIA){
                Thread.sleep(1000);
                this.entrarTunel();
                // si está durmiendo
                if(durmiendo){
                    this.segundosDespierta++;
                    // compeueba si hay viento y no este dentro del tunel
                    if(clima.hayViento() && !dentroTunel()){
                        this.durmiendo=false;
                        this.segundosDespierta=0;
                        System.out.println("El viento ha despertado a "+this.nombre);
                    } else if (segundosDespierta>=10) {
                        this.durmiendo=false;
                        this.segundosDespierta=0;
                        System.out.println(this.nombre+" se ha despertado.");
                    } else {
                        this.salirTunel();
                        continue;//para ejecutar directamente otro ciclo del while sin hacer el resto  del metodo
                    }
                }
                posicion+=velocidad;
                if(hayCharco()){
                    System.out.println(this.nombre+" se resbala en un charco. (-5s)");
                    Thread.sleep(5000);
                }
                this.segundosDespierta++;
                if(segundosDespierta>=4 && !dentroTunel()){
                    durmiendo=true;
                    segundosDespierta=0;
                    System.out.println(this.nombre+" se duerme.");
                }
                this.salirTunel();
                this.mostrarPosicion();
            }
            System.out.println(this.nombre+" ha llegado a la meta!");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
