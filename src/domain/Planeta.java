package domain;
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
	private int velocidadAngular; //positiva o negativa, dependiendo del sentido que tenga
	private double radio;
	private long angulo;
	private Point2D posicionPlaneta = new Double(0, 0);
	private int sentido;
	
	//constructor planeta
	public Planeta(String nombre, int velocidad, double radio, int sentido) {
	this.nombrePlaneta = nombre;
	this.velocidadAngular = velocidad;
	this.radio = radio;
	//this.posicionPlaneta = new Double(radio, 0.0); // la posici�n inicial del planeta?
	this.sentido = sentido;
	}
	
	public Planeta() {
		// TODO Auto-generated constructor stub
	}

	//calculo angulo
	public long calculoAngulosPorDia(int dia) {
		long angulo = (this.velocidadAngular*this.sentido * dia); /// 360; //(1 vuelta = 360 grados )
		//como velocidad anguluar puede ser negativa
		if((angulo) < 0) {
			this.angulo = 360 + angulo;
		}
		this.angulo = angulo;
		//System.out.println("Angulo por día: " + this.angulo);
		return this.angulo;
	}
		
	public double calculoAnguloRadian(long angulo) {
		double anguloRadian = Math.toRadians(angulo);
		//System.out.println(" Angulo en radianes(round) día: " + Math.round(anguloRadian));
		return anguloRadian;
		
	}
		
	public Point2D posicionPorDia(int dias) {
		long angulo = this.calculoAngulosPorDia(dias);
		double radianes = this.calculoAnguloRadian(angulo);
		double posX = this.radio *  Math.cos(radianes);
		double posY = this.radio *  Math.sin(radianes);
		//System.out.println("Pos X: " + Math.round(posX));
		//System.out.println("Pos Y: " + Math.round(posY));
		this.posicionPlaneta.setLocation(Math.round(posX), Math.round(posY));
		//System.out.println("Posición planeta: " + this.posicionPlaneta);
		 return this.posicionPlaneta;
	}
		
	//Getters
	public String getNombrePlaneta(){
		return this.nombrePlaneta;
	}
	
	public int getVelocidadAngular() {
		return this.velocidadAngular;
	}
		
	public int getSentido() {
		return this.sentido;
	}
	
	//setter	

	public void setNombre(String nombre) {
		this.nombrePlaneta = nombre;
	}
	
	public void setVelocidadPlaneta(int velocidad) {
		this.velocidadAngular = velocidad;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	

	
}

