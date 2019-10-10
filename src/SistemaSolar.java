

public class SistemaSolar {
	
	Planeta planeta1 = new Planeta();
	Planeta planeta2 = new Planeta();
	Planeta planeta3 = new Planeta();
	
	double pendiente;
	double independiente;
	
	public void getClimaPorDia() {
		
	}
	
	public void getPeriodosLluviosos() {
		
	}
	
	public void getPeriodosNoLluviosos() {
		
	}
	
	public void getPeriodosDeSequia() {
		
	}
	
	//a, b , c distancia entre los puntos (posici�n) de C/planeta
	public double perimetro(double a, double b, double c) {
		return a + b + c;
	}
	public boolean haySequia() {
		
		return true;
	}
	
	public boolean esClimaOptimo() {
		return true;
	}
	
	public boolean estanAlineados() {
		double elevacion = planeta2.getPosX() - planeta1.getPosX();
		double avance = planeta2.getPosY() - planeta2.getPosY();
		
		this.pendiente = elevacion/avance;
		
		this.independiente = planeta1.getPosY() - (this.pendiente * planeta1.getPosX());
		
		//ec pendiente queda: Y = pendiente*x + independiente		
		double pendiente3 = planeta3.getPosX() - planeta2.getPosX() /  planeta3.getPosY() - planeta2.getPosY();
		
		return (pendiente == pendiente3);
	}
	
	public boolean estanAlineadosConElSol() {
		return this.estanAlineados() && this.independiente == 0;
	}
}
