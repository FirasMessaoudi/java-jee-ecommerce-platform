package metier.entities;

public class Item {
private Produits p;
private int q;

public Item() {
	super();
}
public Item(Produits p, int q) {
	super();
	this.p = p;
	this.q = q;
}
public Produits getP() {
	return p;
}
public void setP(Produits p) {
	this.p = p;
}
public int getQ() {
	return q;
}
public void setQ(int q) {
	this.q = q;
}

}
