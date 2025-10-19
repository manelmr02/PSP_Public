package clases;

public class Animal implements Runnable{
	
	//metodo mas importante para la clase de hilos cuando queremos que eso se ejecute lo de dentro en un hilo paralelo
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
				this.correr();
			try {
				Thread.sleep(1000);//1 SEGUNDO
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String nombre;
	public int distancia;
	public int velocidad;
	
	public Animal(String nombre, int velocidad) {
		this.nombre=nombre;
		this.distancia=0;
		this.velocidad=velocidad;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDistancia() {
		return distancia;
	}

	private void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getVelocidad() {
		return velocidad;
	}

	private void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "Animal [nombre=" + getNombre() + ", distancia=" + getDistancia() + ", velocidad=" + getVelocidad() + "]";
	}
	
	public void correr() {
		this.distancia+=this.velocidad;
		this.decirPosicion();
	}
	
	public void decirPosicion() {
		System.out.println(getNombre()+" ha recorrido "+getDistancia()+" metros.");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
