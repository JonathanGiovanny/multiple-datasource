package com.multidatasource.test.secondary.model;

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
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = -8756083028265070729L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_product")
	@SequenceGenerator(name="seq_product", sequenceName = "seq_product", allocationSize = 1)
	private Long id;

	private String name;

	private String description;

}
