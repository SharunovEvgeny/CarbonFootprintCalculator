package com.carbonfootprintcalculator.Controllers;

import com.carbonfootprintcalculator.entities.User;
import com.carbonfootprintcalculator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
	@RequestMapping(value = "/api/users")
	public class UserController {
		@Autowired
		UserService userService;

		@GetMapping(value = "/getAll")
		public ResponseEntity<List<User>> getAllUser() {
			List<User> users = userService.findAll();
			return new ResponseEntity<>(users, HttpStatus.OK);
		}

		@GetMapping(value = "/getByUsername/{username}")
		public ResponseEntity<User> getByUsername(@PathVariable String username) {
			Optional<User> user = userService.findByUsername(username);
			return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
							       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
		}

		@PostMapping(value = "/createUser")
		public ResponseEntity<User> createUser(@RequestBody User user) {
			Optional<User> userOptional = userService.createUser(user);
			return userOptional
							       .map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
							       .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
		}

		@PutMapping(value = "/updateUserById/{id}")
		public ResponseEntity<User> updateUser(
						@PathVariable(name = "id") long id, @RequestBody User user) {
			final Optional<User> updateUser = userService.updateUser(id, user);
			return updateUser
							       .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
							       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
		}

		@DeleteMapping(value = "/deleteUserByUsername/{username}")
		public ResponseEntity<String> deleteByUsername(@PathVariable String username) {
			if (userService.deleteByUsername(username)) {
				return new ResponseEntity<>(username, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

