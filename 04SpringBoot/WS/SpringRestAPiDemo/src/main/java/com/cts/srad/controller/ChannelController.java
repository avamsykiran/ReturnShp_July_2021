package com.cts.srad.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.srad.entity.Channel;
import com.cts.srad.exception.D2HException;
import com.cts.srad.service.ChannelService;

@RestController
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
	
	@PostMapping
	public ResponseEntity<Channel> saveChannelAction(
			@Valid @RequestBody Channel channel,BindingResult result
			) throws D2HException {
		ResponseEntity<Channel> response=null;
		
		if(result.hasErrors()) {
			throw new D2HException(result.getAllErrors().stream()
					.map(err -> err.getDefaultMessage())
					.reduce((m1,m2)->m1+";"+m2).orElse("invalid record"));
		}else {
			Channel ch = chService.add(channel);
			response = new ResponseEntity<Channel>(ch, HttpStatus.CREATED);
		}
		
		return response;
	}
}
