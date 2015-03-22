package com.test.adressbook.contact;

import static com.test.adressbook.util.QueryNamesConstants.SupplierQueries.DELETE_BY_ID;
import static com.test.adressbook.util.QueryNamesConstants.SupplierQueries.GET_ALL;
import static com.test.adressbook.util.QueryNamesConstants.SupplierQueries.GET_BY_ID;
import static com.test.adressbook.util.QueryNamesConstants.SupplierQueries.GET_BY_NAME_AND_SURNAME;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@DynamicInsert
@Table(name = "supplier")
@NamedQueries(value = { @NamedQuery(name = GET_ALL, query = "SELECT s FROM Supplier s"),
        @NamedQuery(name = GET_BY_ID, query = "SELECT s FROM Supplier s WHERE s.id = :id"),
        @NamedQuery(name = GET_BY_NAME_AND_SURNAME, query = "SELECT s FROM Supplier s WHERE s.name = :name AND s.surname = :surname"),
        @NamedQuery(name = DELETE_BY_ID, query = "DELETE FROM Supplier s WHERE s.id = :id")})
public class Supplier extends BaseEntity{

    private static final long serialVersionUID = -5766469760606469192L;
    
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Supplier code cannot be empty")
    private String code;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String surname;
    
    @Embedded
    private Location address;
    
        
}
