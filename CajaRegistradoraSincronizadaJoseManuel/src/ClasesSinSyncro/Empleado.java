package ClasesSinSyncro;

public class Empleado implements Runnable{
	
	private Caja cajaCompartida;
	private String nombre;
	

	public Empleado(Caja cajaCompartida,String nombre) {
		// TODO Auto-generated constructor stub
		this.cajaCompartida=cajaCompartida;
		this.nombre=nombre;
	}


	@Override
	public void run() {
		//double totalCobrado=0;
		
		for(int i=0;i<5;i++) {
			double importe=5+Math.random()*95;//para que el minimo sea 5 le sumamos 5 a un random que nos genera el numero hasta 95
			cajaCompartida.cobrar(importe);
			//totalCobrado+=importe;
			System.out.printf("Empleado %s cobró %.2f €. Total en caja: %.2f €%n", this.nombre,importe,this.cajaCompartida.getTotal());
		}
		
		
	}

}
