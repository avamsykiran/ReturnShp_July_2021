package com.cts.swmd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.swmd.entity.Subscription;
import com.cts.swmd.entity.SubscriptionId;
import com.cts.swmd.model.SubscriptionDetailsForSubscriber;

public interface SubscriptionRepo extends JpaRepository<Subscription, SubscriptionId> {
	
	@Query("SELECT s FROM Subscription s WHERE s.subpId.subscriber.subscriberId=:subId")
	List<Subscription> getAllBySubscriber(Long subId);

	@Query("SELECT s FROM Subscription s WHERE s.subpId.channel.channelId=:chId")
	List<Subscription> getAllByChannel(Long chId);

	@Query("SELECT new com.cts.swmd.model.SubscriptionDetailsForSubscriber(s.subpId.channel.channelName,s.subscriptionActivationDate) FROM Subscription s WHERE s.subpId.subscriber.subscriberId=:subId")
	List<SubscriptionDetailsForSubscriber> getAllChannelNamesBySubscriber(Long subId);

}
