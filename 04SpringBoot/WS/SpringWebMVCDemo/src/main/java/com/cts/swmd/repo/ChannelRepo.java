package com.cts.swmd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.swmd.entity.Channel;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {

}
