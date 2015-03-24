package com.kharkiv.warehouse.controller.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class SupplyForm {
	
	@NotBlank
	private String date;
	@Min(1)
	private Integer amount;
	private Integer id;
	@Min(1)
	private Integer product;
	@Min(1)
	private Integer supplier;
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Calendar getDate() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date parsedDate = format.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsedDate);
        return calendar;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduct() {
		return product;
	}
	public void setProduct(Integer product) {
		this.product = product;
	}
	public Integer getSupplier() {
		return supplier;
	}
	public void setSupplier(Integer supplier) {
		this.supplier = supplier;
	}
	
	
}
