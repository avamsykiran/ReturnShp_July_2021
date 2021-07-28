package com.cts.sdd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.sdd.entity.Subscription;
import com.cts.sdd.entity.SubscriptionDetailsForSubscriber;
import com.cts.sdd.entity.SubscriptionId;

public interface SubscriptionRepo extends JpaRepository<Subscription, SubscriptionId> {
	
	@Query("SELECT s FROM Subscription s WHERE s.subpId.subscriber.subscriberId=:subId")
	List<Subscription> getAllBySubscriber(Long subId);

	@Query("SELECT s FROM Subscription s WHERE s.subpId.channel.channelId=:chId")
	List<Subscription> getAllByChannel(Long chId);

	@Query("SELECT s.subpId.channel.channelName,s.subscriptionActivationDate FROM Subscription s WHERE s.subpId.subscriber.subscriberId=:subId")
	List<SubscriptionDetailsForSubscriber> getAllChannelNamesBySubscriber(Long subId);

}
