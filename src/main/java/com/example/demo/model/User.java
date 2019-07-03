package com.example.demo.model;

public class User {
private int id;
private String name;
private String email;
private String contact;

public User(int id,String name,String email,String contact){
	this.id=id;
	this.name=name;
	this.email=email;
	this.contact=contact;
}
public void setId(int id) {
	this.id=id;
}
public int getId() {
	return id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public void setEmail(String email) {
	this.email=email;
}
public String getEmail() {
	return email;
}

public void setContect(String contact) {
	this.contact=contact;
}
public String getContact() {
	return contact;
}

}
