package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;

import domain.Planet;

public class TestPlanetPersistence {

	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	
	public static void main(String[] args) {
		
		//Gestor de persistencia
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		insertInicial();
		imprimirTodo();
		//manager.merge(planeta);
		Planet p = manager.find(Planet.class, 10L);
		p.setNombre("planetaModif");
		manager.getTransaction().commit();
		
		imprimirTodo();
		manager.close();
	}
	
	private static void insertInicial() {
		Planet planeta = new Planet(10L,"planeta1", 5, 5000);	
		manager.getTransaction().begin();
		manager.persist(planeta);
		manager.getTransaction().commit();
		System.out.println("Se insertó" + planeta);
		 
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo(){
		List<Planet> planets = (List<Planet>) manager.createQuery("FROM Planet").getResultList();
		System.out.println("En esta base hay " + planets.size() + " planetas en el sistema.");
		
		for(Planet p : planets) {
			System.out.println(p.toString());
		}		
	}
	

}
