package com.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/default")
public class DefaultController {

	@GetMapping
	public String defualt() {
		return "Welcome come";
	}
	
}
