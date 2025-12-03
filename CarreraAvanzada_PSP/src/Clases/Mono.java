package Clases;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Mono extends Animal{
	
	public boolean enLiana;
	public ArrayList<Semaphore> lianas;
	public Semaphore lianaActual;
	
	public Mono(int velocidad,String nombre,ArrayList<Semaphore> lianas) {
		super(velocidad,nombre);
		this.lianas=lianas;
		this.enLiana=false;
		this.lianaActual=null;
	}
	
	public boolean getEnLiana() {
		return this.enLiana;
	}
	

	
	public void entrarLiana(){
		System.out.println(this.nombre+" esta esperando para entrar a una liana");
		switch(this.posicion) {
			case 0: 
				try {
					System.out.println(this.nombre+" esta entrando a la liana1");
					lianas.get(0).acquire();
					this.enLiana=true;
					this.lianaActual=lianas.get(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
		 	case 100:
		 		try {
		 			System.out.println(this.nombre+" esta entrando a la liana2");
					lianas.get(1).acquire();
					this.enLiana=true;
					this.lianaActual=lianas.get(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		break;
		 	case 200:
		 		try {
		 			System.out.println(this.nombre+" esta entrando a la liana3");
					lianas.get(2).acquire();
					this.lianaActual=lianas.get(2);
					this.enLiana=true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		break;
		 	case 300:
		 		try {
		 			System.out.println(this.nombre+" esta entrando a la liana4");
					lianas.get(3).acquire();
					this.enLiana=true;
					this.lianaActual=lianas.get(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		break;
		 	case 400:
		 		try {
		 			System.out.println(this.nombre+" esta entrando a la liana5");
					lianas.get(4).acquire();
					this.enLiana=true;
					this.lianaActual=lianas.get(4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		break;
		 	default:
		 		
		}
	}
	
	/*public void entrarLiana(){
		if(this.posicion%100==0 && this.enLiana==false && this.posicion<500) {
			this.enLiana=false;
			for(int i=0;i<5;i++) {
				if(lianas.get(i).equals(lianaActual)) {
					lianas.get(i).acquire();
					System.out.println(this.nombre+" ha salido de la liana.");
				}
		}
		 		
			
		}
	}*/
	
	public void salirLiana(){
		if(this.posicion%100!=0 && this.enLiana==true && this.posicion<500) {
			this.enLiana=false;
			for(int i=0;i<5;i++) {
				if(lianas.get(i).equals(lianaActual)) {
					lianas.get(i).release();
					System.out.println(this.nombre+" ha salido de la liana.");
				}
			}
		 		
			
		}
	}
	
	
	@Override
	public void run() {
		while(posicion<DISTANCIA) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.entrarLiana();
			this.posicion+=velocidad;
			this.salirLiana();
	        this.mostrarPosicion();
		}
	}
	

	
	
}
