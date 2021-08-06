package com.cts.srad.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="subscribers")
public class Subscriber implements Serializable {

	@Id
	@Column(name="sub_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subscriberId;
	
	@Column(name="full_name",nullable = false)
	@NotNull(message = "Full Name is a mandate field")
	@NotEmpty(message = "Full Name is a mandate field")
	@NotBlank(message = "Full Name is a mandate field")
	private String fullName;
	
	@Column(name="email",nullable = false,unique = true)
	@NotNull(message = "Email is a mandate field")
	@NotEmpty(message = "Email is a mandate field")
	@NotBlank(message = "Email is a mandate field")
	@Email(message = "A valid email id expected")
	private String emailId;
	
	@Column(name="mob",nullable = false,unique = true)
	@NotNull(message = "Mobile Number is a mandate field")
	@NotEmpty(message = "Mobile Number is a mandate field")
	@NotBlank(message = "Mobile Number is a mandate field")
	@Pattern(regexp = "[1-9][0-9]{9}",message = "Mobile Number is exactly a ten digited number")
	private String mobile;
	
	@Column(name="gen")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subpId.subscriber",cascade = CascadeType.DETACH)
	private Set<Subscription> subscriptions;
	
	public Subscriber() {
		// TODO Auto-generated constructor stub
	}

	public Subscriber(Long subscriberId, String fullName, String emailId, String mobile,
			Set<Subscription> subscriptions,Gender gender) {
		super();
		this.subscriberId = subscriberId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.mobile = mobile;
		this.subscriptions = subscriptions;
		this.gender=gender;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((subscriberId == null) ? 0 : subscriberId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriber other = (Subscriber) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (subscriberId == null) {
			if (other.subscriberId != null)
				return false;
		} else if (!subscriberId.equals(other.subscriberId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscriber [subscriberId=" + subscriberId + ", fullName=" + fullName + ", emailId=" + emailId
				+ ", mobile=" + mobile + "]";
	}
	
	
}
