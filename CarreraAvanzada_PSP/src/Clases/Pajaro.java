package Clases;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pajaro extends Animal {

	private boolean volando;
    private Random random;
    
    public Pajaro(Semaphore tunel,Clima clima){
        super(3,"Pájaro",tunel,clima);
        this.volando=false;
        this.random=new Random();
    }
    
    @Override
    public void run(){
        try{
            while(posicion<DISTANCIA){
                Thread.sleep(1000);
                entrarTunel();
                // vuela o no (30% de probabilidad)
                volando=random.nextDouble()<0.3;
                if(volando){
                	int probabilidad=random.nextInt(100);
                    boolean adelante=probabilidad<70;
                    double velocidadVuelo;
                    if(adelante){
                        velocidadVuelo=10;
                    }else{
                        velocidadVuelo=-10;
                    }
                    if(clima.hayViento() && !dentroTunel()){
                        boolean vientoFavor=random.nextBoolean();//genera true o false de forma aleatoria
                        String situacion;
                        if(vientoFavor){
                            velocidadVuelo+=5;
                            situacion="a favor";
                        }else{
                            velocidadVuelo-=5;
                            situacion="en contra";
                        }
                        String str="El viento afecta a "+this.nombre;
                        if(vientoFavor){
                        	str+=" "+situacion;
                        }
                        System.out.println(str);
                    }
                    this.posicion+=velocidadVuelo;
                    String direccion;
                    if(adelante){
                        direccion="adelante";
                    }else{
                        direccion="atras";
                    }
                    String mensaje = this.nombre+" está volando "+direccion+" ("+velocidadVuelo+"m/s)";
                    System.out.println(mensaje);
                    // no puede ir por debajo de 0
                    if(this.posicion<0){
                    	this.posicion=0;
                    }
                }else{
                	// va corriendo
                    posicion+=velocidad;
                    if(hayCharco()){
                        System.out.println(this.nombre+" se resbala en un charco (-5s)");
                        Thread.sleep(5000);
                    }
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