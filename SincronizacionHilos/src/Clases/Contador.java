package Clases;

public class Contador {
	private int valor;

	public Contador() {
		// TODO Auto-generated constructor stub
		this.valor=0;
	}
	
	public synchronized void incrementar() {
		this.valor++;
	}
	
	public int getValor() {
		return this.valor;
	}

}
