package com.test.adressbook.contact;

import static com.test.adressbook.util.QueryNamesConstants.ProductQueries.DELETE_BY_ID;
import static com.test.adressbook.util.QueryNamesConstants.ProductQueries.GET_ALL;
import static com.test.adressbook.util.QueryNamesConstants.ProductQueries.GET_BY_ID;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "product")
@NamedQueries(value = { @NamedQuery(name = GET_ALL, query = "SELECT p FROM Product p"),
        @NamedQuery(name = GET_BY_ID, query = "SELECT p FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = DELETE_BY_ID, query = "DELETE FROM Product p WHERE p.id = :id")})
public class Product extends BaseEntity {
	
	private static final long serialVersionUID = 2826989356836520188L;
	
	@Column
	@NotBlank(message = "Product name cannot be empty")
	private String name;
	
	@Column(unique=true, nullable=false)
	@NotBlank(message = "Product SKU cannot be empty and should be unique")
	private String SKU;
	
	@Column
	@NotBlank(message = "Price cannot be empty")
	private BigDecimal price = ZERO;
	
	@Lob
	@Column
	private String description;
	
	@Column
	private Integer stockAmount = 0;
	
	@OneToMany
	private Set<Supply> supplies;
	
}
