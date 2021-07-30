package com.cts.swmd.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SubscriptionId implements Serializable,Comparable<SubscriptionId> {

	@ManyToOne
	@JoinColumn(name="sub_id")
	private Subscriber subscriber;
	
	@ManyToOne
	@JoinColumn(name="ch_id")
	private Channel channel;
	
	public SubscriptionId() {
		
	}

	public SubscriptionId(Subscriber subscriber, Channel channel) {
		super();
		this.subscriber = subscriber;
		this.channel = channel;
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

	@Override
	public String toString() {
		return "SubscriptionId [subscriber=" + subscriber.getSubscriberId() + ", channel=" + channel.getChannelId() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((subscriber == null) ? 0 : subscriber.hashCode());
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
		SubscriptionId other = (SubscriptionId) obj;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		return true;
	}

	@Override
	public int compareTo(SubscriptionId o) {
		int c = this.subscriber.getSubscriberId().compareTo(o.subscriber.getSubscriberId());
		if(c==0) {
			c = this.channel.getChannelId().compareTo(o.channel.getChannelId());
		}
		return c;
	}
}
