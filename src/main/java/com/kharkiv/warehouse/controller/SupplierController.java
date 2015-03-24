package com.kharkiv.warehouse.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kharkiv.warehouse.dto.Supplier;
import com.kharkiv.warehouse.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Inject
    private SupplierService supplierService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Supplier> getAll() {
        return supplierService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Supplier getById(@PathVariable Integer id) {
        return supplierService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public Supplier create(@RequestBody @Valid Supplier p) {
        return supplierService.create(p);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Supplier update(@RequestBody @Valid Supplier p) {
        return supplierService.update(p);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
    	supplierService.delete(id);
    }
}
