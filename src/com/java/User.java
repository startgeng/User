package com.java;

public class User {
private int id;
private String name;
private String password;
private String nickName;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public User(int id, String name, String password, String nickName) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.nickName = nickName;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

}
