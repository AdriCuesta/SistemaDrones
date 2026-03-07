package drones;

/**
 * Clase DronMontaña que representa a un dron de tipo montaña. La clase esta
 * especializada a partir de {@link DronBase} Incluye informacion específica
 * sobre la altitud
 * @author AdrianCuesta
 * @version 1.0
 * @see DronBase
 */
public class DronMontaña extends DronBase {
	/**
	 * El factor de altitud del dron
	 */
	private double altitud;

	/**
	 * Constructor con 5 parametros
	 * 
	 * @param identificador   Identificador del dron
	 * @param autonomiaMaxima La autonomía máxima del dron
	 * @param velocidadMaxima La velocidad máxima alcanzada por el dron
	 * @param estaOperativo   Indica si el dron se encuentra funcional o no
	 * @param altitud         Es el factor de altitud
	 * 
	 * @throws IllegalArgumentException Si el factor de altitud introducido es
	 *                                  negativo
	 */

	public DronMontaña(String identificador, int autonomiaMaxima, int velocidadMaxima, boolean estaOperativo,
			double altitud) {
		super(identificador, autonomiaMaxima, velocidadMaxima, estaOperativo);

		if (altitud < 0) {
			throw new IllegalArgumentException("La altitud no puede ser negativa");
		}

		this.altitud = altitud;

	}

	/**
	 * Método que calcula el tiempo de respuesta
	 * 
	 * @param distanciaMision La distancia que tiene que recorrer el dron
	 * @return El tiempo que tardaría en recorrer dicha distancia
	 * 
	 * @throws IllegalArgumentException si:
	 *                                  <ul>
	 *                                  <li>La distancia de la mision es
	 *                                  negativa</li>
	 *                                  <li>El tiempo de respuesta supera la
	 *                                  autonomia del dron</li>
	 *                                  </ul>
	 * @throws IllegalStateException    Si el dron no se encuentra operativo
	 */

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

	/**
	 * Devuelve el factor de altitud del dron
	 * 
	 * @return El factor de altitud
	 */
	public double getAltitud() {
		return altitud;
	}

	/**
	 * Inserta un nuevo factor de altitud al dron
	 * 
	 * @param altitud Nuevo factor de altitud
	 */
	public void setAltitud(int altitud) {
		this.altitud = altitud;
	}

}
