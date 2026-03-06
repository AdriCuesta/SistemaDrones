package drones;

public class DronMontaña extends DronBase {

	private int altitud;

	public DronMontaña(String identificador, int autonomiaMaxima, int velocidadMaxima, boolean estaOperativo,
			int altitud) {
		super(identificador, autonomiaMaxima, velocidadMaxima, estaOperativo);

		if (altitud < 0) {
			throw new IllegalArgumentException("La altitud no puede ser negativa");
		}

		this.altitud = altitud;

	}

	@Override
	public double calcularTiempoRespuesta(int distanciaMision) {

		if (distanciaMision < 0) {
			throw new IllegalArgumentException("La distancia de la mision no puede ser negativa");
		}
		super.comprobarOperatividad();
		double tiempoRespuesta = (distanciaMision / super.getVelocidadMaxima() * altitud);

		if (tiempoRespuesta > super.getAutonomiaMaxima()) {
			throw new IllegalArgumentException("El tiempo de respuesta supera la autonomia del dron");
		}

		return tiempoRespuesta;

	}

}
