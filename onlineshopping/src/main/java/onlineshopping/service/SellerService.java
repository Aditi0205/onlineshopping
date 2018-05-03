package onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineshopping.dao.SellerRepository;
import onlineshopping.dto.Supplier;

@Service
public class SellerService {
 
	@Autowired
	private SellerRepository sellerRepository;
	
	private static String exception;
  
	public String registerSeller(Supplier supplier) {
		
		try {
			sellerRepository.save(supplier);
			return null;
		}catch(Exception ex) {
			exception = ex.getMessage().split("constraint ")[1].substring(1, ex.getMessage().split("constraint ")[1].indexOf("]"));
			
			return exception;
		}
		
	}
	
	public String getException() {
		return exception;
	}
 
}
