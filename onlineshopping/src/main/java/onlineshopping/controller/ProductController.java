package onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import onlineshopping.dto.Product;
import onlineshopping.service.ProductCategoryService;
import onlineshopping.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
/*	@Autowired
	private GeneralService generalService;*/

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {

		return productService.getProductById(id);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ModelAndView getProducts() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("products", productService.getAllProducts());
		return mv;

	}

	@RequestMapping(value = "/save" ,method= RequestMethod.POST)
	public void save(@ModelAttribute("product") Product product) {

		productService.saveProduct(product);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id) {

		return productService.deleteProduct(id);
	}
	
	@RequestMapping("/product_details/{id}")
	public ModelAndView viewProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("product_details");
		mv.addObject("product", productService.getProductMap().get(id));
		mv.addObject("relatedProduct", productService.getRelatedProduct(id));
		mv.addObject("productCategories",productCategoryService.getAllProductCategories());
		
		return mv;
	}
}
