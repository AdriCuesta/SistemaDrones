package drones;

/**
 * Clase base abstracta que tiene la informacion esencial de los drones
 * 
 * @author AdrianCuesta
 * @version 1.0
 */
public abstract class DronBase {

	/**
	 * Identificador del dron
	 */
	private String identificador;
	/**
	 * Autonomía maxima que permite la bateria del dron
	 */
	private int autonomiaMaxima;
	/**
	 * Velocidad máxima que puede alcanzar el dron
	 */
	private int velocidadMaxima;
	/**
	 * Indica la operativilidad del dron
	 */
	private boolean estaOperativo;

	/**
	 * Constructor de dronBase de 5 parametros
	 * 
	 * @param identificador
	 * @param autonomiaMaxima
	 * @param velocidadMaxima
	 * @param estaOperativo
	 */
	public DronBase(String identificador, int autonomiaMaxima, int velocidadMaxima, boolean estaOperativo) {
		this.identificador = identificador;
		this.autonomiaMaxima = autonomiaMaxima;
		this.velocidadMaxima = velocidadMaxima;
		this.estaOperativo = estaOperativo;
	}

	/**
	 * Método que comprueba si el dron esta operativo
	 * 
	 * @return true si el dron está operativo
	 * @throws IllegalStateException Si el dron no lo está
	 */
	public boolean comprobarOperatividad() {
		if (estaOperativo) {
			return true;
		} else {
			throw new IllegalStateException("El dron no se encuentra operativo");
		}

	}

	/**
	 * Calcula el tiempo que tardará en recorrer la distancia de mision
	 * 
	 * @param distanciaMision
	 * @return la estimacion del tiempo
	 */
	public abstract double calcularTiempoRespuesta(int distanciaMision);

	/**
	 * Devuelve el identificador del dron
	 * 
	 * @return El identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * Devuelve la autonomía máxima del dron
	 * 
	 * @return La autonomía máxima
	 */
	public int getAutonomiaMaxima() {
		return autonomiaMaxima;
	}

	/**
	 * Devuelve la velocidad máxima que alcanza el dron
	 * 
	 * @return La velocidad máxima del dron
	 */
	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	/**
	 * Devuelve si el dron se encuentra o no operativo
	 * 
	 * @return
	 *         <ul>
	 *         <li>True: si se encuentra operativo</li>
	 *         <li>False: si no se encuentra operativo</li>
	 *         </ul>
	 */
	public boolean isEstaOperativo() {
		return estaOperativo;
	}

	/**
	 * Introduce un nuevo identificador al drom
	 * 
	 * @param identificador Nuevo identificador
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * Introduce una nueva autonomía máxima
	 * 
	 * @param autonomiaMaxima Nueva autonomía
	 */
	public void setAutonomiaMaxima(int autonomiaMaxima) {
		this.autonomiaMaxima = autonomiaMaxima;
	}

	/**
	 * Introduce una velocidad máxima
	 * 
	 * @param velocidadMaxima Nueva velocidad máxima
	 */
	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	/**
	 * Introduce un nuevo estado operativo al dron
	 * <ul>
	 * <li>True: Para indicar que está operativo</li>
	 * <li>False: Para indicar que está fuera de servicio</li>
	 * </ul>
	 * 
	 * @param estaOperativo El estado operativo
	 */
	public void setEstaOperativo(boolean estaOperativo) {
		this.estaOperativo = estaOperativo;
	}

}
