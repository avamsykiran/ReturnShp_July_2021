package com.cts.sdd.entity;

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
	@Column(name="subp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subpId;
	
	@ManyToOne
	@JoinColumn(name="subr_id")
	private Subscriber subscriber;
	
	@ManyToOne
	@JoinColumn(name="ch_id")
	private Channel channel;
	
	@Column(name="sad",nullable = false)
	private LocalDate subscriptionActivationDate;
	
	public Subscription() {
		// TODO Auto-generated constructor stub
	}
	
	public Subscription(Long subpId, Subscriber subscriber, Channel channel, LocalDate subscriptionActivationDate) {
		super();
		this.subpId = subpId;
		this.subscriber = subscriber;
		this.channel = channel;
		this.subscriptionActivationDate = subscriptionActivationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((subpId == null) ? 0 : subpId.hashCode());
		result = prime * result + ((subscriber == null) ? 0 : subscriber.hashCode());
		result = prime * result + ((subscriptionActivationDate == null) ? 0 : subscriptionActivationDate.hashCode());
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
		Subscription other = (Subscription) obj;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (subpId == null) {
			if (other.subpId != null)
				return false;
		} else if (!subpId.equals(other.subpId))
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		if (subscriptionActivationDate == null) {
			if (other.subscriptionActivationDate != null)
				return false;
		} else if (!subscriptionActivationDate.equals(other.subscriptionActivationDate))
			return false;
		return true;
	}

	public Long getSubpId() {
		return subpId;
	}

	public void setSubpId(Long subpId) {
		this.subpId = subpId;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public LocalDate getSubscriptionActivationDate() {
		return subscriptionActivationDate;
	}

	public void setSubscriptionActivationDate(LocalDate subscriptionActivationDate) {
		this.subscriptionActivationDate = subscriptionActivationDate;
	}

	@Override
	public int compareTo(Subscription o) {
		return subpId!=null?subpId.compareTo(o.subpId):0;
	}

}
