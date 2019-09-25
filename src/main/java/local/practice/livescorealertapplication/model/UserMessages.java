package local.practice.livescorealertapplication.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_MESSAGES")
public class UserMessages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USER_ID")
	private Long userId;
	@Column(name = "RECEIVED_TIME")
	private LocalDateTime receivedTime;
	@Column(name = "MESSAGE")
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDateTime getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(LocalDateTime receivedTime) {
		this.receivedTime = receivedTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
