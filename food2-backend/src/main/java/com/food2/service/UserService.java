package com.food2.service;

import com.food2.dto.SignupDto;
import com.food2.entity.User;

public interface UserService {
	User registerSeller(SignupDto dto);
	
	void verifySeller(Long userId, String docUrl);
	
}
