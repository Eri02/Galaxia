package Enum;

public enum ClimaEnum {
	SEQUIA ("Sequia"), 
	LLUVIA ("Llueve"), 
	LLUVIAMAX ("Lluvia m�xima"),
	OPTIMO ("Optimo");
	
	
	private String tipo;
	
	private ClimaEnum(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
}
