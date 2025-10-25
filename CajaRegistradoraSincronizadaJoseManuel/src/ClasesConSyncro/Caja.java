package ClasesConSyncro;

public class Caja {
	
	private double total;

	public Caja() {
		this.total=0;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	public synchronized void cobrar(double cantidad) {
		this.total+=cantidad;
		
	}
}
