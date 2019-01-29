import metier.entities.*;
import metier.sessions.*;
import javax.ejb.*;
import javax.ws.rs.core.MediaType;
import javax.ws.*;
import javax.ws.rs.*;
import java.util.*;
@Stateless
@Path("/Promotion")
public class RestProm {
	@EJB
	private ILocal metier;
	@GET
	@Path(value="/prom")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Promotion> listerProm(){
		return metier.listerPromotion();
	}
	
}
