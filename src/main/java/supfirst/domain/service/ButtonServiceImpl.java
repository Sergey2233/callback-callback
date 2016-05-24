package supfirst.domain.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import supfirst.domain.repository.ButtonRepository;
import supfirst.entity.Button;
import supfirst.entity.User;

public class ButtonServiceImpl implements IButtonService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ButtonServiceImpl.class);
	@Autowired
	ButtonRepository buttonRepository;
	@Override
	public Optional<Button> getButtonById(long id) {
		 LOGGER.debug("Getting button={}", id);
		return  Optional.ofNullable(buttonRepository.findOne(id));
	}

	@Override
	public Optional<Button> getButtonByUser(User user) {	
		return  buttonRepository.findOneUser(user);
	}

	@Override
	public Collection<Button> getAllButton() {
		
		return buttonRepository.findAll(new Sort("user.id"));
	}

	@Override
	public Button create(Button button) {
		Button newbutton = buttonRepository.save(button);
		return  newbutton;
	}

	@Override
	public Optional<Button> getButtonByDomain(String domain) {
		buttonRepository.findOneDomain(domain);
		return buttonRepository.findOneDomain(domain);
	}

	 
}
