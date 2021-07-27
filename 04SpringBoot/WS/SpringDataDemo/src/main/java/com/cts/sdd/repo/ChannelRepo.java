package com.cts.sdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.sdd.entity.Channel;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {

}
