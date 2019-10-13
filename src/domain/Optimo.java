package domain;

import java.awt.geom.Point2D;

public class Optimo extends Clima{
	
	public Optimo() {
		super();
	}
	
	public boolean esOptimo(Point2D posP1, Point2D posP2, Point2D posP3,int dia) {
		return estanAlineados(posP1, posP2, posP3, dia);
	}

	
}
