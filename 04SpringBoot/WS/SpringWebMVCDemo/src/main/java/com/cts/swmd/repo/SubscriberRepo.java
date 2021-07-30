package com.cts.swmd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.swmd.entity.Subscriber;

public interface SubscriberRepo extends JpaRepository<Subscriber, Long> {

}
