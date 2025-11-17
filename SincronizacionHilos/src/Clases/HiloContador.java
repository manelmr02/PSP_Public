package Clases;

public class HiloContador extends Thread{
	
	private Contador contador;

	public HiloContador(Contador contador) {
		// TODO Auto-generated constructor stub
		this.contador=contador;
	}
	
	public void run() {
		for(int i=0;i<1000;i++) {
			contador.incrementar();
		}
	}

}
