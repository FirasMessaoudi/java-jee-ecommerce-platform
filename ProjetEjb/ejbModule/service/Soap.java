package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.PathParam;

import metier.entities.Categorie;
import metier.entities.Produits;
import metier.entities.Promotion;
import metier.sessions.ILocal;

@Stateless
@WebService
public class Soap {
	@EJB
	private ILocal metier;
@WebMethod
public List<Produits> listerProduits(){
	return metier.listerProduit();
}
@WebMethod
public Produits getProduit(@WebParam(name="idp") Long idp) {
	return metier.getProduit(idp);
}
@WebMethod
public List<Produits> listerProduitsParMotCle(@WebParam(name="mc") String mc) {
	return metier.listerProduitParMotCle(mc);
}
@WebMethod
public List<Produits>listerProduitParCat(@WebParam(name="idc") Long idc){
	return metier.listerProduitParCat(idc);
}
@WebMethod
public List<Produits>listerProduitSelected(){
	return metier.listerProduitSelected();
}
@WebMethod
public List<Promotion> listerProm(){
	return metier.listerPromotion();
	
}

@WebMethod
public List<Categorie> listerCat(){
	return metier.listerCat();
}
@WebMethod
public Categorie getCat(@WebParam(name="idc") long idc) {
	return metier.getCategorie(idc);
}




}
