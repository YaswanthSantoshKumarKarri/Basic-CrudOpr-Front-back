package com.example.crudOpr.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudOpr.entity.UserEntity;
import com.example.crudOpr.repo.UserRepo;
import com.example.crudOpr.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired(required = true)
    private UserRepo userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

	@Override
	public UserEntity updateUser(Long id, String newName, String newPassword, Long newNumber, String newEmail, String newRole) {
	        Optional<UserEntity> optionalUser = userRepository.findById(id);
	        if (optionalUser.isPresent()) {
	        	UserEntity user = optionalUser.get();
	            user.setName(newName);
	            user.setPassword(newPassword);
	            user.setNumber(newNumber);
	            user.setEmail(newEmail);
	            user.setRole(newRole);
	            return userRepository.save(user);
	        } else {
	            throw new RuntimeException("User not found with id: " + id);
	        }
	    
	}
}
