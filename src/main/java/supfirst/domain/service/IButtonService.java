package supfirst.domain.service;

import java.util.Collection;
import java.util.Optional;

import supfirst.entity.Button;
import supfirst.entity.User;


public interface IButtonService  {
	
	Optional<Button> getButtonById(long id);

    Optional<Button> getButtonByUser(User user);
    
    Optional<Button> getButtonByDomain(String domain);

    Collection<Button> getAllButton();

    Button create(Button button);

	
}
