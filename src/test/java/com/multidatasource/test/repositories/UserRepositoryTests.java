package com.multidatasource.test.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.multidatasource.test.primary.model.UserEntity;
import com.multidatasource.test.primary.repositories.UserRepository;

@SpringBootTest
@EnableTransactionManagement
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testUser() {
		UserEntity entity = UserEntity.builder()
				.name("User1")
				.description("Desc")
				.build();

		UserEntity user = userRepository.save(entity);

		assertThat(user).isNotNull();
		assertThat(userRepository.findAll()).isNotEmpty();
	}

}
