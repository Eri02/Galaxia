package domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

import Enum.ClimaEnum;

public class SistemaSolar {

	static final Point2D POS_SOL = new Double(0, 0); 
	List<InfoClima> climas = new ArrayList<InfoClima>();
	
	private Planeta planeta1 = new Planeta();
	private Planeta planeta2 = new Planeta();
	private Planeta planeta3 = new Planeta();
	
	public CalculoLluvia lluvia = new CalculoLluvia();
	public CalculoOptimo optimo = new CalculoOptimo();
	public CalculoSequia sequia = new CalculoSequia();
		
	public SistemaSolar(Planeta p1, Planeta p2, Planeta p3) {
		this.planeta1 = p1;
		this.planeta2 = p2;
		this.planeta3 = p3;
	}
	
	public SistemaSolar() {
	// TODO Auto-generated constructor stub
	}

	public InfoClima getClimaPorDia(int dia) { 
		Point2D posP1 = planeta1.posicionPorDia(dia);
		Point2D posP2 = planeta2.posicionPorDia(dia);
		Point2D posP3 = planeta3.posicionPorDia(dia);
		
		if(lluvia.hayLluvia(posP1, posP2, posP3, POS_SOL)) {
			InfoClima infoLluvia = new InfoClima(ClimaEnum.LLUVIA.getTipo(), dia);
			System.out.print("Llueve");
			return infoLluvia;
		} 
		
		if(optimo.esOptimo(posP1, posP2, posP3))
		{
			InfoClima infoOptimo = new InfoClima(ClimaEnum.OPTIMO.getTipo(), dia);
			System.out.print("Optimo");
			return infoOptimo;
		}
		
		if(sequia.haySequia(posP1, posP2, posP3, POS_SOL)) {
			InfoClima infoSequia = new InfoClima(ClimaEnum.SEQUIA.getTipo(), dia);
			System.out.print("Sequia");
			return infoSequia;
		}
		
		InfoClima sinInfo = new InfoClima();
		System.out.print("Sin info: " + sinInfo);
		return  sinInfo;	
	}
	
	public List<InfoClima> getPrediccionClima(){	
		int diasEnTotal = 10 * 365;
		List<InfoClima> climas = new ArrayList<InfoClima>();
		for (int dia = 0; dia <= diasEnTotal; dia++) {
			InfoClima info = new InfoClima();
			info = this.getClimaPorDia(dia);
			if(info.getClima() != "" && info.getDia() != 0){
				climas.add(info);
			}
		}
		return climas;
	}
	
	
	public List<InfoPeriodo> getPeriodosClima() {
		List<InfoClima> climas = new ArrayList<InfoClima>();
		climas = this.getPrediccionClima();
		int countLluvia = 0;
		int countSequia = 0;
		int countOptimo = 0;
		
		for (InfoClima infoClima : climas) {
			switch (infoClima.getClima()) {
				case "Llueve":
					countLluvia++;
					break;
				case "Sequia":
					countSequia++;
					break;
				case "Optimo":
					countOptimo++;
					break;
				default:
					break;
			}
		}
		
		InfoPeriodo periodoLluvia = new InfoPeriodo(ClimaEnum.LLUVIA.getTipo(), countLluvia);
		InfoPeriodo periodoSequia = new InfoPeriodo(ClimaEnum.SEQUIA.getTipo(), countSequia);
		InfoPeriodo periodoOptimo = new InfoPeriodo(ClimaEnum.OPTIMO.getTipo(), countOptimo);
		
		List<InfoPeriodo> periodos = new ArrayList<InfoPeriodo>();
		
		periodos.add(periodoLluvia);
		periodos.add(periodoSequia);
		periodos.add(periodoOptimo);

		return periodos;
	}
	
	public InfoClima esPicoMaximoLluvia() {
		double maxPerimetro = 0;
		int diaMax= 0;
		
		int diasEnTotal = 10 * 365;

		for (int dia = 0; dia <= diasEnTotal; dia++) {
			Point2D posP1 = planeta1.posicionPorDia(dia);
			Point2D posP2 = planeta2.posicionPorDia(dia);
			Point2D posP3 = planeta3.posicionPorDia(dia);
			
			if(lluvia.hayLluvia(posP1, posP2, posP3, POS_SOL)) {
				double a = lluvia.distanciaEntreDosPuntos(posP1, posP2);
				double b = lluvia.distanciaEntreDosPuntos(posP2, posP3);
				double c = lluvia.distanciaEntreDosPuntos(posP1, posP3);
				
				double perimetroActual = lluvia.perimetro(a, b, c);
				
				if(maxPerimetro < perimetroActual) {				
					maxPerimetro = perimetroActual;
					diaMax = dia;
				}
			}
		}
		
		InfoClima infoLluviaMax = new InfoClima(ClimaEnum.LLUVIAMAX.getTipo(), diaMax);
		return infoLluviaMax;
		
	}
		

}
