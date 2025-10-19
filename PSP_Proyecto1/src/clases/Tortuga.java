package clases;

public class Tortuga extends Animal{

	public Tortuga(String nombre, int velocidad) {
		
		super(nombre, velocidad);
	}
	
	@Override
	public void run() {
		while(true) {
			correr();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
