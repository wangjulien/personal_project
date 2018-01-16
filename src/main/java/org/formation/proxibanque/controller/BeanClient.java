package org.formation.proxibanque.controller;

public class BeanClient {
private int id;
private String nom;
private String prenom;
private String motDePasse;
private String login;
public BeanClient(int id, String login) {
	super();
	this.id = id;
	this.login = login;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}



}
