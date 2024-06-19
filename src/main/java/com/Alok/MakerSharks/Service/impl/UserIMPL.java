package com.Alok.MakerSharks.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Alok.MakerSharks.Dto.LoginDto;
import com.Alok.MakerSharks.Dto.UserDto;
import com.Alok.MakerSharks.Entity.User;
import com.Alok.MakerSharks.Repo.UserRepo;
import com.Alok.MakerSharks.Service.UserService;
import com.Alok.MakerSharks.response.LoginResponse;

@Service

public class UserIMPL implements UserService{

	   @Autowired
	   private UserRepo UserRepo;
	   

	   @Autowired
	   private PasswordEncoder passwordEncoder;

	   
	   @Override
	   public String addUser(UserDto userDto) {
		   
		    User user = new User(
		    		
	               userDto.getUserid(),
	               userDto.getUsername(),
	               userDto.getEmail(),
	               
	              this.passwordEncoder.encode(userDto.getPassword())
	       );
		    
	       UserRepo.save(user);
	       return user.getUsername();
	   }
	   
	   UserDto userDto;

	   @Override
	   public LoginResponse  loginUser(LoginDto loginDto) {
	       String msg = "";
	       
	       User user1 = UserRepo.findByEmail(loginDto.getEmail());
	       
	       if (user1 != null) {
	    	   
	           String password = loginDto.getPassword();
	           
	           String encodedPassword = user1.getPassword();
	           
	           Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	           
	           if (isPwdRight) {
	               Optional<User> user = UserRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
	               if (user.isPresent()) {
	            	   
	                   return new LoginResponse("Login Success", true);
	               } else {
	                   return new LoginResponse("Login Failed", false);
	               }
	           } else {
	               return new LoginResponse("password Not Match", false);
	           }
	       }else {
	           return new LoginResponse("Email not exist", false);
	       }
	   }
}

