package com.test.adressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.adressbook.contact.Contact;
import com.test.adressbook.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> getAll() {
        return contactService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contact getById(@PathVariable Integer id) {
        return contactService.getContactById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Contact create(@Valid Contact c) {
        return contactService.createContact(c);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Contact update(@Valid Contact c) {
        return contactService.updateContact(c);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        contactService.deleteContactById(id);
    }
}
