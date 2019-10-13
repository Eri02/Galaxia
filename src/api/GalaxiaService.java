package api;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.InfoClima;
import domain.Planeta;
import domain.SistemaSolar;

@Path("/planetas")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class GalaxiaService {

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
		List<InfoClima> climas = new ArrayList<InfoClima>();
		climas = sistSolar.getPrecionClima();		
		return Response.ok(climas, MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/periodos")
	@GET
	public Response getPeriodos() {
		
		return Response.ok().build();
	}
	
}
