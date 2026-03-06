package drones;

/**
 * Clase dron maritimo Representa un Dron Maritimo, especializada a partir de la
 * clase {@link DronBase} Incluye informacion especifica sobre la resistencia a
 * la salinidad
 * 
 * @author AdrianCuesta
 * @version 1.0
 * @see DronBase
 */
public class DronMaritimo extends DronBase {

	// Atributos

	/**
	 * Resistencia a la salinidad del dron
	 */
	private int resistenciaSalinidad;

	/**
	 * Constructor 5 paramtros
	 * 
	 * @param identificador        Identificador del dron
	 * @param autonomiaMaxima      la autonomia maxima del dron
	 * @param velocidadMaxima      la velocidad maxima del dron
	 * @param estaOperativo        Indica si el dron esta o no operativo
	 * @param resistenciaSalinidad La resistencia que tiene el dron frente a la
	 *                             salinidad
	 * 
	 * @throws IllegalArgumentException si:
	 *                                  <ul>
	 *                                  <li>La resistencia a la salinidad es
	 *                                  negativa</li>
	 *                                  <li>La resistencia a la salinidad es mayor a
	 *                                  100</li>
	 *                                  </ul>
	 */
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

	/**
	 * Calcula el tiempo de respuesta de una mision
	 * 
	 * @param distanciaMision La distancia que tiene que recorrer el dron
	 * @return El tiempo que necesita para recorrer la distancia de mision
	 * @throws IllegalArgumentException si:
	 *                                  <ul>
	 *                                  <li>La distancia de la mision es
	 *                                  negativa</li>
	 *                                  <li>El tiempo de respuesta supera la
	 *                                  autonomia del dron</li>
	 *                                  </ul>
	 * @throws IllegalStateException    si el dron no se encuentra operativo
	 */
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

	/**
	 * Devuelve la resistencia a la salinidad del dron
	 * 
	 * @return Valor actual de la salinidad del dron
	 */
	public int getResistenciaSalinidad() {
		return resistenciaSalinidad;
	}

	/**
	 * Modifica la resistencia a la saliniadd
	 * 
	 * @param resistenciaSalinidad La nueva resistencia a la salinidad
	 */
	public void setResistenciaSalinidad(int resistenciaSalinidad) {
		this.resistenciaSalinidad = resistenciaSalinidad;
	}

}