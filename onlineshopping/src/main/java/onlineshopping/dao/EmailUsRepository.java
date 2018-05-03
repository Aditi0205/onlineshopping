package onlineshopping.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import onlineshopping.dto.EmailUs;

@Repository
public interface EmailUsRepository extends CrudRepository<EmailUs, String> {

}
