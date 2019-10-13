package Enum;

public enum SentidoEnum {
	HORARIO (-1),
	ANTIHORARIO(1);
	
	private int sentido;
	
	private SentidoEnum(int valor) {
		this.sentido = valor;
	}
	
	public int getSentido() {
		return this.sentido;
	}
}
