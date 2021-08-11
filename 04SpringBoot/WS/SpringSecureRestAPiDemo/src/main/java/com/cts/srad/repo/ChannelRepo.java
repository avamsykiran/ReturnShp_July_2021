package com.cts.srad.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.srad.entity.Channel;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {

	@Query("SELECT ch FROM Channel ch WHERE ch not in "
			+ "(SELECT s.subpId.channel FROM Subscription s WHERE s.subpId.subscriber.subscriberId=:subscriberId)")
	List<Channel> getChannelsNotSubscribedBy(Long subscriberId);
}
