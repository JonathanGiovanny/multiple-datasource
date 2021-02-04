package com.multidatasource.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multidatasource.test.primary.model.UserEntity;
import com.multidatasource.test.primary.repositories.UserRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final @NonNull UserRepository userRepository;

	public UserEntity saveUser(UserEntity user) {
		return userRepository.save(user);
	}

	public List<UserEntity> getAll() {
		return userRepository.findAll();
	}

}
