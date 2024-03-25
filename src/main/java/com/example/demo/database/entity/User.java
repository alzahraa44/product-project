package com.example.demo.database.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
@Id
@GeneratedValue
private Integer id;
private String firstName;
private String lastName;
private String email;
private String password;
@ManyToMany
@JoinTable(name="user-role",
joinColumns = {@JoinColumn(name="USER-ID",referencedColumnName = "ID")},
inverseJoinColumns= {@JoinColumn(name="ROLE-ID",referencedColumnName = "ID")}
)
private List<Role> roles;

public User(User user) {
	super();
	this.firstName = user.getFirstName() ;
	this.lastName = user.getLastName();
	this.email = user.getEmail();
	this.password = user.getPassword();
	this.roles = user.getRoles();
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public List<Role> getRoles() {
	return roles;
}

public void setRoles(List<Role> roles) {
	this.roles = roles;
}





}
