package onlineshopping.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import onlineshopping.dto.Subscription;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscription, Integer> {
	
	@Query("SELECT COUNT(e.email) from EmailUs e where e.email = ?1")
	public int findBySubscriberEmailId(String emailId);

}
