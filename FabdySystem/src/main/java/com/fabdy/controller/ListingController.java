package com.fabdy.controller;

import com.fabdy.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hussain on 29/7/15.
 */
@Controller
@RequestMapping("/listing")
public class ListingController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/new")
    String create(Model model) {
        model.addAttribute("product", new Product());
        return "listing/new";
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    String save(@ModelAttribute("product") Product product, BindingResult result, Model model) {
        model.addAttribute("newProduct", product);
        return "listing/show";
    }
}
