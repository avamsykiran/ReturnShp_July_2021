package com.cts.srad.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.srad.entity.Subscription;
import com.cts.srad.entity.SubscriptionId;
import com.cts.srad.model.SubscriptionDetails;

public interface SubscriptionRepo extends JpaRepository<Subscription, SubscriptionId> {
	
	@Query("SELECT s FROM Subscription s WHERE s.subpId.subscriber.subscriberId=:subId")
	List<Subscription> getAllBySubscriber(Long subId);

	@Query("SELECT s FROM Subscription s WHERE s.subpId.channel.channelId=:chId")
	List<Subscription> getAllByChannel(Long chId);

	@Query("SELECT new com.cts.srad.model.SubscriptionDetails(s.subpId.subscriber.fullName,s.subpId.channel.channelName,s.subpId.channel.monthlyFee,s.subscriptionActivationDate) FROM Subscription s WHERE s.subpId.subscriber.subscriberId=:subId")
	List<SubscriptionDetails> getAllChannelNamesBySubscriber(Long subId);

	@Query("SELECT new com.cts.srad.model.SubscriptionDetails(s.subpId.subscriber.fullName,s.subpId.channel.channelName,s.subpId.channel.monthlyFee,s.subscriptionActivationDate) FROM Subscription s WHERE s.subpId.channel.channelId=:chId")
	List<SubscriptionDetails> getAllSubscriberNamesByChannel(Long chId);

}
