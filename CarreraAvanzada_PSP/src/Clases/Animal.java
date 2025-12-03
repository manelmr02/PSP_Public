package Clases;

import java.util.concurrent.Semaphore;

public class Animal extends Thread{
	
	public int velocidad;
	public int posicion;
	public String nombre;
	public boolean enTunel;

    protected Semaphore tunel;
    protected Clima clima;

    protected final int DISTANCIA=500;
    protected final int ENTRADA_TUNEL=50;
    protected final int SALIDA_TUNEL=150;
    
    public Animal(int velocidad,String nombre){
		this.velocidad=velocidad;
        this.posicion=0;
        this.nombre=nombre;
	}

	public Animal(int velocidad,String nombre,Semaphore tunel,Clima clima){
		this.velocidad=velocidad;
        this.posicion=0;
        this.nombre=nombre;
        this.enTunel=false;
        this.tunel=tunel;
        this.clima=clima;
	}

	public int getVelocidad(){
		return velocidad;
	}

	public void setVelocidad(int velocidad){
		this.velocidad=velocidad;
	}

	public int getPosicion(){
		return posicion;
	}

	public void setPosicion(int posicion){
		this.posicion=posicion;
	}
	
	public boolean hayCharco(){
		if(this.posicion%10==0 && this.posicion>0 && this.posicion<DISTANCIA && !dentroTunel()) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean dentroTunel() {
		if(this.posicion>=ENTRADA_TUNEL && this.posicion<SALIDA_TUNEL) {
			return true;
		}else {
			return false;
		}
	}
	
	public void entrarTunel(){
		if(this.posicion>=ENTRADA_TUNEL && !enTunel && this.posicion<SALIDA_TUNEL) {
			System.out.println(this.nombre+" esta esperando para entrar al tunel.");
			try{
				this.tunel.acquire();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			enTunel=true;
			System.out.println(this.nombre+" ha entrado al tunel.");
		}
	}
	
	public void salirTunel(){
        if(enTunel && posicion>=SALIDA_TUNEL) {
        	tunel.release();
            enTunel = false;
            System.out.println(this.nombre + " ha salido del tunel.");
        }
    }
	
	public void mostrarPosicion(){
		String str=this.nombre+" se encuentra en "+this.posicion+"m";
		if(this.enTunel==true) {
			str+=" (dentro del tunel)";
		}
		System.out.println(str);
	}
}
