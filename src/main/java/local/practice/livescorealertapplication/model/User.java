package local.practice.livescorealertapplication.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "SUBSCRIBED_TO_SCORE_ALERT")
	private boolean subscribedToScoreAlert;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isSubscribedToScoreAlert() {
		return subscribedToScoreAlert;
	}

	public void setSubscribedToScoreAlert(boolean subscribedToScoreAlert) {
		this.subscribedToScoreAlert = subscribedToScoreAlert;
	}
}
