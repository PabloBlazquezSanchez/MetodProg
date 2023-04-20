package CasoEstudio4;

/**
 * The Class Beca.
 */
public class Beca {
	
	/** The inicio. */
	private int fInicio;

	/** The fin. */
	private int fFin;
	
	/** The dinero. */
	private int dinero;
	
	/** The id. */
	private int id;

	/**
	 * Instantiates a new beca.
	 *
	 * @param id the id
	 * @param fInicio the f inicio
	 * @param fFin the f fin
	 * @param dinero the dinero
	 */
	public Beca(int id, int fInicio, int fFin, int dinero) {
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.dinero = dinero;
		this.id = id;
	}

	/**
	 * Gets the f inicio.
	 *
	 * @return the f inicio
	 */
	public int getfInicio() {
		return fInicio;
	}

	/**
	 * Sets the f inicio.
	 *
	 * @param fInicio the new f inicio
	 */
	public void setfInicio(int fInicio) {
		this.fInicio = fInicio;
	}

	/**
	 * Gets the f fin.
	 *
	 * @return the f fin
	 */
	public int getfFin() {
		return fFin;
	}

	/**
	 * Sets the f fin.
	 *
	 * @param fFin the new f fin
	 */
	public void setfFin(int fFin) {
		this.fFin = fFin;
	}

	/**
	 * Gets the dinero.
	 *
	 * @return the dinero
	 */
	public int getDinero() {
		return dinero;
	}

	/**
	 * Sets the dinero.
	 *
	 * @param dinero the new dinero
	 */
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
