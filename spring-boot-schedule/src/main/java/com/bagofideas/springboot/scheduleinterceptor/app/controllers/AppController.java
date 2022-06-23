package com.bagofideas.springboot.scheduleinterceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@Value("${config.schedule.opening}")
	private Integer opening;

	@Value("${config.schedule.closed}")
	private Integer closed;

	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("title", "Welcome to the customer service schedule");
		return "index";
	}

	@GetMapping("/closed")
	public String closed(Model model) {

		StringBuilder message = new StringBuilder("closed, please visit us from ");
		message.append(opening);
		message.append(" and the ");
		message.append(closed);
		message.append(" hrs. Thanks.");

		model.addAttribute("title", "Outside business hours");
		model.addAttribute("message", message);
		return "closed";
	}
}
