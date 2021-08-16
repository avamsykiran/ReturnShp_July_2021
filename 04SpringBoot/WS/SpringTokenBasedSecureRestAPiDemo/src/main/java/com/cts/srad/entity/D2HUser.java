package com.cts.srad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class D2HUser implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@Column(name = "email",nullable = false,unique = true)
	@NotNull(message = "Email is a mandate field")
	@NotEmpty(message = "Email is a mandate field")
	@NotBlank(message = "Email is a mandate field")
	@Email(message = "A valid email id expected")
	private String emailId;

	@Column(name = "pwd")
	private String password;

	@Enumerated(EnumType.STRING)
	private D2HUserRole role;

	public D2HUser() {
	}

	public D2HUser(String emailId, String password, D2HUserRole role) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.role = role;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public D2HUserRole getRole() {
		return role;
	}

	public void setRole(D2HUserRole role) {
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "D2HUser [userId=" + userId + ", emailId=" + emailId + ", password=" + password + ", role=" + role + "]";
	}
	
	

}
