package CasoEstudio4;

/**
 * Esta es la clase donde se implementa un objeto Beca
 */
public class Beca {

	/** Fecha de inicio de la beca */
	private int fInicio;

	/** Fecha de finalizaci�n de la beca */
	private int fFin;

	/** Dinero que proporciona la beca */
	private int dinero;

	/** Identificador de la beca */
	private int id;

	/**
	 * 
	 * Este m�todo sirve para crear un objeto de tipo Beca que contenga un id, una
	 * fecha de inicio, una fecha de finalizaci�n y el dinero que porporciona.
	 * 
	 * N�tese que al inicializar el objeto beca, establecemos como cuant�a final la
	 * obtenida en todos los meses en lugar de la cuant�a al mes. Le a�adimos una
	 * unidad a la diferencia del �ltimo mes menos el primero ya que es la duraci�n
	 * desde el primer d�a del primer mes hasta el �ltimo d�a del �ltimo.
	 *
	 * @param id      el id
	 * @param fInicio la fecha de inicio
	 * @param fFin    la fecha de finalizaci�n
	 * @param dinero  el dinero retribuido
	 */
	public Beca(int id, int fInicio, int fFin, int dinero) {
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.dinero = (fFin - fInicio + 1) * dinero;
		this.id = id;
	}

	/**
	 * Este m�todo devuelve el valor almacenado en la variable fInicio, almacenado a
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
	 * @param fInicio Fecha de inicio la nueva fecha de inicio
	 */
	public void setfInicio(int fInicio) {
		this.fInicio = fInicio;
	}

	/**
	 * Este m�todo devuelve el valor almacenado en la variable fFin, almacenado a su
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
	 * @param fFin Nueva fecha de fin de la beca
	 */
	public void setfFin(int fFin) {
		this.fFin = fFin;
	}

	/**
	 * Este m�todo devuelve el valor almacenado en la variable dinero, almacenado a
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
	 * Este m�todo devuelve el valor almacenado en la variable id, almacenado a su
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
