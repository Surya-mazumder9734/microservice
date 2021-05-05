package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class apicontoller {
	@GetMapping("/")
	ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hello This is Api gateway", HttpStatus.OK);
	}

}
