package com.test.adressbook.dao;

import java.util.List;

import com.test.adressbook.contact.Contact;

public interface ContactDao {

    List<Contact> getAll();

    Contact getContactById(Integer id);

    Contact createContact(Contact c);

    Contact updateContact(Contact c);

    void deleteContactById(Integer id);

}
