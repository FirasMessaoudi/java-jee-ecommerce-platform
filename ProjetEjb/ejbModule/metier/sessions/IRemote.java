package metier.sessions;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Categorie;
import metier.entities.Ligne_Produit_Prom;
import metier.entities.Produits;
import metier.entities.Promotion;
@Remote
public interface IRemote {
	public void ajouterCat( Categorie c);
	public void supprimerCategorie(Long idcat);
	public void modifierCategorie(Categorie c);
	public void ajouterProduit(Produits p,Long idcat);
	public void modifierProduit(Produits p) ;
	public void supprimerProduit(Long idp);
	public void ajouterPromotion(Promotion p);
	public void modifierPromotion(Promotion p) ;
	public void supprimerPromotion(String idp);
	public Produits getProduit(Long idp) ;
	public List<Produits>listerProduit();
	public List<Categorie> listerCat();
	public Categorie getIdCatParNom(String nom );
	public Produits getProduitParNom(String nomp);
	public void ajouterLignePromotion(Ligne_Produit_Prom lp);
	public Produits getMaxId();
	public List<Produits> listerProduitParMotCle(String mc);
	public Promotion getPromotion(String idp);
	public List<Promotion> listerPromotion();
	public List<Long> getIdByProm(String id);
}
