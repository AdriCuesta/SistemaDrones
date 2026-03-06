package drones;

public class DronMaritimo extends DronBase {

	private int resistenciaSalinidad;

	public DronMaritimo(String identificador, int autonomiaMaxima, int velocidadMaxima, boolean estaOperativo,
			int resistenciaSalinidad) {
		super(identificador, autonomiaMaxima, velocidadMaxima, estaOperativo);

		if (resistenciaSalinidad < 0) {
			throw new IllegalArgumentException("La resistencia a la salinidad no puede ser negativa");
		} else if (resistenciaSalinidad > 100) {
			throw new IllegalArgumentException("La resistencia a la salinidad no puede ser superior a 100");
		}

		this.resistenciaSalinidad = resistenciaSalinidad;

	}

	@Override
	public double calcularTiempoRespuesta(int distanciaMision) {

		if (distanciaMision < 0) {
			throw new IllegalArgumentException("La distancia de la mision no puede ser negativa");
		}
		super.comprobarOperatividad();
		double tiempoRespuesta = (distanciaMision / super.getVelocidadMaxima());

		if (resistenciaSalinidad < 30) {
			tiempoRespuesta = tiempoRespuesta * 1.2;
		}

		if (tiempoRespuesta > super.getAutonomiaMaxima()) {
			throw new IllegalArgumentException("El tiempo de respuesta supera la autonomia del dron");
		}

		return tiempoRespuesta;

	}

	public int getResistenciaSalinidad() {
		return resistenciaSalinidad;
	}

	public void setResistenciaSalinidad(int resistenciaSalinidad) {
		this.resistenciaSalinidad = resistenciaSalinidad;
	}
	
	

}