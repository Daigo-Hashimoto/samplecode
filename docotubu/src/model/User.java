package model;

import java.io.Serializable;

public class User implements Serializable {
	private String name ;
	private String pass ;

	public User() {}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public String getname() { return name;}

	public String getpass() { return pass;}


}
