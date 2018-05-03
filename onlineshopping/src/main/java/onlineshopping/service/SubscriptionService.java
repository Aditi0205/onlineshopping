package onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineshopping.dao.SubscriberRepository;
import onlineshopping.dto.Subscription;

@Service
public class SubscriptionService {

	@Autowired
	private SubscriberRepository subscriptionRepository;

	public void addSubcriber(String emailId) {
		Subscription obj = new Subscription(emailId);
		subscriptionRepository.save(obj);
	}

	public int isSubcriberExist(String emailId) {
		try {
			
			return subscriptionRepository.findBySubscriberEmailId(emailId);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
