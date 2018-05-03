package onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import onlineshopping.dto.EmailUs;
import onlineshopping.service.EmailUsService;
import onlineshopping.service.SubscriptionService;

@RestController
@RequestMapping(value = "/contactUs")
public class EmailUsController {
	
	@Autowired
	private EmailUsService emailUsService;
	@Autowired
	private SubscriptionService subscriptionService;
	
	@RequestMapping("/")
	public ModelAndView openContactUs() {
		ModelAndView mv = new ModelAndView("contact");
		
		return mv;
		
	}
	
	@RequestMapping(value = "/emailUs", method = RequestMethod.POST)
	public ModelAndView emailUs(@ModelAttribute("emailUs") EmailUs emailUs) {
		
		if (subscriptionService.isSubcriberExist(emailUs.getEmail()) < 1)
			subscriptionService.addSubcriber(emailUs.getEmail());
		
		ModelAndView mv = new ModelAndView("contact");
		mv.addObject("submitted", emailUsService.addEmailUs(emailUs));
		
		return mv;
		
		}
	}
	

