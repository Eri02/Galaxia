package domain;

import java.awt.geom.Point2D;

public class Lluvia extends Clima{

	public Lluvia() {
		super();
	}
	
	public boolean hayLluvia(Point2D  p1, Point2D p2, Point2D p3, Point2D sol) {
		if(formanUnTriangulo(p1, p2, p3)) {
			return solPerteneceAlTriangulo(p1, p2, p3, sol);
		}
		return false;
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
		double s = (this.perimetro(a, b, c))/2; 
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return area;
	}

	public boolean formanUnTriangulo(Point2D p1, Point2D p2, Point2D p3){
		return ((p1 != p2) && (p2 != p3) && (p1 != p3)); 
	}
	
	

	
	
}
