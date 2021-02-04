package com.multidatasource.test.primary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidatasource.test.primary.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
