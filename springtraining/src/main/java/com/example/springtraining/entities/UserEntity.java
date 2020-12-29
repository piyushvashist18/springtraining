package com.example.springtraining.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(columnDefinition = "serial")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade= {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval=true)
	@JoinColumn(name="user_id")
	private Set<Address> addresses;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	

}
