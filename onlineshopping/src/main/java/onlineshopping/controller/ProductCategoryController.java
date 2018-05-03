package onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import onlineshopping.dto.ProductCategory;
import onlineshopping.service.ProductCategoryService;
import onlineshopping.service.ProductService;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<ProductCategory> getAllProductCategories() {
		return productCategoryService.getAllProductCategories();
	}
	
	@RequestMapping(value="/get/{id}" , method= RequestMethod.GET)
	public ProductCategory getProductCategory(@PathVariable("id") int id) {
		return productCategoryService.getProductCategoryById(id);
	}
	
	@RequestMapping(value="/save" , method= RequestMethod.POST)
	public boolean addProductCategory(@RequestBody ProductCategory productCategory) {
		return productCategoryService.addCategory(productCategory);
	}
	
	@RequestMapping(value="/delete/{id}" , method= RequestMethod.PUT)
	public boolean deleteCategory(@PathVariable("id") int id) {
		return productCategoryService.deleteCategory(id);
	}
	
	@RequestMapping("/{categoryName}")
	public ModelAndView getProductsByCategory(@PathVariable("categoryName") String categoryName) {
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("products", productService.getProductsByCategory(categoryName));
		mv.addObject("productCategories",productCategoryService.getAllProductCategories());
		return mv;
	}
	
	
}