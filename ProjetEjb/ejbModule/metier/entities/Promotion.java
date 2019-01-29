package metier.entities;
import java.io.*;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table (name="promotion")
public class Promotion implements Serializable  {
@Id
//@GeneratedValue(strategy =GenerationType.IDENTITY)
private String idprom;
@Column(nullable=false)
private Date datedebut;
@Column(nullable=false)
private double pourcentage;
@Column(nullable=false)
private Date datefin;

@OneToMany(mappedBy="prom")
private Collection<Ligne_Produit_Prom> prod;

/*@ManyToMany
@JoinTable(name="Ligne_Produit_Promotion",joinColumns=@JoinColumn(name="idProduit"),inverseJoinColumns=@JoinColumn(name="idprom"))
private Collection<Produits> prdts;*/

public String getIdprom() {
	return idprom;
}

public Promotion() {
	super();
}

public void setIdprom(String idprom) {
	this.idprom = idprom;
}
public Date getDatedebut() {
	return datedebut;
}
public void setDatedebut(Date datedebut) {
	this.datedebut = datedebut;
}
public Date getDatefin() {
	return datefin;
}
public void setDatefin(Date datefin) {
	this.datefin = datefin;
	
}

public double getPourcentage() {
	return pourcentage;
}

public void setPourcentage(double pourcentage) {
	this.pourcentage = pourcentage;
}

public Promotion(String idprom,Date date, double pourcentage, Date date2) {
	super();
	this.idprom=idprom;
	this.datedebut = date;
	this.pourcentage = pourcentage;
	this.datefin =  date2;
}

public Collection<Ligne_Produit_Prom> getProd() {
	return prod;
}

public void setProd(Collection<Ligne_Produit_Prom> prod) {
	this.prod = prod;
}


}
