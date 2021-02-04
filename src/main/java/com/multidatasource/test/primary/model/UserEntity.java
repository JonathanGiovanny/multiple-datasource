package com.multidatasource.test.primary.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 639696500400709373L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_user")
	@SequenceGenerator(name="seq_user", sequenceName = "seq_user", allocationSize = 1)
	private Long id;

	private String name;

	private String description;

}
