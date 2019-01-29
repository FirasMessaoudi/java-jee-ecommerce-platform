package metier.entities;
import javax.persistence.*;
import java.io.*;
@Embeddable
public class Ligne_Produit_Prom_Pk implements Serializable{
private long idProduit;
private String idprom;

public Ligne_Produit_Prom_Pk() {
	super();
}

public String getIdprom() {
	return idprom;
}

public void setIdprom(String idprom) {
	this.idprom = idprom;
}

public long getIdProduit() {
	return idProduit;
}

public void setIdProduit(long idProduit) {
	this.idProduit = idProduit;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (idProduit ^ (idProduit >>> 32));
	result = prime * result + ((idprom == null) ? 0 : idprom.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Ligne_Produit_Prom_Pk other = (Ligne_Produit_Prom_Pk) obj;
	if (idProduit != other.idProduit)
		return false;
	if (idprom == null) {
		if (other.idprom != null)
			return false;
	} else if (!idprom.equals(other.idprom))
		return false;
	return true;
}

public Ligne_Produit_Prom_Pk(String idprom, long idProduit) {
	super();
	this.idprom = idprom;
	this.idProduit = idProduit;
}

}
