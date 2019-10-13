package domain;

import java.awt.geom.Point2D;

public class Clima {

	private String nombreClima;
	private int dia;
	
	public SistemaSolar sistSolar;
	
/*	public InfoClima getInfoClima(Point2D p1, Point2D p2, Point2D p3, Point2D sol) {
		
		InfoClima info = new InfoClima();
		return info;
	}
	
	*/
	
	public boolean estanAlineados(Point2D posP1, Point2D posP2, Point2D posP3,int dia) {
		double elevacion = posP2.getX() - posP1.getX();
		double avance = posP2.getY() - posP1.getY();
		
		double pendiente = elevacion/avance;
		
		double independiente = posP1.getY() - (pendiente * posP1.getX()); //cambiar this.ind
		
		//ec pendiente queda: Y = pendiente*x + independiente		
		double pendiente3 = posP3.getX() - posP2.getX() /  posP3.getY() - posP2.getY();
		
		return (pendiente == pendiente3);
	}
}
