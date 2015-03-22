package com.test.adressbook.contact;

import static com.test.adressbook.util.QueryNamesConstants.SupplyQueries.DELETE_BY_ID;
import static com.test.adressbook.util.QueryNamesConstants.SupplyQueries.GET_ALL;
import static com.test.adressbook.util.QueryNamesConstants.SupplyQueries.GET_BY_ID;

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
	
	@Column(nullable=false)
	private Integer amount;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	

}
