package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import org.junit.jupiter.api.Test;

import domain.Optimo;
import domain.Sequia;
import junit.framework.TestCase;

class TestSequia extends TestCase {

	private Sequia sequia = new Sequia();
	Point2D p1 = new Point2D.Double(4.0,2.0);
	Point2D p2 = new Point2D.Double(4.0,4.0);
	Point2D p3 = new Point2D.Double(4.0,6.0); 
	Point2D sol = new Double(0, 0);
	
	@Test
	public void testHaySequia() {
		assertEquals(false, sequia.haySequia(p1, p2, p3, sol));
	}

}
