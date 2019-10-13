package domain;

import java.awt.geom.Point2D;

public class InfoClima {

	private String tipoClima;
	private int dia;
	
	public InfoClima() {
		
	} 
	
	public InfoClima(String tipo, int dia) {
		this.tipoClima = tipo;
		this.dia = dia;
	}
	
	public void setTipoClima(String tipo) {
		this.tipoClima = tipo;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public String getTipoClima() {
		return this.tipoClima;
	}
	
	public int getDia() {
		return this.dia;
	}
	
	
	
}
