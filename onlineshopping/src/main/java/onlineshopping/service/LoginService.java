package onlineshopping.service;

import static java.util.Objects.nonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineshopping.dao.CustomerRepository;
import onlineshopping.dao.SellerRepository;
import onlineshopping.dto.Login;;

@Service
public class LoginService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public boolean customerLogin(Login login) {
		
		return customerRepository.findByEmailAndPassword(login.getUserId(), login.getPassword());
	}
	
	public boolean isCustomerExist(Login login) {
		return customerRepository.findByEmail(login.getUserId());
	}
	
	public boolean sellerLogin(Login login) {
		
		return nonNull(sellerRepository.findByEmailAndPassword(login.getUserId(), login.getPassword())) ;
	}
	
	public boolean isSellerExist(String userId) {
		return nonNull(sellerRepository.findByEmail(userId));
	}
	
	

		
	

}
