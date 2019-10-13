package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.constraints.AssertFalse;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import domain.Planeta;
import domain.SistemaSolar;
import junit.framework.TestCase;


class TestSistemaSolar extends TestCase {
	
	Planeta planeta1 =  new Planeta("Ferengi", 1,500,-1);
	Planeta planeta2 =  new Planeta("Betasoide", 3,2000, -1);
	Planeta planeta3 =  new Planeta("Vulcano", 5,1000, 1);
	
	private SistemaSolar sist = new SistemaSolar();
	
	@Before
	public void setUp() {
		sist = new SistemaSolar(planeta1, planeta2, planeta3);
	}
	
	@Test
	public void testGetClima() {
		setUp();
		assertEquals(true,sist.getClimaPorDia(566));
	}

}
