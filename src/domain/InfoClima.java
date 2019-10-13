package domain;

import java.awt.geom.Point2D;

public class InfoClima {

	private String clima;
	private int dia;
	
	public InfoClima() {
		
	} 
	
	public InfoClima(String tipo, int dia) {
		this.clima = tipo;
		this.dia = dia;
	}
	
	public void setTipoClima(String tipo) {
		this.clima = tipo;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public String getClima() {
		return this.clima;
	}
	
	public int getDia() {
		return this.dia;
	}
	
	
	
}
