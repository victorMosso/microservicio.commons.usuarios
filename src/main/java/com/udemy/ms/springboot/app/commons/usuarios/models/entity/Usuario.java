package com.udemy.ms.springboot.app.commons.usuarios.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 60)
	private String username;

	private String password;

	private String nombre;

	private String apellido;

	@Column(unique = true, length = 100)
	private String email;

	private Integer countFails;

	private Boolean enable;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_to_rols", joinColumns = {
			@JoinColumn(name = "usuario_id") }, inverseJoinColumns = @JoinColumn(name = "rol_id"), uniqueConstraints = {
					@UniqueConstraint(columnNames = { "usuario_id", "rol_id" }) })
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Integer getCountFails() {
		return countFails;
	}

	public void setCountFails(Integer countFails) {
		this.countFails = countFails;
	}

	private static final long serialVersionUID = -2696706790196287131L;

}
