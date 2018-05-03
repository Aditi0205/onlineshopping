package onlineshopping.dao;

import org.springframework.data.repository.CrudRepository;

import onlineshopping.dto.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer>{
	
}
