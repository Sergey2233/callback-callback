package supfirst.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import supfirst.entity.Button;
import supfirst.entity.User;

public interface ButtonRepository extends JpaRepository<Button,Long> {
	/**
	 * find  one button by id user 
	 * @param user User
	 * @return Button
	 */
	@Query("select b from Button b where b.user = ?1")
    Optional<Button> findOneUser(User user);
	/**
	 * find one button by domain website
	 * @param domain  
	 * @return 
	 */
	@Query("select b from Button b where b.domen = ?1")
    Optional<Button> findOneDomain(String domen);
}
