package supfirst.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import supfirst.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where u.email = ?1")
    Optional<User> findOneByEmail(String email);
}
