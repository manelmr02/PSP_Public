package clases;

public class Liebre extends Animal{

	public Liebre(String nombre, int velocidad) {
		
		super(nombre, velocidad);
	}
	
	@Override
	public void run() {
		while(true) {
			correr();
			try {
				Thread.sleep(8000);// para que descanse 8 turnos mas es decir 8 segundos mas que el resto
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 
	
	public void correr() {
		for(int i=0;i<4;i++) {
			super.correr();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
