package domain;

import java.awt.geom.Point2D;

public class CalculoSequia extends CalculoClima{

	public CalculoSequia() {
		super();
	}
	public boolean haySequia(Point2D posP1, Point2D posP2, Point2D posP3, Point2D sol) {
		return estanAlineadosConElSol(posP1, posP2, posP3, sol);
	}
	
	public boolean estanAlineadosConElSol(Point2D posP1, Point2D posP2,Point2D posP3, Point2D sol) { 
		boolean resultado = this.estanAlineados(sol,posP1, posP2) && this.estanAlineados(sol, posP2, posP3) && 
							this.estanAlineados(sol, posP1, posP3) && this.estanAlineados(posP1, posP2, posP3);
		return resultado;
	}
}
