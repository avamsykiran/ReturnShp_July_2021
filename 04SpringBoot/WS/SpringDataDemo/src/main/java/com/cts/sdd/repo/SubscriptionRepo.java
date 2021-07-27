package com.cts.sdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sdd.entity.Subscription;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

}
