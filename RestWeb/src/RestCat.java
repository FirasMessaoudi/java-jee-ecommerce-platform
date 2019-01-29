import metier.entities.*;
import metier.sessions.*;
import javax.ejb.*;
import javax.ws.rs.core.MediaType;
import javax.ws.*;
import javax.ws.rs.*;
import java.util.*;
@Stateless
@Path("/Categorie")
public class RestCat {
	@EJB
	private ILocal metier;
	@GET
	@Path(value="/cat")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categorie> listerCat(){
		return metier.listerCat();
	}
	
	@GET
	@Path(value="/getCat/{idc}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie getCat(@PathParam(value="idc") long idc) {
		return metier.getCategorie(idc);
	}
	
	
}
