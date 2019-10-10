import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Planeta {
/*
 * public static void main(String args[]){
 * 
 * }
 * velocidad angular
 * radio al sol
 * para saber la posicion necesito radio, x e y
 * MCU
 * pos = xi + yj =Radio.cos(angulo)i + Radio.sin(angulo)j
 * 
 * Para saber si est�n alineados, tengo que ver si est�n en una pendiente
 * 
 * Ferengi:
 * velocidadAngular = 1 grado/dia en sentido horario(-)
 * radio = 500 Km
 * 
 * Betasoide:
 * velocidadAngular = 3 grados/dia en sentido horario (-)
 * radio = 2000 km
 * 
 * Vulcano:
 * velocidadAngular = 5grados/dia en sentido antihorario (+)
 * radio = 1000 km
 * 
 * anguloDegree = (velocidad * dias) / 360
 * */
	
	private String nombrePlaneta;
	private int velocidadAngular; //ser� positiva o negativa, dependiendo del sentido que tenga
	private double radio;
	private long angulo;
	private double anguloRadian;
	private Point2D posicionPlaneta;
	
	//constructor planeta
	public Planeta(String nombre, int velocidad, double radio, long angulo, double anguloRadian) {
	this.nombrePlaneta = nombre;
	this.velocidadAngular = velocidad;
	this.radio = radio;
	this.angulo = angulo;
	this.posicionPlaneta = new Double(radio, 0.0); // la posici�n inicial del planeta?
	}
	
	public Planeta() {
		// TODO Auto-generated constructor stub
	}

	//calculo angulo
	public void calculoAngulosPorDia(int dia) {
		this.angulo = (this.velocidadAngular * dia) % 360; //(1 vuelta = 360 grados )
		//como velocidad anguluar puede ser negativa
		if(this.velocidadAngular < 0) {
			this.angulo = 360 + this.angulo;
		}		
	}
		
	public void calculoAnguloRadian(long angulo) {
		this.anguloRadian = Math.toRadians(angulo);
	}
		
	public void calculoPosicionXeY() {
		double posX = this.radio *  Math.cos(this.anguloRadian);
		double posY = this.radio *  Math.sin(this.anguloRadian);
		this.posicionPlaneta = new Double(posX, posY);
	}
		
	//Getters
	public double getPosX() {
		 return this.posicionPlaneta.getX();
	}

	public double getPosY() {
		return this.posicionPlaneta.getY();
	}
	
	public String nombrePlaneta(){
		return this.nombrePlaneta;
	}
	
	public int velocidadAngular() {
		return this.velocidadAngular;
	}
	
	public long angulo() {
		return this.angulo;
	}
	
	public double getAnguloRadian() {
		return this.anguloRadian;
	}

	public Point2D getPosicionPlaneta() {
		return this.posicionPlaneta;
	}
	
}

