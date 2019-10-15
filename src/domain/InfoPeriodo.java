package domain;

public class InfoPeriodo {

	private String clima;
	private int periodo;
	
	public InfoPeriodo() {
		
	} 
	
	public InfoPeriodo(String tipo, int periodo) {
		this.clima = tipo;
		this.periodo = periodo;
	}
	
	public void setClima(String clima) {
		this.clima = clima;
	}
	
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public String getClima() {
		return this.clima;
	}
	
	public int getPeriodo() {
		return this.periodo;
	}
	
	@Override
	public String toString() {
		return "InfoPeriodo [clima=" + clima + ", periodo=" + periodo + "]";
	}
}
