package com.kharkiv.warehouse.dto;

import static com.kharkiv.warehouse.util.QueryNamesConstants.ProductQueries.DELETE_BY_ID;
import static com.kharkiv.warehouse.util.QueryNamesConstants.ProductQueries.GET_ALL;
import static com.kharkiv.warehouse.util.QueryNamesConstants.ProductQueries.GET_BY_ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({"supplies"})
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
	@Min(value = 0)
	private double price;
	
	@Lob
	@Column
	private String description;
	
	@Column
	private Integer stockAmount = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(Integer stockAmount) {
		this.stockAmount = stockAmount;
	}
	
}
