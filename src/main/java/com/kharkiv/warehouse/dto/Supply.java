package com.kharkiv.warehouse.dto;

import static com.kharkiv.warehouse.util.QueryNamesConstants.SupplyQueries.DELETE_BY_ID;
import static com.kharkiv.warehouse.util.QueryNamesConstants.SupplyQueries.GET_ALL;
import static com.kharkiv.warehouse.util.QueryNamesConstants.SupplyQueries.GET_BY_ID;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kharkiv.warehouse.controller.serializer.CalendarDeserializer;
import com.kharkiv.warehouse.controller.serializer.CalendarSerializer;

@Entity
@DynamicInsert
@Table(name = "supply")
@NamedQueries(value = { @NamedQuery(name = GET_ALL, query = "SELECT s FROM Supply s"),
        @NamedQuery(name = GET_BY_ID, query = "SELECT s FROM Supply s WHERE s.id = :id"),
        @NamedQuery(name = DELETE_BY_ID, query = "DELETE FROM Supply s WHERE s.id = :id")})
public class Supply extends BaseEntity {

	private static final long serialVersionUID = 2567887392387424274L;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Supplier supplier;
	
	@Column(nullable=false)
	private Integer amount;
	
	@Column(nullable=false)
	@JsonDeserialize(using = CalendarDeserializer.class)
	@JsonSerialize(using = CalendarSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
}
