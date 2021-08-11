package com.cts.srad.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subscriptions")
public class Subscription implements Serializable,Comparable<Subscription>{

	@Id
	private SubscriptionId subpId;
	
	@Column(name="sad",nullable = false)
	private LocalDate subscriptionActivationDate;
	
	public Subscription() {
		// TODO Auto-generated constructor stub
	}

	public Subscription(SubscriptionId subpId, LocalDate subscriptionActivationDate) {
		super();
		this.subpId = subpId;
		this.subscriptionActivationDate = subscriptionActivationDate;
	}

	public SubscriptionId getSubpId() {
		return subpId;
	}

	public void setSubpId(SubscriptionId subpId) {
		this.subpId = subpId;
	}

	public LocalDate getSubscriptionActivationDate() {
		return subscriptionActivationDate;
	}

	public void setSubscriptionActivationDate(LocalDate subscriptionActivationDate) {
		this.subscriptionActivationDate = subscriptionActivationDate;
	}

	@Override
	public int compareTo(Subscription o) {
		return subpId.compareTo(o.subpId);
	}

}
