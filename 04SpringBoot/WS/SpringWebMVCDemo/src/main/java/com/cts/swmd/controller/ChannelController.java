package com.cts.swmd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmd.entity.Channel;
import com.cts.swmd.service.ChannelService;

@Controller
@RequestMapping("/channels")
public class ChannelController {

	@Autowired
	private ChannelService chService;
	
	@GetMapping({"","/","/home"})
	public ModelAndView channelsHomeAction() {
		return new ModelAndView("channels/home-page","channels",chService.getAll());
	}
	
	@GetMapping("/add")
	public ModelAndView channelsAddFormAction() {
		return new ModelAndView("channels/channel-form-page","channel",new Channel());
	}
	
	@PostMapping("/add")
	public ModelAndView channelsAddFormSubmitionAction(
			@Valid @ModelAttribute("channel")Channel channel,BindingResult result
			) {
		ModelAndView mv=null;
		
		if(result.hasErrors()) {
			mv=new ModelAndView("channels/channel-form-page","channel",channel);
		}else {
			chService.add(channel);
			mv = new ModelAndView("redirect:/channels");
		}
		
		return mv;
	}
}
