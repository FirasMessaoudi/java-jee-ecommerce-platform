package metier.entities;
import java.io.*;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="commande")
public class Commande implements Serializable {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long Idcomm;
@Column(nullable=false)
private Date dateCommande;
private String modepaiement;

@OneToMany(mappedBy="commande")
private Collection<Lign_Comm> products;

@ManyToOne
@JoinColumn(name="IdClt",nullable=false)
Client cl;


public Long getIdcomm() {
	return Idcomm;
}
public Commande() {
	super();
}
public void setIdcomm(Long idcomm) {
	Idcomm = idcomm;
}
public Date getDateCommande() {
	return dateCommande;
}
public void setDateCommande(Date dateCommande) {
	this.dateCommande = dateCommande;
}
public String getModepaiement() {
	return modepaiement;
}
public void setModepaiement(String modepaiement) {
	this.modepaiement = modepaiement;
}
public Collection<Lign_Comm> getProducts() {
	return products;
}
public void setProducts(Collection<Lign_Comm> products) {
	this.products = products;
}
public Client getCl() {
	return cl;
}
public void setCl(Client cl) {
	this.cl = cl;
}
public Commande( Date dateCommande, String modepaiement) {
	super();
	this.dateCommande = dateCommande;
	this.modepaiement = modepaiement;
}




}
