package local.practice.livescorealertapplication.repository;

import local.practice.livescorealertapplication.model.UserMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMessagesRepository extends JpaRepository<UserMessages, Long> {

	@Query(value = "SELECT MESSAGE FROM USER_MESSAGES WHERE USER_ID = ?", nativeQuery = true)
	List<String> findMessagesByUserId(Long userId);
}
