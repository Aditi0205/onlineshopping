/*package onlineshopping.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineshopping.dao.ProductRepository;
import onlineshopping.dto.Product;

@Service
public class GeneralService {

	@Autowired
	private ProductRepository productRepository;
	
	private Map<Integer, Product> productMap = new HashMap<>();

	public Map<Integer,Product> getProductMap() {
		return productMap;
	}
	
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<>();
		productRepository.findAll().forEach(productList::add);
		productList.forEach(product -> {
			productMap.put(product.getId(), product);
		});
		return productList;
	}


	
}
*/