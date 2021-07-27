package com.cts.sdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sdd.entity.Subscriber;

public interface SubscriberRepo extends JpaRepository<Subscriber, Long> {

}
