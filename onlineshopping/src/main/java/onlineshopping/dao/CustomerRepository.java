package onlineshopping.dao;

import org.springframework.data.repository.CrudRepository;

import onlineshopping.dto.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	public boolean findByEmailAndPassword(String userId, String password);
	public boolean findByEmail(String userId);

}
