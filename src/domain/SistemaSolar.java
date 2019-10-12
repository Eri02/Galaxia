package domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class SistemaSolar {
	
	public void getClimaPorDia() {
		
	}
	
	public void getPeriodosLluviosos() {
		
	}
	
	public void getPeriodosNoLluviosos() {
		
	}
	
	public void getPeriodosDeSequia() {
		
	}
	
	public boolean hayLluvia(Planeta p1, Planeta p2, Planeta p3,int dias){
		//llueve si sus posiciones forman un triángulo, además, si el sol está contenido en él.
		Point2D posP1 = p1.posicionPorDia(dias);
		Point2D posP2 = p2.posicionPorDia(dias);
		Point2D posP3 = p3.posicionPorDia(dias);
		Point2D sol = new Double(0, 0); 
		if(this.formanUnTriangulo(posP1, posP2, posP3)) {
			this.solPerteneceAlTriangulo(posP1, posP2, posP3,sol);
		}
		return true;
		//return this.formanUnTriangulo(posP1, posP2, posP3);
	}

	public boolean solPerteneceAlTriangulo(Point2D p1, Point2D p2, Point2D p3, Point2D sol) {
		double l1 = this.distanciaEntreDosPuntos(p1, p2);
		double l2 = this.distanciaEntreDosPuntos(p2, p3);
		double l3 = this.distanciaEntreDosPuntos(p3, p1);
		
		double area = this.areaDeTriangulo(l1, l2, l3);
		
		double pb = this.distanciaEntreDosPuntos(sol, p2);
		double pc = this.distanciaEntreDosPuntos(sol, p3);
		double pa = this.distanciaEntreDosPuntos(sol, p1);
		
		double a = (pb * pc)/(2 * area);
		double b = (pc * pa)/(2 * area);
		double c = 1 - a - b;
		return (0 <= a && a <= 1) && (0 <= b && b <= 1) && (0 <= c && c <= 1);
	}
	
	//Fórmula de Herón
	public double areaDeTriangulo(double a, double b, double c) {
		double s = (a + b + c)/2;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return area;
	}

	public boolean formanUnTriangulo(Point2D p1, Point2D p2, Point2D p3){
		double a = this.distanciaEntreDosPuntos(p1, p2);
		double b = this.distanciaEntreDosPuntos(p2, p3);
		double c = this.distanciaEntreDosPuntos(p3, p1);

		return (a >=1 && b >= 1 && c >= 1); //revisar
	}

	public double perimetro(Point2D p1, Point2D p2, Point2D p3) {
		double a = this.distanciaEntreDosPuntos(p1, p2);
		double b = this.distanciaEntreDosPuntos(p2, p3);
		double c = this.distanciaEntreDosPuntos(p3, p1);
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

	public boolean haySequia(Planeta p1, Planeta p2, Planeta p3,int dias) {
		return this.estanAlineadosConElSol(p1, p2, p3, dias);
	}
	
	public boolean esClimaOptimo(Planeta p1, Planeta p2, Planeta p3,int dias) {
		return this.estanAlineados(p1, p2, p3, dias);
	}
	
	
	public boolean estanAlineados(Planeta p1, Planeta p2, Planeta p3,int dias) {
		Point2D posP1 = p1.posicionPorDia(dias);
		Point2D posP2 = p2.posicionPorDia(dias);
		Point2D posP3 = p3.posicionPorDia(dias);

		double elevacion = posP2.getX() - posP1.getX();
		double avance = posP2.getY() - posP1.getY();
		
		double pendiente = elevacion/avance;
		
		this.independiente = posP1.getY() - (pendiente * posP1.getX()); //cambiar this.ind
		
		//ec pendiente queda: Y = pendiente*x + independiente		
		double pendiente3 = posP3.getX() - posP2.getX() /  posP3.getY() - posP2.getY();
		
		return (pendiente == pendiente3);
	}
	
	public boolean estanAlineadosConElSol(Planeta p1, Planeta p2, Planeta p3,int dias) { //envia pos del sol
		Point2D sol = new Double(0, 0); 
		double solX = sol.getX();
		double solY = sol.getY();
		Point2D posP1 = p1.posicionPorDia(dias);
		Point2D posP2 = p2.posicionPorDia(dias);
		Point2D posP3 = p3.posicionPorDia(dias);

		boolean resultado = (((posP1.getX() == posP2.getX()) && (posP1.getX() == posP3.getX()) && (posP3.getX() == solX)) ||
							((posP1.getY() == posP2.getY()) && (posP1.getY() == posP3.getY()) && (posP3.getY() == solY))) &&
							this.estanAlineados(p1,p2,p3, dias);
		return resultado;
	}
}
