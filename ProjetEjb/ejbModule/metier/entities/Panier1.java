package metier.entities;
import java.util.*;
import java.io.*;
public class Panier1 implements Serializable {
private Map<Long, Lign_Comm> items=new HashMap<Long,Lign_Comm>();
public void addItem(Produits p,int q) {
	if(items.get(p.getIdProduit())!=null) {
		Lign_Comm lc=new Lign_Comm();
		lc.setProduit(p);
		lc.setQuantite(q);
		lc.setPrix(p.getPrix());
	}
		else {
			Lign_Comm l=items.get(p.getIdProduit());
			l.setQuantite(l.getQuantite()+q);
			
		}
	
}
public Collection<Lign_Comm> getItems() {
	return items.values();
}
public int getSize() {
	return items.size();
}
public double getTotal() {
	double total=0;
	for(Lign_Comm lc:items.values())
		total+=lc.getPrix()*lc.getQuantite();
	return total;
}
public void deleteItem(Long id_produit) {
	items.remove(id_produit);
}


}
