package metier.sessions;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import metier.entities.Categorie;
import metier.entities.Client;
import metier.entities.Commande;
import metier.entities.Compte;
import metier.entities.Lign_Comm;
import metier.entities.Panier;
import metier.entities.Produits;
import metier.entities.Promotion;
@Local
public interface ILocal {
	public List<Categorie> listerCat();
	public Categorie getCategorie(Long idcat);
	public List<Produits>listerProduit();
	public Produits getProduit(Long idp) ;
	public List<Produits> listerProduitParMotCle(String mc);
	public List<Produits>listerProduitParCat(Long idcat);
	public List<Produits>listerProduitSelected();
	public List<Promotion> listerPromotion();
	public Long idClientCompte(String login,String password);
	public void addClient(Client c);
	public void addCmd(Commande cmd,Long idcl);
	public void addCompte(Compte cp,Long idcl);
	public void AddLc(Lign_Comm lc);
	public Long maxIdCl();
	public Long maxIdCmd();
	public Produits getProduitParNom(String nomp);
	public Long getIdProduit(String nomp);
	public String checkLogin(String login);
	public String checkEmail(String email);
	
}
