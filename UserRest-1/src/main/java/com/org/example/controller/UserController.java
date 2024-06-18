package com.org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.example.custom_exception.UserNotFoundException;
import com.org.example.dto.ErrorResponce;
import com.org.example.entity.User;
import com.org.example.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
//	@PostMapping("/add")
//	public User registerUser(@RequestBody User user) {//we are sending only one user
//		return userService.create(user);//geting200->ok
//	}
	
	@PostMapping("/add")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		User createdUser = userService.create(user);
		
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);//geting 201->created
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers(){
		try {
			return new ResponseEntity<>(userService.fetchAll(),HttpStatus.OK);
		}catch(Exception e) {
			ErrorResponce errRes = new ErrorResponce("user fetching failed",	e.getMessage());
			
			return new ResponseEntity<>(errRes,HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/getUser/{id}")
	public ResponseEntity<?> fetUserById(@PathVariable Integer id){
		try {
			return ResponseEntity.ok(userService.fetchById(id));
			
		}catch(RuntimeException e) {
			ErrorResponce errRes = new ErrorResponce("Not found" , e.getMessage());
			return new ResponseEntity<>(errRes,HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable int id,@RequestBody User updatedUSer){
		 
		try {
			User existingUser = userService.fetchById(id);
			return ResponseEntity.ok(userService.update(updatedUSer, existingUser));
		}catch(Exception e) {
			return new ResponseEntity<> (new ErrorResponce("USer"
					+ "updattion failed." , e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Integer id){
		try {
			User existingUser = userService.fetchById(id);
			return ResponseEntity.ok(userService.delete(existingUser));
			
		}catch (Exception e) {
			return new ResponseEntity<> (new ErrorResponce("USer"
					+ "updattion failed." , e.getMessage()),HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/getByName/{name}")
	
		
		public ResponseEntity<?> fetchUserByUserName(@PathVariable String name){
			try {
				ResponseEntity res = null;
				User foundUser = userService.fetchUserByUserName(name);
				System.out.println(foundUser);
				if(foundUser == null){
					throw new UserNotFoundException("invalid Username");
				}else{
					res = new ResponseEntity(foundUser, HttpStatus.OK);
				}
				return res;
				
			}catch (Exception e) {
				return new ResponseEntity<> (new ErrorResponce("fetching user by username failed."
						, e.getMessage()),HttpStatus.BAD_REQUEST);
				
			}
		}
}

