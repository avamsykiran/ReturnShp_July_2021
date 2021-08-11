package com.cts.srad.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.srad.entity.Subscriber;

public interface SubscriberRepo extends JpaRepository<Subscriber, Long> {

}
