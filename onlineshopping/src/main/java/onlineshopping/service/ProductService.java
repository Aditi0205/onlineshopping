package onlineshopping.service;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineshopping.dao.ProductRepository;
import onlineshopping.dto.Product;

@Service("productService")
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	private Map<Integer, Product> productMap = new HashMap<>();
	private List<Product> productList = new ArrayList<>();

	public Map<Integer,Product> getProductMap() {
		return productMap;
	}

	public List<Product> getAllProducts() {
		
		productRepository.findAll().forEach(productList::add);
		productList.forEach(product -> {
			productMap.put(product.getId(), product);
		});

		return productList;
	}

	public Product getProductById(int id) {

		return productRepository.findOne(id);
	}

	public boolean saveProduct(Product product) {
		
		try {
			productRepository.save(product);
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();

			return false;
		}

	}

	public boolean deleteProduct(int id) {
		try {
			Product product = productRepository.findOne(id);
			if (isNull(product)) {
				throw new Exception("No product found with provided product id: " + id);
			}
			productRepository.delete(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Product> getProductsByCategory(String categoryName) {
		List<Product> productList = productRepository.findByCategoryName(categoryName);  
		
		return productList;
	}
	
	public List<Product> getRelatedProduct(int id) {
		Product product = productMap.get(id);
		List<Product> relatedProductList = new ArrayList<>();
		relatedProductList = productList.stream().filter(p -> p.getCategory() == product.getCategory()).collect(Collectors.toList());
		relatedProductList.remove(product);
		
		return relatedProductList;
		
	}
  
}
