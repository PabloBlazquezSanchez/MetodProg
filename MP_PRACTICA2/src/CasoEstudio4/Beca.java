package CasoEstudio4;

public class Beca {
	private int fInicio;

	private int fFin;
	private int dinero;
	private int id;

	public Beca(int fInicio, int fFin, int dinero, int id) {
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.dinero = dinero;
		this.id = id;
	}

	public int getfInicio() {
		return fInicio;
	}

	public void setfInicio(int fInicio) {
		this.fInicio = fInicio;
	}

	public int getfFin() {
		return fFin;
	}

	public void setfFin(int fFin) {
		this.fFin = fFin;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
