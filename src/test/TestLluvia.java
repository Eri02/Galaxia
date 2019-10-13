package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import org.junit.jupiter.api.Test;

import domain.Lluvia;

class TestLluvia {
	
	Point2D p1 = new Point2D.Double(1.0,-1.0);
	Point2D p2 = new Point2D.Double(-2.0,1.0);
	Point2D p3 = new Point2D.Double(1.0,3.0);
	Point2D sol = new Double(0, 0);
	
	Lluvia lluvia = new Lluvia();
	
	
	//public boolean hayLluvia(Point2D  p1, Point2D p2, Point2D p3, Point2D sol) {

	//public boolean solPerteneceAlTriangulo(Point2D p1, Point2D p2, Point2D p3, Point2D sol) {

	//public double areaDeTriangulo(double a, double b, double c) {

	//public boolean formanUnTriangulo(Point2D p1, Point2D p2, Point2D p3){

	@Test
	void testLlueve() {
		assertEquals(true, lluvia.hayLluvia(p1, p2, p3, sol));
	}
	
	@Test
	void testSolDentroDelTriangulo() {
		assertEquals(true, lluvia.solPerteneceAlTriangulo(p1, p2, p3, sol));
	}
	
	@Test
	void testAreaTriangulo() {
		
	}

	@Test
	void testFormanUnTriangulo() {
		assertEquals(true, lluvia.formanUnTriangulo(p1, p2, p3));
	}
}
