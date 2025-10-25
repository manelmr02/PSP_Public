package ClasesSinSyncro;

public class Caja {
	
	private double total;

	public Caja() {
		this.total=0;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	public void cobrar(double cantidad) {
		this.total+=cantidad;
		
	}
}
