package com.cts.srad.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.srad.entity.Channel;
import com.cts.srad.exception.D2HException;
import com.cts.srad.model.SubscriptionDetails;
import com.cts.srad.service.ChannelService;

@RestController
@CrossOrigin
@RequestMapping("/channels")
public class ChannelController {

	@Autowired
	private ChannelService chService;
	
	@GetMapping
	public ResponseEntity<List<Channel>> getAllChannelsAction() {
		return new ResponseEntity<List<Channel>>(chService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{chId}")
	public ResponseEntity<Channel> getChannelByIdAction(@PathVariable("chId")Long chId) {
		Channel ch = chService.getById(chId);
		return ch!=null?new ResponseEntity<Channel>(ch,HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{chId}/subscriptions")
	public ResponseEntity<List<SubscriptionDetails>> getSubscriptionsAction(@PathVariable(name = "chId")Long channelId) throws D2HException {
		return new ResponseEntity<>(chService.getAllSubscriptionsOf(channelId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Channel> addChannelAction(
			@Valid @RequestBody Channel channel,BindingResult result
			) throws D2HException {
		return saveOrUpdate(channel, result, null);
	}
	
	@PutMapping("/{chId}")
	public ResponseEntity<Channel> saveChannelAction(
			@Valid @RequestBody Channel channel,BindingResult result,
			@PathVariable("chId")Long chId
			) throws D2HException {
		return saveOrUpdate(channel, result, chId);
	}
	
	@DeleteMapping("/{chId}")
	public ResponseEntity<Void> delChannelAction(@PathVariable("chId")Long chId) throws D2HException {
		chService.delete(chId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private ResponseEntity<Channel> saveOrUpdate(Channel channel,BindingResult result,Long chId) throws D2HException{
		ResponseEntity<Channel> response=null;
		
		if(result.hasErrors()) {
			throw new D2HException(result.getAllErrors().stream()
					.map(err -> err.getDefaultMessage())
					.reduce((m1,m2)->m1+";"+m2).orElse("invalid record"));
		}else {
			Channel ch = null;
			if(chId!=null) {
				if(chId==channel.getChannelId()) {
					ch = chService.update(channel);
					response = new ResponseEntity<Channel>(ch, HttpStatus.ACCEPTED);
				}else {
					throw new D2HException("The resource received and the resource intended do not match");
				}
			}else {
				ch =chService.add(channel);
				response = new ResponseEntity<Channel>(ch, HttpStatus.CREATED);
			}
			
		}
		
		return response;
	}
}
