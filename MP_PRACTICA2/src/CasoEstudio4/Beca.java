package CasoEstudio4;

/**
 * Clase Beca
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
	 * Instantiates a new beca.
	 * 
	 * Este m�todo sirve para crear un objeto de tipo Beca que contenga un id, una
	 * fecha de inicio, una fecha de finalizaci�n y el dinero que porporciona.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @param id      el id
	 * @param fInicio la fecha de inicio
	 * @param fFin    la fecha de finalizaci�n
	 * @param dinero  el dinero retribuido
	 */
	public Beca(int id, int fInicio, int fFin, int dinero) {
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.dinero = dinero;
		this.id = id;
	}

	/**
	 * Este m�todo devuelve el valor almacenado en la variable fInicio, almacenado a
	 * su vez en el objeto Beca.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @return the f inicio
	 */
	public int getfInicio() {
		return fInicio;
	}

	/**
	 * Modifica el valor de la variable fInicio guardada en el objeto de tipo Beca.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @param fInicio the new f inicio
	 */
	public void setfInicio(int fInicio) {
		this.fInicio = fInicio;
	}

	/**
	 * Este m�todo devuelve el valor almacenado en la variable fFin, almacenado a su
	 * vez en el objeto Beca.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @return the f fin
	 */
	public int getfFin() {
		return fFin;
	}

	/**
	 * Modifica el valor de la variable fFin guardada en el objeto de tipo Beca.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @param fFin the new f fin
	 */
	public void setfFin(int fFin) {
		this.fFin = fFin;
	}

	/**
	 * Este m�todo devuelve el valor almacenado en la variable dinero, almacenado a
	 * su vez en el objeto Beca.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @return the dinero
	 */
	public int getDinero() {
		return dinero;
	}

	/**
	 * Modifica el valor de la variable dinero guardada en el objeto de tipo Beca.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @param dinero the new dinero
	 */
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	/**
	 * Este m�todo devuelve el valor almacenado en la variable id, almacenado a su
	 * vez en el objeto Beca.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica el valor de la variable id guardada en el objeto de tipo Beca.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
