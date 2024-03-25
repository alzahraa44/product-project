package com.example.demo.database.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
private Integer id; 
	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<User> usesr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsesr() {
		return usesr;
	}
	public void setUsesr(List<User> usesr) {
		this.usesr = usesr;
	}
	
	
}
