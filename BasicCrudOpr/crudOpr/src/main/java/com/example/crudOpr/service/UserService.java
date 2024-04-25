package com.example.crudOpr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crudOpr.entity.UserEntity;


@Service
public interface UserService {

	List<UserEntity> getAllUsers();

	UserEntity getUserById(Long id);

	UserEntity createUser(UserEntity user);

	void deleteUser(Long id);

	UserEntity updateUser(Long id, String newName, String newPassword, Long newNumber, String newEmail, String newRole);


	
	
}
