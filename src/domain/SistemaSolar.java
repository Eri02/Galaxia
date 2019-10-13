package domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

public class SistemaSolar {

		/*Planeta ferengi =  new Planeta("Ferengi", 1,500,-1);
		Planeta betasoide = new Planeta("Betasoide", 3,2000, -1);
		Planeta vulcano = new Planeta("Vulcano", 5,1000, 1);*/ 
	Planeta planeta1 =  new Planeta();
	Planeta planeta2 =  new Planeta();
	Planeta planeta3 =  new Planeta();
	
	public Clima clima = new Clima();
		
	static final Point2D POS_SOL = new Double(0, 0); 
	
	public InfoClima getInfoClimaPorDia(int dia) {
		Point2D posP1 = planeta1.posicionPorDia(dia);
		Point2D posP2 = planeta2.posicionPorDia(dia);
		Point2D posP3 = planeta3.posicionPorDia(dia);
		return clima.getInfoClima(posP1, posP2, posP3, POS_SOL) ;
	}
	
	public void getPeriodosOptimos(int dia) {
		//clima.esClimaOptimo(planeta1, planeta2, planeta3, dia);
	}
	
	public void getPeriodosLluviosos(int dia) {
		//clima.hayLluvia(planeta1, planeta2, planeta3, POS_SOL, dia);
	}
	
	public void getPeriodosDeSequia(int dia) {
		//clima.haySequia(planeta1, planeta2, planeta3, POS_SOL, dia);
	}
	
	public void picoMaximoDeLluvia() {
		
	}
	
	public void getPeriodosNoLluviosos(int dia) {
		
	}
	

	public double perimetro(double a, double b, double c) {
		return a + b + c;
	}
	

	//a, b , c distancia entre los puntos (posici�n) de C/planeta
	public double distanciaEntreDosPuntos(Point2D p1, Point2D p2) {
		//d= raiz[(x2-x1)2+(y2-y1)2]
		double x = Math.abs(p2.getX() - p1.getX());
		double y = Math.abs(p2.getY() - p1.getY());
		double d = Math.sqrt((Math.pow(x, 2) + (Math.pow(y, 2))));		
		return d;
	}

	

}
