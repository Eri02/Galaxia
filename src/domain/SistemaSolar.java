package domain;

import java.awt.geom.Point2D;

public class SistemaSolar {
	
	double pendiente;
	double independiente;
	
	double x;
	double y;
	
	public void getClimaPorDia() {
		
	}
	
	public void getPeriodosLluviosos() {
		
	}
	
	public void getPeriodosNoLluviosos() {
		
	}
	
	public void getPeriodosDeSequia() {
		
	}
	
	
	public double perimetro(Point2D p1, Point2D p2, Point2D p3) {
		double a = this.distanciaEntreDosPuntos(p1, p2);
		double b = this.distanciaEntreDosPuntos(p2, p3);
		double c = this.distanciaEntreDosPuntos(p3, p1);
		return a + b + c;
	}
	
	//a, b , c distancia entre los puntos (posici�n) de C/planeta
	private double distanciaEntreDosPuntos(Point2D p1, Point2D p2) {
		//d= raiz[(x2-x1)2+(y2-y1)2]
		double x = p2.getX() - p1.getX();
		double y = p2.getY() - p1.getY();
		double d = Math.sqrt((Math.pow(x, 2) + (Math.pow(y, 2))));		
		return d;
	}

	public boolean haySequia() {
		
		return true;
	}
	
	public boolean esClimaOptimo() {
		return true;
	}
	
	double[] puntoX = {x, y};

	
	public boolean estanAlineados(Planeta p1, Planeta p2, Planeta p3,int dias) {	
		double elevacion = p2.getPosX() - p1.getPosX();
		double avance = p2.getPosY() - p2.getPosY();
		
		double pendiente = elevacion/avance;
		
		this.independiente = p1.getPosY() - (pendiente * p1.getPosX()); //cambiar this.ind
		
		//ec pendiente queda: Y = pendiente*x + independiente		
		double pendiente3 = p3.getPosX() - p2.getPosX() /  p3.getPosY() - p2.getPosY();
		
		return (pendiente == pendiente3);
	}
	
	public boolean estanAlineadosConElSol(Planeta p1, Planeta p2, Planeta p3,int dias) { //envia pos del sol
		Point2D sol = new Point2D.Double(0,0);
		double[] solPos = {0,0};
		double solX = solPos[0];
		double solY = solPos[1];
		return this.estanAlineados(p1,p2,p3, dias) && this.independiente == 0;
	}
}
