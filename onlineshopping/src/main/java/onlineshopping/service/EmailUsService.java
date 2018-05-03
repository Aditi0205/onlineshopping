package onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineshopping.dao.EmailUsRepository;
import onlineshopping.dto.EmailUs;

@Service("EmailUsService")
public class EmailUsService {

	@Autowired
	private EmailUsRepository emailUsRepository;

	public boolean addEmailUs(EmailUs emailUs) {
		try {
			emailUsRepository.save(emailUs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
