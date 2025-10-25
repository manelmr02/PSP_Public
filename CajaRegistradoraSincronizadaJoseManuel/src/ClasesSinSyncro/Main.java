package ClasesSinSyncro;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Caja caja=new Caja();
		Empleado empleado1=new Empleado(caja,"Manel");
		Empleado empleado2=new Empleado(caja,"Mario");
		Empleado empleado3=new Empleado(caja,"Pedro");
		Thread hilo1=new Thread(empleado1);
		Thread hilo2=new Thread(empleado2);
		Thread hilo3=new Thread(empleado3);
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo1.join();
		hilo2.join();
		hilo3.join();
		System.out.printf("TOTAL FINAL EN CAJA: %.2f €",caja.getTotal());
		
	}

}
