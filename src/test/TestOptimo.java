package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.Test;

import domain.CalculoClima;
import domain.CalculoOptimo;
import junit.framework.TestCase;

class TestOptimo extends TestCase{
	
	private CalculoOptimo optimo = new CalculoOptimo();
	Point2D p1 = new Point2D.Double(4.0,2.0);
	Point2D p2 = new Point2D.Double(4.0,4.0);
	Point2D p3 = new Point2D.Double(4.0,6.0);

	@Test
	void testEsOptimo() {
		assertEquals(true, optimo.esOptimo(p1, p2, p3));
	}

}
