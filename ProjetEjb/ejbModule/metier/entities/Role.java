package metier.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idRole;
	private String description;
	
	public Role() {
		super();
	}
	public Role(Long idRole, String description) {
		super();
		this.idRole = idRole;
		this.description = description;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
