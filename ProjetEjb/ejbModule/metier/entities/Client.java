package metier.entities;
import java.io.*;
import java.util.Collection;

import javax.persistence.*;
@Entity
@Table(name="client")
public class Client implements Serializable {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long IdClt;
@Column(nullable=false)
private String nom;
private String adresse,email,tel;

@OneToMany(mappedBy="c",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
private Collection<Compte> comptes;

@OneToMany(mappedBy="cl" ,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
private Collection<Commande> commande;

public Long getIdClt() {
	return IdClt;
}
public void setIdClt(Long idClt) {
	IdClt = idClt;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public Collection<Compte> getComptes() {
	return comptes;
}
public void setComptes(Collection<Compte> comptes) {
	this.comptes = comptes;
}
public Collection<Commande> getCommande() {
	return commande;
}
public void setCommande(Collection<Commande> commande) {
	this.commande = commande;
}
public Client(String nom, String adresse, String email, String tel) {
	super();
	this.nom = nom;
	this.adresse = adresse;
	this.email = email;
	this.tel = tel;
}
public Client() {
	super();
}



}
