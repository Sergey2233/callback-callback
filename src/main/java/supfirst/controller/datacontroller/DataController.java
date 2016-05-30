package supfirst.controller.datacontroller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import supfirst.controller.controllermvc.login.UserController;
import supfirst.domain.entity.Response;
import supfirst.domain.entity.UserCreateForm;
import supfirst.domain.service.IUserService;
import supfirst.domain.validation.UserCreateFormValidator;

@RestController
public class DataController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);
	private final IUserService userService;
	private final UserCreateFormValidator userCreateFormValidator;

	@Autowired
	public DataController(IUserService userService, UserCreateFormValidator userCreateFormValidator) {
		this.userService = userService;
		this.userCreateFormValidator = userCreateFormValidator;
	}

	@RequestMapping(value = "/callback/create", method = RequestMethod.POST)
	public Response handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form,
			BindingResult bindingResult) {
		Response result = new Response();

		LOGGER.info("Processing user create form={}, bindingResult={}", form, bindingResult);
		if (bindingResult.hasErrors()) {
			// failed validation
			// return "login/user_create";
			result.addException("Exception", "Помилковi данi." + bindingResult.toString());
			result.setValue(false);
		}
		try {
			// form.setRole(Role.USER);
			userService.create(form);
		} catch (DataIntegrityViolationException e) {
			// probably email already exists - very rare case when multiple
			// admins are adding same user
			// at the same time and form validation has passed for more than one
			// of them.
			LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
			bindingResult.reject("email.exists", "Email already exists");
			// return "login/user_create";
			result.addException("Exception", "Email.exists");
			result.setValue(false);
		}
		// ok, redirect
		// return "redirect:/";
		result.setValue(true);
		return result;
	}

}
