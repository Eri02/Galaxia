package api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import domain.InfoClima;
import domain.Planeta;
import domain.SistemaSolar;

@Path("/planetas")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
	/*
	 *Ferengi:
	 * velocidadAngular = 1 grado/dia en sentido horario(-)
	 * radio = 500 Km
	 * 
	 * Betasoide:
	 * velocidadAngular = 3 grados/dia en sentido horario (-)
	 * radio = 2000 km
	 * 
	 * Vulcano:
	 * velocidadAngular = 5grados/dia en sentido antihorario (+)
	 * radio = 1000 km
	 * String nombre, int velocidad, double radio, long angulo
	 * */

public class GalaxiaService {

	//public SistemaSolar sistSolar;
	private static final List<Planeta> planetas = new ArrayList<>();
	static {
		planetas.add(new Planeta("Ferengi", 1,500,-1));
		planetas.add(new Planeta("Betasoide", 3,2000, -1));
		planetas.add(new Planeta("Vulcano", 5,1000, 1));
	}

	Planeta planeta1 =  new Planeta("Ferengi", 1,500,-1);
	Planeta planeta2 =  new Planeta("Betasoide", 3,2000, -1);
	Planeta planeta3 =  new Planeta("Vulcano", 5,1000, 1);
	
	SistemaSolar sistSolar = new SistemaSolar(planeta1, planeta2, planeta3);
	
	@GET
	public Response getAllPlanetas() {
		return Response.ok(this.planetas, MediaType.APPLICATION_JSON).build();
	}
	
	/*@Path("{dias}")
	@GET 
	public Response getPosicionDePlanetasPorDias(@PathParam("dias") int dias) {
		Planeta planeta1 = new Planeta("FerengiCopy", 1,500,-1);
		System.out.println("El paneta está en la posición " + planeta1.posicionPorDia(dias) + "a los " + dias + "día(s)");
		return Response.ok(planeta1.posicionPorDia(dias)).build();
	}
	*/
	
	@Path("/clima")
	@GET
	public Response getClimaPorAnios() {
		int diasEnTotal = 10 * 365;
		List<InfoClima> climas = new ArrayList<InfoClima>();
		for (int dia = 0; dia <= diasEnTotal; dia++) {
			InfoClima info = new InfoClima();
			info = sistSolar.getClimaPorDia(dia);
			if(info.toString() != null ||info.toString() != ""){
				climas.add(info);
			}
		}	
		
		//System.out.println("Clima: " + climas);
		return Response.ok(climas, MediaType.APPLICATION_JSON).build();
	}
}
