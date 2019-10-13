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
	
	private Planeta planeta1;
	private Planeta planeta2;
	private Planeta planeta3;
	
	
	public Lluvia lluvia;
	public Optimo optimo;
	public Sequia sequia;
		
public SistemaSolar(Planeta p1, Planeta p2, Planeta p3) {
	this.planeta1 = p1;
	this.planeta2 = p2;
	this.planeta3 = p3;
}
	
	public String getClimaPorDia(int dia) { //InfoClima
		//InfoClima info = new InfoClima();
		String info = "";
		Point2D posP1 = planeta1.posicionPorDia(dia);
		Point2D posP2 = planeta2.posicionPorDia(dia);
		Point2D posP3 = planeta3.posicionPorDia(dia);
		
		if(lluvia.hayLluvia(posP1, posP2, posP3, POS_SOL)) {
			//info.setTipoClima("Llueve");
			//info.setDia(dia);
			info = "Lluvia";
		} 
		
		if(optimo.esOptimo(posP1, posP2, posP3))
		{
			//info.setTipoClima("Optimo");
			//info.setDia(dia);
			info = "Optimo";
		}
		
		if(sequia.haySequia(posP1, posP2, posP3, POS_SOL)) {
			//info.setTipoClima("Sequia");
			//info.setDia(dia);
			info = "Sequia";
		}
		
		return info;
		
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
