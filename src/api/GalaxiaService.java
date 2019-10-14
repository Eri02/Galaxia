package api;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.InfoClima;
import domain.InfoPeriodo;
import domain.Planeta;
import domain.SistemaSolar;

@Path("/planetas")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class GalaxiaService {

	Planeta planeta1 =  new Planeta("Ferengi", 1,500,-1);
	Planeta planeta2 =  new Planeta("Betasoide", 3,2000, -1);
	Planeta planeta3 =  new Planeta("Vulcano", 5,1000, 1);
	
	SistemaSolar sistSolar = new SistemaSolar(planeta1, planeta2, planeta3);

	@Path("/prediccion")
	@GET
	public Response getClimaPorAnios() {
		List<InfoClima> climas = new ArrayList<InfoClima>();
		climas = sistSolar.getPrediccionClima();		
		return Response.ok(climas, MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/periodos")
	@GET
	public Response getPeriodos() {
		List<InfoPeriodo> periodos = new ArrayList<InfoPeriodo>();
		periodos = sistSolar.getPeriodosClima();
		return Response.ok(periodos, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/clima")
	public Response getClimaPorDia(@QueryParam("dia") int dia) {
		InfoClima clima = new InfoClima();
		clima = sistSolar.getClimaPorDia(dia);
		return Response.ok(clima, MediaType.APPLICATION_JSON).build();
	}
	
}
