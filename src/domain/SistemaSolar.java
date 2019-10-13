package domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

public class SistemaSolar {

	static final Point2D POS_SOL = new Double(0, 0); 
	
	/*Planeta planeta1 =  new Planeta("Ferengi", 1,500,-1);
	Planeta planeta2 =  new Planeta("Betasoide", 3,2000, -1);
	Planeta planeta3 =  new Planeta("Vulcano", 5,1000, 1);*/
	
	private Planeta planeta1 = new Planeta();
	private Planeta planeta2 = new Planeta();
	private Planeta planeta3 = new Planeta();
	
	
	public Lluvia lluvia = new Lluvia();
	public Optimo optimo = new Optimo();
	public Sequia sequia = new Sequia();
		
public SistemaSolar(Planeta p1, Planeta p2, Planeta p3) {
	this.planeta1 = p1;
	this.planeta2 = p2;
	this.planeta3 = p3;
}
	
	public SistemaSolar() {
	// TODO Auto-generated constructor stub
}

	public boolean getClimaPorDia(int dia) { //InfoClima
		//InfoClima info = new InfoClima();
		String info = "Desc";
		Point2D posP1 = planeta1.posicionPorDia(dia);
		Point2D posP2 = planeta2.posicionPorDia(dia);
		Point2D posP3 = planeta3.posicionPorDia(dia);
		
		if(lluvia.hayLluvia(posP1, posP2, posP3, POS_SOL)) {
			//info.setTipoClima("Llueve");
			//info.setDia(dia);
			//info = "Lluvia";
			System.out.print("Lluvia");
			return lluvia.hayLluvia(posP1, posP2, posP3, POS_SOL);
		} 
		
		if(optimo.esOptimo(posP1, posP2, posP3))
		{
			//info.setTipoClima("Optimo");
			//info.setDia(dia);
			//info = "Optimo";
			System.out.print("Optimo");
			return optimo.esOptimo(posP1, posP2, posP3);
		}
		
		if(sequia.haySequia(posP1, posP2, posP3, POS_SOL)) {
			//info.setTipoClima("Sequia");
			//info.setDia(dia);
			//info = "Sequia";
			System.out.print("Sequia");
			return sequia.haySequia(posP1, posP2, posP3, POS_SOL);
		}
		System.out.print("dia: " + info);
		
		return false;
		
	}
	
	public Planeta getPlaneta1() {
		return this.planeta1;
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
		

}
