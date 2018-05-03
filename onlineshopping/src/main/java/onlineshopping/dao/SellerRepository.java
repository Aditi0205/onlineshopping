package onlineshopping.dao;

import org.springframework.data.repository.CrudRepository;

import onlineshopping.dto.Supplier;

public interface SellerRepository extends CrudRepository<Supplier, Integer>{
	
	public Supplier findByEmailAndPassword(String userId, String password);
	public Supplier findByEmail(String userId);

}
