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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.srad.entity.Subscriber;
import com.cts.srad.exception.D2HException;
import com.cts.srad.service.SubscriberService;

@RestController
@RequestMapping("/subscribers")
public class SubscriberController {

	@Autowired
	private SubscriberService subscriberService;

	@GetMapping
	public ResponseEntity<List<Subscriber>> getAllAction() {
		return new ResponseEntity<>(subscriberService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{subId}")
	public ResponseEntity<Subscriber> getByIdAction(@PathVariable("subId") Long subId) {
		return new ResponseEntity<>(subscriberService.getById(subId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Subscriber> subscriberAddAction(@Valid @RequestBody Subscriber subscriber,
			BindingResult result) throws D2HException {
		return saveOrUpdateAction(subscriber, result, null);
	}

	@PutMapping("/{subId}")
	public ResponseEntity<Subscriber> subscriberSaveAction(@Valid @RequestBody Subscriber subscriber,
			BindingResult result, @PathVariable("subId") Long subId) throws D2HException {
		return saveOrUpdateAction(subscriber, result, null);
	}

	private ResponseEntity<Subscriber> saveOrUpdateAction(Subscriber subscriber, BindingResult result, Long subId) throws D2HException {
		ResponseEntity<Subscriber> response = null;

		if (result.hasErrors()) {
			throw new D2HException(result.getAllErrors().stream().map(err -> err.getDefaultMessage())
					.reduce((m1, m2) -> m1 + ";" + m2).orElse("invalid record"));
		} else {
			Subscriber sub=null;
			if (subId == null) {
				sub = subscriberService.add(subscriber);
				response = new ResponseEntity<Subscriber>(sub, HttpStatus.CREATED);
			} else {
				if(subId==subscriber.getSubscriberId()) {
				sub = subscriberService.update(subscriber);
				response = new ResponseEntity<Subscriber>(sub, HttpStatus.ACCEPTED);
				}else {
					throw new D2HException("Intended Resource and Received resource do not match");
				}
			}
		}

		return response;
	}

}
