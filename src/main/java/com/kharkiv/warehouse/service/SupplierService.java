package com.kharkiv.warehouse.service;

import java.util.List;

import com.kharkiv.warehouse.dto.Supplier;

public interface SupplierService {

    List<Supplier> getAll();

    Supplier get(Integer id);

    Supplier create(Supplier c);

    Supplier update(Supplier c);

    void delete(Integer id);
}
