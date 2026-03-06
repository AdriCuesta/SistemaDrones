package drones;

public abstract class DronBase {

	private String identificador;
	private int autonomiaMaxima;
	private int velocidadMaxima;
	private boolean estaOperativo;

	public DronBase(String identificador, int autonomiaMaxima, int velocidadMaxima, boolean estaOperativo) {
		this.identificador = identificador;
		this.autonomiaMaxima = autonomiaMaxima;
		this.velocidadMaxima = velocidadMaxima;
		this.estaOperativo = estaOperativo;
	}
	
	public boolean comprobarOperatividad() {
		if(estaOperativo) {
			return true;
		}else {
			throw new IllegalStateException("El dron no se encuentra operativo");
		}
		
	}
	
	public abstract double calcularTiempoRespuesta(int distanciaMision);

	public String getIdentificador() {
		return identificador;
	}

	public int getAutonomiaMaxima() {
		return autonomiaMaxima;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public boolean isEstaOperativo() {
		return estaOperativo;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public void setAutonomiaMaxima(int autonomiaMaxima) {
		this.autonomiaMaxima = autonomiaMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public void setEstaOperativo(boolean estaOperativo) {
		this.estaOperativo = estaOperativo;
	}
	
	

}
