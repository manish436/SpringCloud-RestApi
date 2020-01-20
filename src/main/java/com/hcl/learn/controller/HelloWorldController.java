package com.hcl.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.learn.domain.HelloWorldBean;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello world!";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world bean!");

	}

	@GetMapping(path = "/hello-world-pathparam/{name}")
	public HelloWorldBean helloWorldBeanPathParam(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world bean %s!", name));
	}
}
