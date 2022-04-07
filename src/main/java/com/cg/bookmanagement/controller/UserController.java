package com.cg.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmanagement.entity.User;
import com.cg.bookmanagement.exception.ResourceNotFoundException;
import com.cg.bookmanagement.repository.UserRepository;

@RestController 
@RequestMapping("/user")
public class UserController {
	@Autowired
private UserRepository userRepository;
//get all  Users
	@GetMapping("/users")
	public List< User> getUserList()
	{
		return userRepository.findAll();
	}
	
	//add new user
		@PostMapping("/insertuser")
		public User createUser(@Validated @RequestBody User user)
		{
			return userRepository.save(user);
		}

	//get a user by id
	@GetMapping("/users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer userId)
      throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userId));
      return ResponseEntity.ok().body(user);
  }
	//update a User
	@PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId,
         @Validated @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + userId));

		user.setPassword(userDetails.getPassword());
		user.setRole(userDetails.getRole());
	 
        
        
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable("id") Integer userid) {
		userRepository.deleteById(userid);
	}
}
