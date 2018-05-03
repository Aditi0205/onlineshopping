package onlineshopping.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subscriberId;
	private String subscriberEmailId;

	public Subscription() {

	}

	public Subscription(String subscriberEmailId) {
		super();
		this.subscriberEmailId = subscriberEmailId;
	}

	public String getSubscriberEmailId() {
		return subscriberEmailId;
	}

	public void setSubscriberEmailId(String subscriberEmailId) {
		this.subscriberEmailId = subscriberEmailId;
	}

	public String toString() {
		return "Subcriber-Id: " + subscriberId + "Subsriber-Email-Id: " + subscriberEmailId;
	}

}
