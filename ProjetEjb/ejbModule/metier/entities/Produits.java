package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="Prt")
public class Produits implements Serializable {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long idProduit;
private String designation;
private String description;
@Column(nullable=false)
private double prix;
private String photo;
@Column(nullable=false)
private int quantite;
private boolean selectionnee;

public Produits() {
	super();
}
@OneToMany(mappedBy="produit")
private Collection<Lign_Comm> commands;

@OneToMany(mappedBy="produitProm")
private Collection<Ligne_Produit_Prom> prom;

@ManyToOne(cascade=CascadeType.ALL)
Categorie cat;
@JoinColumn(name="idCategorie",nullable=false)

public Long getIdProduit() {
	return idProduit;
}
public void setIdProduit(Long idProduit) {
	this.idProduit = idProduit;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public boolean isSelectionnee() {
	return selectionnee;
}
public void setSelectionnee(boolean selectionnee) {
	this.selectionnee = selectionnee;
}
public Categorie getCat() {
	return cat;
}
public void setCat(Categorie cat) {
	this.cat = cat;
}

public Produits(String designation, String description, double prix, String photo, int quantite) {

	this.designation = designation;
	this.description = description;
	this.prix = prix;
	this.photo = photo;
	this.quantite = quantite;
}
public Produits(Long idProduit, String designation, String description, double prix, String photo, int quantite,Categorie cat) {
	this.idProduit = idProduit;
	this.designation = designation;
	this.description = description;
	this.prix = prix;
	this.photo = photo;
	this.quantite = quantite;
	this.cat=cat;
}
public Produits(Long idProduit, String designation, String description, double prix, String photo, int quantite,Categorie cat,boolean sel) {
	this.idProduit = idProduit;
	this.designation = designation;
	this.description = description;
	this.prix = prix;
	this.photo = photo;
	this.quantite = quantite;
	this.cat=cat;
	this.selectionnee=sel;
}






}
