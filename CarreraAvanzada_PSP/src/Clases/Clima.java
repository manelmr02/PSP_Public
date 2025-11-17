package Clases;

import java.util.Random;

public class Clima extends Thread{
	
	public boolean viento;
	public boolean carreraEnMarcha;
	private Random random;

	public Clima(){
		 this.viento=false;
	     this.random=new Random();
	     this.carreraEnMarcha=true;
	}
	
	public boolean hayViento(){
        return this.viento;
    }
	
	public void detenerClima(){
        this.carreraEnMarcha=false;
    }
	
	 @Override
	    public void run(){
	        try{
	            while(carreraEnMarcha){
	                Thread.sleep(random.nextInt(5000) + 8000); // el tiempo entre que el clima puede cambiar es entre 8 y 13 segundos
	                viento = !viento;
	                if(viento){
	                    System.out.println("Ha comenzado a soplar viento!");
	                }else{
	                    System.out.println("El viento se ha detenido.");
	                }
	            }
	        }catch(InterruptedException e){
	            System.out.println("Clima detenido por error.");
	        }
	    }

}
