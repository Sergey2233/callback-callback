package supfirst.controller.controllermvc.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import supfirst.domain.entity.Response;
import supfirst.domain.entity.Role;
import supfirst.domain.entity.UserCreateForm;
import supfirst.domain.service.IUserService;
import supfirst.domain.validation.UserCreateFormValidator;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private  IUserService userService;
    private  UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UserController(IUserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    

    @RequestMapping("/callback/callback")
    public String getUserPage() {
        LOGGER.info("Getting user page callback");
        return  "callback/callback";
    }
    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        LOGGER.info("Getting user page for user={}", id);
        return new ModelAndView("login/user", "user", userService.getUserById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }

//   //@PreAuthorize("hasAuthority('USER')")
//    @RequestMapping(value = "/callback/create", method = RequestMethod.GET)
//    public ModelAndView getUserCreatePage() {
//        LOGGER.info("Getting user create form");
//        return new ModelAndView("login/user_create", "form", new UserCreateForm());
//    }

   // @PreAuthorize("hasAuthority('USER')")
   

}
