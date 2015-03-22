package com.test.adressbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductPageController {

    
    @RequestMapping(value="/page", method = RequestMethod.GET)
    public String openPage() {
        return "product";
    }

}
