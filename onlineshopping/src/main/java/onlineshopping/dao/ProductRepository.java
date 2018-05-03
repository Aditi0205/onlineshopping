package onlineshopping.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import onlineshopping.dto.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	//@Query("SELECT p FROM Product p WHERE p.categoryId = (SELECT pc.id FROM ProductCategory pc WHERE pc.name = :categoryName) order by p.price")
	public List<Product> findByCategoryName(String categoryName);
}
