package com.example.crudOpr.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudOpr.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findById(int id);

}