package domain;

import java.awt.geom.Point2D;

public class Sequia extends Clima{

	public Sequia() {
		super();
	}
	public boolean haySequia(Point2D posP1, Point2D posP2, Point2D posP3, Point2D sol, int dia) {
		return estanAlineadosConElSol(posP1, posP2, posP3, sol, dia);
	}
	
	public boolean estanAlineadosConElSol(Point2D posP1, Point2D posP2,Point2D posP3, Point2D sol,int dia) { 
		double solX = sol.getX();
		double solY = sol.getY();


		boolean resultado = (((posP1.getX() == posP2.getX()) && (posP1.getX() == posP3.getX()) && (posP3.getX() == solX)) ||
							((posP1.getY() == posP2.getY()) && (posP1.getY() == posP3.getY()) && (posP3.getY() == solY))) &&
							this.estanAlineados(posP1, posP2, posP3, dia);
		return resultado;
	}
}
