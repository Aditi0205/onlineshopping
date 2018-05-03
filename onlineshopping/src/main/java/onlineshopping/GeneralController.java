package onlineshopping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import onlineshopping.dto.Product;
import onlineshopping.service.ProductCategoryService;
import onlineshopping.service.ProductService;

@RestController
public class GeneralController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCategoryService productCategoryService;
	
	static private int count = 0;
	
	//private List<Product> productList = new ArrayList<>();
	
	private List<Product> productList = new ArrayList<>();
	


	@RequestMapping("/previous")
	public ModelAndView getPreviousProducts() {
		ModelAndView mv = new ModelAndView("index");
		count -= 6;
		try {
			List<Product> subProduct = productList.subList(count, Math.min(productList.size(), count + 3));
			count += 3;
			mv.addObject("products", subProduct);
			mv.addObject("productCategories", productCategoryService.getAllProductCategories());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Entering the negative side");
		}
		return mv;
	}

	@RequestMapping(value= {"/" , "/home"})
	public ModelAndView getAllProducts() {
		ModelAndView mv = new ModelAndView("index");
		productList = productService.getAllProducts();
		mv.addObject("productCategories", productCategoryService.getAllProductCategories());
		List<Product> subProduct = productList.subList(count, Math.min(productList.size(), count + 3));
		count += 3;
		mv.addObject("products", subProduct);
		return mv;
	}

	@RequestMapping("/next")
	public ModelAndView getNextProducts() {
		ModelAndView mv = new ModelAndView("index");
		try {
			List<Product> subProduct = productList.subList(count, Math.min(productList.size(), count + 3));
			count += 3;
			mv.addObject("productCategories", productCategoryService.getAllProductCategories());
			mv.addObject("products", subProduct);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Crossing the limit");
		}

		return mv;
	}
}
