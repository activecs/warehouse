package com.kharkiv.warehouse.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kharkiv.warehouse.service.ProductService;
import com.kharkiv.warehouse.service.SupplierService;

@Controller
@RequestMapping("/supply")
public class SupplyPageController {
	
	@Inject
	private ProductService productService;
	@Inject
	private SupplierService supplierService;
    
    @RequestMapping(value="/page", method = RequestMethod.GET)
    public String openPage(Model model) {
    	model.addAttribute("products", productService.getAll());
    	model.addAttribute("suppliers", supplierService.getAll());
        return "supply";
    }

}
