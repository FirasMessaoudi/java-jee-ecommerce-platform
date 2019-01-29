package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
@Entity
public class Categorie implements Serializable{
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long idCategorie;
@Column(nullable=false)
private String NomCategorie ;
private String photo;
private String Description;

@OneToMany(mappedBy="cat",fetch=FetchType.LAZY)
private Collection<Produits> produits;

public Categorie() {
	super();
}
public Long getIdCategorie() {
	return idCategorie;
}
public void setIdCategorie(Long idCategorie) {
	this.idCategorie = idCategorie;
}
public String getNomCategorie() {
	return NomCategorie;
}
public void setNomCategorie(String nomCategorie) {
	NomCategorie = nomCategorie;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public Categorie(String nomCategorie, String description) {
	super();
	NomCategorie = nomCategorie;
	Description = description;
}
public Categorie(Long idCategorie, String nomCategorie, String description) {
	super();
	this.idCategorie = idCategorie;
	NomCategorie = nomCategorie;
	Description = description;
}




}
