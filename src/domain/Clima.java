package domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Clima {

	public SistemaSolar sistSolar = new SistemaSolar();
	
	public void calcularClimaPorDia(int dia) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean hayLluvia(Planeta p1, Planeta p2, Planeta p3, Point2D sol,int dias){
		//llueve si sus posiciones forman un triángulo, además, si el sol está contenido en él.
		Point2D posP1 = p1.posicionPorDia(dias);
		Point2D posP2 = p2.posicionPorDia(dias);
		Point2D posP3 = p3.posicionPorDia(dias);
		if(!sistSolar.estanAlineados(p1, p2, p3, dias)) {
			return sistSolar.solPerteneceAlTriangulo(posP1, posP2, posP3,sol);
		}
		return sistSolar.formanUnTriangulo(posP1, posP2, posP3); ///////////////
	}
	
	public boolean haySequia(Planeta p1, Planeta p2, Planeta p3, Point2D sol, int dias) {
		return sistSolar.estanAlineadosConElSol(p1, p2, p3, sol, dias);
	}
	
	public boolean esClimaOptimo(Planeta p1, Planeta p2, Planeta p3,int dias) {
		return sistSolar.estanAlineados(p1, p2, p3, dias);
	}
	
	
	
}
