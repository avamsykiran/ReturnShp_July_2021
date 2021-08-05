package com.cts.srad.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="channels")
public class Channel implements Comparable<Channel>,Serializable{

	@Id
	@Column(name="ch_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long channelId;
	
	@Column(name="ch_name",nullable = false,unique = true)
	@NotNull(message = "Channel Name is a mandate field")
	@NotEmpty(message = "Channel Name is a mandate field")
	@NotBlank(message = "Channel Name is a mandate field")
	private String channelName;
	
	@Column(name="ch_month_fee",nullable = false)
	@NotNull(message = "Monthly Fee is a mandate field")
	@Min(value = 0,message = "Monthly Fee can not be negative")
	private Double monthlyFee;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subpId.channel")
	private Set<Subscription> subscriptions;

	
	public Channel() {
		
	}

	public Channel(Long channelId, String channelName, Double monthlyFee) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.monthlyFee = monthlyFee;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(Double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName=" + channelName + ", monthlyFee=" + monthlyFee + "]";
	}

	@Override
	public int compareTo(Channel o) {
		return this.channelId!=null? this.channelId.compareTo(o.channelId):this.channelName.compareTo(o.channelName);
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
		result = prime * result + ((channelId == null) ? 0 : channelId.hashCode());
		result = prime * result + ((channelName == null) ? 0 : channelName.hashCode());
		result = prime * result + ((monthlyFee == null) ? 0 : monthlyFee.hashCode());
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
		Channel other = (Channel) obj;
		if (channelId == null) {
			if (other.channelId != null)
				return false;
		} else if (!channelId.equals(other.channelId))
			return false;
		if (channelName == null) {
			if (other.channelName != null)
				return false;
		} else if (!channelName.equals(other.channelName))
			return false;
		if (monthlyFee == null) {
			if (other.monthlyFee != null)
				return false;
		} else if (!monthlyFee.equals(other.monthlyFee))
			return false;
		return true;
	}
	
	
	
}
