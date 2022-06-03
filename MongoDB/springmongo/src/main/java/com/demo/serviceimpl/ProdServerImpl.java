package com.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.Product;
import com.demo.repo.MyRepo;
import com.demo.service.ProdService;

@Service
public class ProdServerImpl implements ProdService {

	@Autowired
	MyRepo myrepo;

	@Override
	public Product addProduct(Product prod) {

		Product p = myrepo.save(prod);

		return p;
	}

}
