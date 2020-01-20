package com.hcl.learn.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hcl.learn.domain.User;
import com.hcl.learn.exception.UserNotFoundException;
import com.hcl.learn.service.UserDaoService;

@RestController
public class UserResourceController {

	@Autowired
	UserDaoService userDaoService;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = userDaoService.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);

		EntityModel<User> userModel = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		userModel.add(linkTo.withRel("all-users"));

		return userModel;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteById(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
	}

}
