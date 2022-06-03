package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Product;
import com.demo.service.ProdService;

@RestController
public class ProdController {

	@Autowired
	ProdService prodSer;

	@PostMapping(value = "/add")
	Product addProduct(@RequestBody Product prod) {

		Product p = prodSer.addProduct(prod);

		return p;

	}

}
