package com.Alok.MakerSharks.Service;

import com.Alok.MakerSharks.Dto.LoginDto;
import com.Alok.MakerSharks.Dto.UserDto;

import com.Alok.MakerSharks.response.LoginResponse;

public interface UserService {

	String addUser(UserDto userDto);
	
	LoginResponse loginUser(LoginDto loginDto);

}
