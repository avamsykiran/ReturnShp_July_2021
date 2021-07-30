package com.cts.swmd.model;

import java.time.LocalDate;

public class SubscriptionDetailsForSubscriber {

	private String channelName;
	private LocalDate subscriptionActivationDate;

	public SubscriptionDetailsForSubscriber() {
	}

	public SubscriptionDetailsForSubscriber(String channelName, LocalDate subscriptionActivationDate) {
		super();
		this.channelName = channelName;
		this.subscriptionActivationDate = subscriptionActivationDate;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public LocalDate getSubscriptionActivationDate() {
		return subscriptionActivationDate;
	}

	public void setSubscriptionActivationDate(LocalDate subscriptionActivationDate) {
		this.subscriptionActivationDate = subscriptionActivationDate;
	}

	@Override
	public String toString() {
		return "SubscriptionDetailsForSubscriber [channelName=" + channelName + ", subscriptionActivationDate="
				+ subscriptionActivationDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channelName == null) ? 0 : channelName.hashCode());
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
		SubscriptionDetailsForSubscriber other = (SubscriptionDetailsForSubscriber) obj;
		if (channelName == null) {
			if (other.channelName != null)
				return false;
		} else if (!channelName.equals(other.channelName))
			return false;
		if (subscriptionActivationDate == null) {
			if (other.subscriptionActivationDate != null)
				return false;
		} else if (!subscriptionActivationDate.equals(other.subscriptionActivationDate))
			return false;
		return true;
	}


}
