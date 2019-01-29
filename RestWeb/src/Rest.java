import metier.entities.*;
import metier.sessions.*;
import javax.ejb.*;
import javax.ws.rs.core.MediaType;
import javax.ws.*;
import javax.ws.rs.*;
import java.util.*;
@Stateless
@Path("/Produits")
public class Rest {
@EJB
private ILocal metier;
@GET
@Path(value="/prod")
@Produces(MediaType.APPLICATION_JSON)
public List<Produits> listerProduits(){
	return metier.listerProduit();
}

@GET
@Path(value="/getProduit/{idp}")
@Produces(MediaType.APPLICATION_JSON)
public Produits getProduit(@PathParam(value="idp") long idp) {
	return metier.getProduit(idp);
}

@GET
@Path(value="/ProduitParNom/{nom}")
@Produces(MediaType.APPLICATION_JSON)
public Produits getProduitParNom(@PathParam(value="nom")String nomp) {
	return metier.getProduitParNom(nomp);
}

@GET
@Path(value="/produitParMc/{mc}")
@Produces(MediaType.APPLICATION_JSON)
public List<Produits> listerProduitsParMotCle(@PathParam(value="mc") String mc) {
	return metier.listerProduitParMotCle(mc);
}

@GET
@Path(value="/produitParCat/{idc}")
@Produces(MediaType.APPLICATION_JSON)
public List<Produits>listerProduitParCat(@PathParam(value="idc") long idc){
	return metier.listerProduitParCat(idc);
}

@GET
@Path(value="/produitSelected")
@Produces(MediaType.APPLICATION_JSON)
public List<Produits>listerProduitSelected(){
	return metier.listerProduitSelected();
}

@GET
@Path(value="/checkIdCompte/{login}/{password}")
@Produces(MediaType.APPLICATION_JSON)
public Long idClientCompte(@PathParam(value="login") String login ,@PathParam(value="password") String password) {
	return metier.idClientCompte(login, password);
}
@POST
@Path(value="/commander")
@Produces(MediaType.APPLICATION_JSON)
public void addCmd(@FormParam(value="dateCommande") Date date,@FormParam(value="modepaiement") String modep,@FormParam(value="cl") Long idcl) {
	 metier.addCmd(new Commande(date,modep), idcl);
}

@GET
@Path(value="/maxidclient")
@Produces(MediaType.APPLICATION_JSON)
public Long maxIdClient() {
	return metier.maxIdCl();
}

@GET
@Path(value="/maxidcmd")
@Produces(MediaType.APPLICATION_JSON)
public Long maxIdCmd() {
	return metier.maxIdCmd();
}
@GET
@Path(value="/getprodparnom/{nomp}")
@Produces(MediaType.APPLICATION_JSON)
public Long getByName(@PathParam(value="nomp") String nomp) {
	return metier.getIdProduit(nomp);
}
@POST
@Path(value="/addClient")
@Produces(MediaType.APPLICATION_JSON)
public void addClient(@FormParam(value="nom") String nom,@FormParam(value="adresse") String adresse,@FormParam(value="email") String email,@FormParam(value="tel") String tel) {
	metier.addClient(new Client(nom,adresse,email,tel));
}
@POST
@Path(value="/addCompte")
@Produces(MediaType.APPLICATION_JSON)
public void addCompte(@FormParam(value="login") String login,@FormParam(value="password") String password,@FormParam(value="c") Long idcl) {
	metier.addCompte(new Compte(login,password), idcl);
}
@POST
@Path(value="/addLc")
@Produces(MediaType.APPLICATION_JSON)
public void addLc(@FormParam(value="IdComm") Long idcomm,@FormParam(value="idProduit") Long idp,@FormParam(value="quantite") int quantite,@FormParam(value="prix") double prix) {
	Lign_comm_Pk lck =new Lign_comm_Pk(idcomm, idp);
	metier.AddLc(new Lign_Comm(lck, prix, quantite));
}
}
