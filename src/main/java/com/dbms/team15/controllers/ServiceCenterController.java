package com.dbms.team15.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.team15.models.ServiceCenter;

@RestController
public class ServiceCenterController {

	private static final String template = "Address: %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public ServiceCenter greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new ServiceCenter(counter.incrementAndGet(), String.format(template, name), "test", 1, 1);
	}
}