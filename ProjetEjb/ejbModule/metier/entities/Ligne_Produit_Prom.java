package metier.entities;
import javax.persistence.*;
import java.io.*;
@Entity
public class Ligne_Produit_Prom implements Serializable {
@EmbeddedId 
private Ligne_Produit_Prom_Pk Id;

@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name ="idProduit",updatable = false, insertable = false, referencedColumnName = "idProduit")
private Produits produitProm;

@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name ="idprom",updatable = false, insertable = false, referencedColumnName = "idprom")
private Promotion prom;


public Ligne_Produit_Prom() {
	super();
}

public Ligne_Produit_Prom_Pk getId() {
	return Id;
}

public void setId(Ligne_Produit_Prom_Pk id) {
	Id = id;
}

public Produits getProduitProm() {
	return produitProm;
}

public void setProduitProm(Produits produitProm) {
	this.produitProm = produitProm;
}

public Promotion getProm() {
	return prom;
}

public void setProm(Promotion prom) {
	this.prom = prom;
}

public Ligne_Produit_Prom(Ligne_Produit_Prom_Pk id) {
	super();
	Id = id;
}




}
