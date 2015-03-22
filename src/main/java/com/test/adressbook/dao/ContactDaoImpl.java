package com.test.adressbook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.test.adressbook.contact.Contact;
import com.test.adressbook.util.Constants;

@Repository
public class ContactDaoImpl implements ContactDao {

    private static final String DELETE_CONTACT_QUERY = "DELETE FROM Contact c where c.id = :id";

    @PersistenceContext
    private EntityManager em;

    public List<Contact> getAll() {
        TypedQuery<Contact> query = em.createNamedQuery(Constants.GET_ALL_CONTANCTS, Contact.class);
        return query.getResultList();
    }

    public Contact getContactById(Integer id) {
        TypedQuery<Contact> query = em.createNamedQuery(Constants.GET_CONTANCT_BY_ID, Contact.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public Contact createContact(Contact c) {
        em.persist(c);
        em.flush();
        return c;
    }

    public Contact updateContact(Contact c) {
        return em.merge(c);
    }

    public void deleteContactById(Integer id) {
        Query query = em.createQuery(DELETE_CONTACT_QUERY);
        query.setParameter("id", id).executeUpdate();
    }

}
