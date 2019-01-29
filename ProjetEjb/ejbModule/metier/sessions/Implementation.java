package metier.sessions;
import java.io.*;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

import metier.entities.*;

@Stateless
@Remote(IRemote.class)
public class Implementation implements ILocal,IRemote {
@PersistenceContext
private EntityManager em;

//Categorie
public void ajouterCat( Categorie c) {
	em.persist(c);
}
public List<Categorie> listerCat(){
	Query req=em.createQuery("select c from Categorie c");
	return req.getResultList();
}
public Categorie getIdCatParNom(String nom ) {
	Query req=em.createQuery("select c from Categorie c where c.NomCategorie=:x");
	req.setParameter("x", nom);
	return (Categorie) req.getSingleResult();
}
public Categorie getCategorie(Long idcat) {
	Categorie c;
	c= em.find(Categorie.class, idcat);
	 if(c==null)
		 throw new RuntimeException("categorie introuvable");
	 return c;
}
public void supprimerCategorie(Long idcat) {
	Categorie c=em.find(Categorie.class, idcat);
	em.remove(c);
}
public void modifierCategorie(Categorie c) {
	em.merge(c);
}

//Produit 
public void ajouterProduit(Produits p,Long idcat) {
	Categorie c=em.find(Categorie.class, idcat);
	p.setCat(c);
	em.persist(p);
	
}
public List<Produits>listerProduit(){
	Query req=em.createQuery("select p from Produits p");
	return req.getResultList();
}
 public Produits getProduit(Long idp) {
	 Produits p=em.find(Produits.class, idp);
	 if(p==null)
		 throw new RuntimeException("produit introuvable");
	 return p;
 }
 public Produits getProduitParNom(String nomp) {
	 Query req=em.createQuery("select p from Produits p where p.designation=:nom");
	 req.setParameter("nom", nomp);
	 return (Produits)req.getSingleResult();
 }
 
 public Long getIdProduit(String nomp) {
	 Query req=em.createQuery("select p.idProduit from Produits p where p.designation like :nom");
	 req.setParameter("nom", nomp);
	 return (Long)req.getSingleResult();
 }
 
 public void modifierProduit(Produits p) {
	 em.merge(p);
 }
 public void supprimerProduit(Long idp) {
	 Produits p=em.find(Produits.class, idp);
	 em.remove(p);
 }
 public ArrayList<Produits> listerProduitParMotCle(String mc){
	 Query req=em.createQuery("select p from Produits p where p.designation like :mc or p.description like :mc");
	 req.setParameter("mc", "%"+mc+"%");
	 return (ArrayList<Produits>) req.getResultList();
	 
 }
 public Produits getMaxId() {
	 Query req1=em.createQuery("select max(p.idProduit) from Produits p");
	 Query req=em.createQuery("select p from Produits p where p.idProduit=:x");
	 req.setParameter("x", req1.getSingleResult());
	 return (Produits)req.getSingleResult();
 }
 public ArrayList<Produits>listerProduitParCat(Long idcat){
	 Query req=em.createQuery("select p from Produits p where p.cat.idCategorie=:x");
	 req.setParameter("x", idcat);
	 return (ArrayList<Produits>) req.getResultList();
	 
 }
 public List<Produits>listerProduitSelected(){
	 Query req=em.createQuery("select p from Produits p where p.selectionnee=true");
	 return req.getResultList();
 }
 
 //promotion
 public void ajouterPromotion(Promotion p) {
	 em.persist(p);
 }
 public List<Promotion> listerPromotion(){
	 Query req=em.createQuery("select p from Promotion p");
	 return req.getResultList();
 }
 public Promotion getPromotion(String idp) {
	 Promotion p=em.find(Promotion.class, idp);
	 if(p==null)
		 throw new RuntimeException("produit introuvable");
	 return p;
 }
 public void modifierPromotion(Promotion p) {
	 em.merge(p);
 }
 public void supprimerPromotion(String idp) {
	 Promotion p=em.find(Promotion.class, idp);
	 em.remove(p);
 }
 public void ajouterLignePromotion(Ligne_Produit_Prom lp) {
	 em.persist(lp);
 }
 public List<Long> getIdByProm(String id) {
	 Query req=em.createQuery("select p.produitProm.idProduit from Ligne_Produit_Prom p where p.prom.idprom=:x");
	 req.setParameter("x", id);
	 return req.getResultList();
 }
 
 
 
 public Long idClientCompte(String login,String password) {
	 Long id=new Long(0);
	 Long idfinal=new Long(0);
	 Query req=em.createQuery("select cp.c.IdClt from Compte cp where cp.login=:x and cp.password=:y");
	 req.setParameter("x", login);
	 req.setParameter("y", password);
	 try {
		 idfinal=(Long)req.getResultList().get(0);
	 }catch(Exception e) {
		 return id;
	 }
	 
	 return idfinal;
	 
 }
 public void addClient(Client c) {
	 em.persist(c);
 }
 public void addCmd(Commande cmd,Long idcl) {
	 Client c=em.find(Client.class, idcl);
	 cmd.setCl(c);
	 em.persist(cmd);;
 }
public void addCompte(Compte cp,Long idcl) {
	 Client c=em.find(Client.class, idcl);
	 cp.setC(c);
	em.persist(cp);
}
public void AddLc(Lign_Comm lc) {
	em.persist(lc);
}
public Long maxIdCl() {
	Query req=em.createQuery("select Max(c.IdClt) from Client c");
	return (Long)req.getSingleResult();
}
public Long maxIdCmd() {
	Query req=em.createQuery("select Max(c.Idcomm) from Commande c");
	return (Long)req.getSingleResult();
}
public String checkEmail( String email) {
	String err="";
	String ema="";
	Query req=em.createQuery("select c.email from Client c where c.email=:x");
	req.setParameter("x", email);
	try {
		ema=(String)req.getSingleResult();
	}catch(Exception e) {
		return err;
	}
	return ema;
	
}

public String checkLogin( String login) {
	String err="";
	String log="";
	Query req=em.createQuery("select c.login from Compte c where c.login=:x");
	req.setParameter("x", login);
	try {
		log=(String)req.getSingleResult();
	}catch(Exception e) {
		return err;
	}
	return log;
	
}

}
