package messho.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import messho.bean.Customer;
import messho.repository.MyLocalRepository;
import messho.service.CustomerService;
@Service
public class CustomerServiceImp implements CustomerService{
	@Autowired
	MyLocalRepository myLocalRepository;
	@Override
	public Customer saveCustomer(Customer customer) {
		Customer customeradded = myLocalRepository.save(customer);
				return customeradded;
	}
	//added the service

	public List<Customer> getAllListOfCustomers() {
	List<Customer>listOfAllCustomers= myLocalRepository.findAll();
		
		return listOfAllCustomers;
	}

	public Customer updateCustomer(Customer customer,Long id) {
		 myLocalRepository.save(customer);
		 
		return myLocalRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomerList() {
	List<Customer>ListOfCustomers= myLocalRepository.findAll();
		return ListOfCustomers ;
	}

	

	@Override
	public void deleteCustomerById(Long id) {
		myLocalRepository.deleteById(id);
		
	}

}

