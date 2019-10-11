package Enum;

public enum SentidoEnum {
	HORARIO (-1),
	ANTIHORARIO(1);
	
	private int sentido;

	SentidoEnum(int valor) {
		this.sentido = valor;
	}
	
	int getSentido() {
		return this.sentido;
	}
}
