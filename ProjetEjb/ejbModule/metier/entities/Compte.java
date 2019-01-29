package metier.entities;
import java.io.*;
import java.util.Collection;

import javax.persistence.*;;

@Entity
public class Compte implements Serializable{
@Id
private String login;
private String password;

@ManyToOne
@JoinColumn(name="IdClt",nullable=false)
Client c;
public Compte() {
}



public Compte(String login, String password) {
	super();
	this.login = login;
	this.password = password;
}



public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Client getC() {
	return c;
}



public void setC(Client c) {
	this.c = c;
}


@ManyToMany
@JoinTable(name="Role_compte",joinColumns=@JoinColumn(name="idRole"),inverseJoinColumns=@JoinColumn(name="login"))
private Collection<Role> roles;

}
