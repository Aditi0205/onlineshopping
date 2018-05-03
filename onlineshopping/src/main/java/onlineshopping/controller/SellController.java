package onlineshopping.controller;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import onlineshopping.dto.Login;
import onlineshopping.dto.Supplier;
import onlineshopping.service.LoginService;
import onlineshopping.service.SellerService;

@RestController
public class SellController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping("/sell")
	public ModelAndView getSalePage() {
		ModelAndView mv = new ModelAndView("sell");
		
		return mv;
	}
	
	@RequestMapping(value = "/sellerLogin", method = RequestMethod.POST)
	public ModelAndView sellerLogin(@ModelAttribute("supplierLogin") Login login) {
		ModelAndView mv = new ModelAndView();
		if (loginService.isSellerExist(login.getUserId())) {
			if (loginService.sellerLogin(login)) {
				mv.setViewName("supplierHome");
			} else {
				mv.addObject("supplierLoginResult", "true");
				mv.setViewName("sell");
			}
		}
		return mv;
	}
	
	
	@RequestMapping(value="/seller/register")
	public ModelAndView sellerRegister() {
		ModelAndView mv = new ModelAndView("registerSeller");
		mv.addObject("supplierStatus","null");
		mv.addObject("supplier",new Supplier());
		return mv;
	}
	
	@RequestMapping(value="/seller/register/submit", method = RequestMethod.POST)
	public ModelAndView sellerRegisterSubmit(@ModelAttribute("supplierRegister") Supplier supplier) {
		ModelAndView mv = new ModelAndView();
		
		if(isNull(sellerService.registerSeller(supplier))) {
			mv.setViewName("sell");
		
		}
		
		else {
			mv.addObject("supplierStatus", sellerService.getException());
			mv.setViewName("registerSeller");
			mv.addObject("supplier", supplier);
		}
		return mv;
		
		
	}
}
