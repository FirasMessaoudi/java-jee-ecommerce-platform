package metier.entities;
import java.io.*;
import javax.persistence.*;
@Embeddable
public class Lign_comm_Pk implements Serializable {
private long Idcomm,idProduit;

public Lign_comm_Pk() {
	super();
}

public Lign_comm_Pk(long idcomm, long idProduit) {
	super();
	Idcomm = idcomm;
	this.idProduit = idProduit;
}

public long getIdcomm() {
	return Idcomm;
}

public void setIdcomm(long idcomm) {
	Idcomm = idcomm;
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
	result = prime * result + (int) (Idcomm ^ (Idcomm >>> 32));
	result = prime * result + (int) (idProduit ^ (idProduit >>> 32));
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
	Lign_comm_Pk other = (Lign_comm_Pk) obj;
	if (Idcomm != other.Idcomm)
		return false;
	if (idProduit != other.idProduit)
		return false;
	return true;
}


}
