package metier.entities;
import javax.persistence.*;
import java.io.*;
@Entity
@Table(name="ligne_comm")
public class Lign_Comm implements Serializable {
@EmbeddedId
private Lign_comm_Pk id;



public Lign_Comm() {
	super();
}



public Lign_comm_Pk getId() {
	return id;
}



public void setId(Lign_comm_Pk id) {
	this.id = id;
}



public double getPrix() {
	return prix;
}



public void setPrix(double prix) {
	this.prix = prix;
}



public int getQuantite() {
	return quantite;
}



public void setQuantite(int quantite) {
	this.quantite = quantite;
}



public Produits getProduit() {
	return produit;
}



public void setProduit(Produits produit) {
	this.produit=produit;
}



public Commande getCommande() {
	return commande;
}



public void setCommande(Commande commande) {
	this.commande = commande;
}



public Lign_Comm(double prix, int quantite, Produits produit, Commande commande) {
	super();
	this.prix = prix;
	this.quantite = quantite;
	this.produit = produit;
	this.commande = commande;
}



public Lign_Comm(Lign_comm_Pk id, double prix, int quantite) {
	super();
	this.id = id;
	this.prix = prix;
	this.quantite = quantite;
}



@Column(name="prix",nullable=false)
private double prix;

@Column(name="quantite",nullable=false)
private int quantite;

@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name ="idProduit",updatable = false, insertable = false, referencedColumnName = "idProduit")
private Produits produit;



@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name="Idcomm",updatable = false, insertable = false, referencedColumnName ="IdComm")
private Commande commande;


}
