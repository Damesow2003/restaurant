package com.api.restaurant.modele;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Table(name="login")
@DynamicUpdate
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	public User() {
	}
	public User(String email, String password, String roles) {
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	private String email;
	private String password;
	private String roles;
	@OneToMany(
			cascade = {
					CascadeType.MERGE,
					CascadeType.PERSIST
			},
			fetch = FetchType.LAZY
	)
	@JoinColumn(name="user_id")
	private List<Menu> menus = new ArrayList<Menu>();

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
}
