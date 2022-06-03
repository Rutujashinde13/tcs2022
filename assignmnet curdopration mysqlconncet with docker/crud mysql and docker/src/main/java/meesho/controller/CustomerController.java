package meesho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import messho.bean.Customer;
import messho.service.CustomerService;

@RestController
public class CustomerController {
@Autowired
CustomerService customerService;

@PostMapping (value="/addcustomer")
Customer saveCustomer(@RequestBody Customer customer) {
	Customer cust= customerService.saveCustomer(customer);
	return cust;
}


     @GetMapping(value="/veiwallcustomers")
     List<Customer> veiwAllListOfCustomer(){
    	 return customerService.getAllListOfCustomers();
     }
     
     @GetMapping(value="/veiwcustomers")
     List<Customer> veiwListOfCustomer(){
    	 return customerService.getCustomerList();
     }
     
     
     @PutMapping(value="/updatecustomer/{id}")
     Customer updateCustomer(@RequestBody Customer customer,@PathVariable("id") Long id) {
    	 Customer updatecust= customerService.updateCustomer(customer, id);
    	 return updatecust;
     }
     @DeleteMapping(value="/deletecustomer/{id}")
      String deleteCustomerById(@PathVariable("id") Long id) {
         customerService.deleteCustomerById(id);
	     return "Deleted";
     }
     
    
}
     