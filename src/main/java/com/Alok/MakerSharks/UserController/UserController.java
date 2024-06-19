package com.Alok.MakerSharks.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alok.MakerSharks.Dto.LoginDto;
import com.Alok.MakerSharks.Dto.UserDto;
import com.Alok.MakerSharks.Service.UserService;
import com.Alok.MakerSharks.response.LoginResponse;

@RestController
@CrossOrigin
@RequestMapping("/addUser")


public class UserController {
	
	 @Autowired
	   private UserService UserService;
	 

	
	 @PostMapping(path = "/save")
	   public String saveUser(@RequestBody UserDto UserDto)
	   {
	       String id = UserService.addUser(UserDto);
	       return id;
	   }
	 


	   @PostMapping(path = "/login")
	   public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto)
	   {
	       LoginResponse LoginResponse = UserService.loginUser(loginDto);
	       return ResponseEntity.ok(LoginResponse);
	       
	   }


}
