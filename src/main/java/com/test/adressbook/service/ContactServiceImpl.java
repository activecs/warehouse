package com.test.adressbook.service;

import static com.test.adressbook.util.Constants.CACHE_NAME;
import static com.test.adressbook.util.Constants.CACHE_KEY;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.adressbook.contact.Contact;
import com.test.adressbook.dao.ContactDao;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Transactional(readOnly = true)
    @Cacheable(value = CACHE_NAME, key = CACHE_KEY)
    public List<Contact> getAll() {
        return contactDao.getAll();
    }

    @Transactional(readOnly = true)
    public Contact getContactById(Integer id) {
        return contactDao.getContactById(id);
    }

    @CacheEvict(value = CACHE_NAME, key = CACHE_KEY)
    public Contact createContact(Contact c) {
        return contactDao.createContact(c);
    }

    @CacheEvict(value = CACHE_NAME, key = CACHE_KEY)
    public Contact updateContact(Contact c) {
        return contactDao.updateContact(c);
    }

    @CacheEvict(value = CACHE_NAME, key = CACHE_KEY)
    public void deleteContactById(Integer id) {
        contactDao.deleteContactById(id);
    }

}
