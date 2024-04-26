package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611,53219),SALTA(1441351,155488),TUCUMAN(1448188,22525),CATAMARCA(429562,102602),
	LA_RIOJA(324226,89680),SANTIAGO_DEL_ESTERO(1060906,136351);
	
	private int cantidadPoblacion;
	private int superficie;
	
	private Provincia(int cantidadPoblacion, int superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public int densidadPoblacional()
	{
		return cantidadPoblacion/superficie;
	}
}
