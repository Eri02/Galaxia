package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.Test;

import domain.Planeta;
import junit.framework.TestCase;

class TestPlaneta extends TestCase{

	Planeta vulcano =  new Planeta("Vulcano", 5,1000, 1);
	Point2D punto = new Point2D.Double(643.0,766.0);
	
	@Test
	void testAnguloPorDia() {	
		assertEquals(10, vulcano.calculoAngulosPorDia(2)); 
	}
	
	@Test
	void testAnguloRadian() {
		assertEquals(0.17453292519943295, vulcano.calculoAnguloRadian(10));
	
	}
	
	@Test
	void testPosicionPorDia() {
		assertEquals(punto, vulcano.posicionPorDia(10));
	}

}
