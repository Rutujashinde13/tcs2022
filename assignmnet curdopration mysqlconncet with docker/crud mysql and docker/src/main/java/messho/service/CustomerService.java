package messho.service;

import java.util.List;

import messho.bean.Customer;

public interface CustomerService {
	 
	
	List<Customer> getAllListOfCustomers();
	
	List<Customer> getCustomerList();
	

	Customer updateCustomer(Customer customer,Long id);
	
	void deleteCustomerById(Long id);

	Customer saveCustomer(Customer customer);
	
}
