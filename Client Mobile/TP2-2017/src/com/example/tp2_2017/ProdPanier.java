package com.example.tp2_2017;
import java.io.Serializable;
import java.util.*;
public class ProdPanier implements Serializable {
public Long id;	
public  String item;
public  double prix;
public  int qte;

public ProdPanier(Long id,String item, double prix, int qte) {
	super();
	this.id=id;
	this.item = item;
	this.prix = prix;
	this.qte = qte;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public  String getItem() {
	return item;
}
public  void setItem(String item) {
	this.item = item;
}
public  double getPrix() {
	return prix;
}
public  void setPrix(double prix) {
	this.prix = prix;
}
public  int getQte() {
	return qte;
}
public void setQte(int qte) {
	this.qte = qte;
}


}
