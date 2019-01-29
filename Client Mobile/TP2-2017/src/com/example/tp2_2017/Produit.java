package com.example.tp2_2017;

public class Produit {

	private long idProduit;
	private String designation ;
	private String  description;
	private double prix;
	private int quantité;
	private boolean selection;
	private String  photo;
	public long getId() {
		return idProduit;
	}
	public void setId(long id) {
		this.idProduit = id;
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
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	public boolean isSelection() {
		return selection;
	}
	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Produit(long id, String designation, String description,
			double prix, int quantité, boolean selection, String photo) {
		super();
		this.idProduit = id;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantité = quantité;
		this.selection = selection;
		this.photo = photo;
	}
	public Produit(long id, String designation, String description,
			double prix, int quantité) {
		super();
		this.idProduit = id;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantité = quantité;
	}
	
	
	
}
