package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.constraints.AssertFalse;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import domain.Planeta;
import domain.SistemaSolar;


class SistemaSolarTest {
	
	Planeta planeta1 =  new Planeta("Ferengi", 1,500,-1);
	Planeta planeta2 =  new Planeta("Betasoide", 3,2000, -1);
	Planeta planeta3 =  new Planeta("Vulcano", 5,1000, 1);
	
	private SistemaSolar sist;
	
	@Before
	public void setUp() {
		sist = new SistemaSolar(planeta1, planeta2, planeta3);
	}
	
	public boolean llueve(int dia) {
		return true;//sist.getClimaPorDia(dia);
	}
	@Test
	public void testHayLluvia() {
		
	}

}
