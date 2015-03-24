package com.kharkiv.warehouse.controller;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kharkiv.warehouse.controller.form.SupplyForm;
import com.kharkiv.warehouse.dto.Product;
import com.kharkiv.warehouse.dto.Supplier;
import com.kharkiv.warehouse.dto.Supply;
import com.kharkiv.warehouse.service.ProductService;
import com.kharkiv.warehouse.service.SupplierService;
import com.kharkiv.warehouse.service.SupplyService;

@RestController
@RequestMapping("/supply")
public class SupplyController {

    @Inject
    private SupplyService supplyService;
    @Inject
    private ProductService productService;
    @Inject
    private SupplierService supplierService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Supply> getAll() {
        return supplyService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Supply getById(@PathVariable Integer id) {
        return supplyService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Supply create(@Valid SupplyForm form) throws ParseException {
    	Supply supply = new Supply();
    	populateSupplyData(form, supply);
        return supplyService.create(supply);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Supply update(@Valid SupplyForm form) throws ParseException {
    	Supply supply = supplyService.get(form.getId());
    	populateSupplyData(form, supply);
        return supplyService.update(supply);
    }

	private Supply populateSupplyData(SupplyForm form, Supply supply) throws ParseException {
		Product product = productService.get(form.getProduct());
    	Supplier supplier = supplierService.get(form.getSupplier());
    	supply.setProduct(product);
    	supply.setSupplier(supplier);
    	supply.setDate(form.getDate());
    	supply.setAmount(form.getAmount());
		return supply;
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        supplyService.delete(id);
    }
}
