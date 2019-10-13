package Enum;

public enum ClimaEnum {
	SEQUIA ("sequia"), 
	LLUVIA ("Llueve"), 
	OPTIMO ("Optimo");
	
	private String tipo;
	
	private ClimaEnum(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
}
