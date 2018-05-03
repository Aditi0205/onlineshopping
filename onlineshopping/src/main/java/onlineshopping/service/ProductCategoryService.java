package onlineshopping.service;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.nonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineshopping.dao.ProductCategoryRepository;
import onlineshopping.dto.ProductCategory;

@Service
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	public List<ProductCategory> getAllProductCategories() {

		List<ProductCategory> productCategoryList = new ArrayList<>();
		productCategoryRepository.findAll().forEach(productCategoryList::add);

		return productCategoryList;
	}

	public ProductCategory getProductCategoryById(int id) {

		return productCategoryRepository.findOne(id);
	}

	public boolean addCategory(ProductCategory category) {
		try {
			productCategoryRepository.save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteCategory(int id) {
		
		try{
			ProductCategory category = productCategoryRepository.findOne(id);
			if(nonNull(category)) {
			category.setActive(false);
			productCategoryRepository.save(category);
			return true;
		}
		else
			throw new Exception("No ProductCategory found with id : " + id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
