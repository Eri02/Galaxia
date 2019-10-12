package domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

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
	
	public boolean hayLluvia(Planeta p1, Planeta p2, Planeta p3,int dias){
		Point2D posP1 = p1.posicionPorDia(dias);
		Point2D posP2 = p2.posicionPorDia(dias);
		Point2D posP3 = p3.posicionPorDia(dias);
		
		return this.formanUnTriangulo(posP1, posP2, posP3);
	}

	public boolean formanUnTriangulo(Point2D p1, Point2D p2, Point2D p3){

		double a = this.distanciaEntreDosPuntos(p1, p2);
		double b = this.distanciaEntreDosPuntos(p2, p3);
		double c = this.distanciaEntreDosPuntos(p3, p1);

		return (a >=1 && b >= 1 && c >= 1) ;
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
		double x = p2.getX() - p1.getX();
		double y = p2.getY() - p1.getY();
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
