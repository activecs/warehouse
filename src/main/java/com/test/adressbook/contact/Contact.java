package com.test.adressbook.contact;

import static com.test.adressbook.util.Constants.GET_ALL_CONTANCTS;
import static com.test.adressbook.util.Constants.GET_CONTANCT_BY_ID;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "contacts")
@NamedQueries(value = { @NamedQuery(name = GET_ALL_CONTANCTS, query = "SELECT c FROM Contact c"),
        @NamedQuery(name = GET_CONTANCT_BY_ID, query = "SELECT c FROM Contact c WHERE c.id = :id") })
public class Contact implements Serializable {

    private static final long serialVersionUID = -5241782980751380459L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "First Name cannot be empty")
    @Size(min = 3, max = 15, message = "First Name lenght should be between 3 and 15 characters")
    private String firstName;

    @Column
    @NotNull(message = "Last Name cannot be empty")
    @Size(min = 3, max = 25, message = "Lasr Name lenght should be between 3 and 25 characters")
    private String lastName;

    @Column
    @NotNull(message = "Phone cannot be empty")
    private String phone;

    @Column
    @NotNull(message = "Adress cannot be empty")
    private String adress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName, phone, adress);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Contact))
            return false;
        Contact other = (Contact) obj;
        return Objects.equal(id, other.id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(id).addValue(firstName).addValue(lastName).addValue(phone)
                .addValue(adress).omitNullValues().toString();
    }
}
