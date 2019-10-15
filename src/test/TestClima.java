package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.Test;

import domain.CalculoClima;
import junit.framework.TestCase;

class TestClima extends TestCase{

	private CalculoClima clima = new CalculoClima();
	Point2D p1 = new Point2D.Double(4.0,2.0);
	Point2D p2 = new Point2D.Double(4.0,4.0);
	Point2D p3 = new Point2D.Double(4.0,6.0);
	
	@Test
	void testPerimetro() {
		assertEquals(6.0, clima.perimetro(2, 2, 2));
	}
	
	@Test
	public void testDistanciaEntrePuntos() {		
	assertEquals(2.0, clima.distanciaEntreDosPuntos(p1,p2));
	}
	
	@Test
	public void testAlineados() {
		assertEquals(true, clima.estanAlineados(p1, p2, p3));
	}

}
