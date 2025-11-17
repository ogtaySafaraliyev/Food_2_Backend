package com.food2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.food2.dto.SignupDto;
import com.food2.entity.Role;
import com.food2.entity.User;
import com.food2.repository.RoleRepository;
import com.food2.repository.UserRepository;
import com.food2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerSeller(SignupDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setCompanyName(dto.getCompanyName());
        user.setAddress(dto.getAddress());
        user.setContactInfo(dto.getContactInfo());
        // seller role
        Role sellerRole = roleRepository.findByName("ROLE_SELLER")
            .orElseThrow(() -> new RuntimeException("Seller role not found"));
        user.getRoles().add(sellerRole);
        return userRepository.save(user);
    }

    public void verifySeller(Long userId, String docUrl) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setIsVerified(true);
        user.setVerificationDocumentUrl(docUrl);
        userRepository.save(user);
    }

    // other methods: register buyer, find by email, etc.
}

