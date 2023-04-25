package CasoEstudio4;

/**
 * Esta es la clase donde se implementa un objeto Beca
 */
public class Beca {

	/** Fecha de inicio de la beca */
	private int fInicio;

	/** Fecha de finalización de la beca */
	private int fFin;

	/** Dinero que proporciona la beca */
	private int dinero;

	/** Identificador de la beca */
	private int id;

	/**
	 * 
	 * Este método sirve para crear un objeto de tipo Beca que contenga un id, una
	 * fecha de inicio, una fecha de finalización y el dinero que porporciona.
	 * 
	 *
	 * @param id      el id
	 * @param fInicio la fecha de inicio
	 * @param fFin    la fecha de finalización
	 * @param dinero  el dinero retribuido
	 */
	public Beca(int id, int fInicio, int fFin, int dinero) {
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.dinero = dinero;
		this.id = id;
	}

	/**
	 * Este método devuelve el valor almacenado en la variable fInicio, almacenado a
	 * su vez en el objeto Beca.
	 * 
	 *
	 * @return la fecha de inicio
	 */
	public int getfInicio() {
		return fInicio;
	}

	/**
	 * Modifica el valor de la variable fInicio guardada en el objeto de tipo Beca.
	 * 
	 *
	 * @param fecha de inicio la nueva fecha de inicio
	 */
	public void setfInicio(int fInicio) {
		this.fInicio = fInicio;
	}

	/**
	 * Este método devuelve el valor almacenado en la variable fFin, almacenado a su
	 * vez en el objeto Beca.
	 * 
	 *
	 * @return la fecha de fin
	 */
	public int getfFin() {
		return fFin;
	}

	/**
	 * Modifica el valor de la variable fFin guardada en el objeto de tipo Beca.
	 * 
	 *
	 * @param fecha de fin la nueva fecha de fin
	 */
	public void setfFin(int fFin) {
		this.fFin = fFin;
	}

	/**
	 * Este método devuelve el valor almacenado en la variable dinero, almacenado a
	 * su vez en el objeto Beca.
	 * 
	 *
	 * @return el dinero
	 */
	public int getDinero() {
		return dinero;
	}

	/**
	 * Modifica el valor de la variable dinero guardada en el objeto de tipo Beca.
	 * 
	 *
	 * @param dinero el nuevo dinero
	 */
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	/**
	 * Este método devuelve el valor almacenado en la variable id, almacenado a su
	 * vez en el objeto Beca.
	 * 
	 *
	 * @return el id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica el valor de la variable id guardada en el objeto de tipo Beca.
	 * 
	 *
	 * @param id el nuevo id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
