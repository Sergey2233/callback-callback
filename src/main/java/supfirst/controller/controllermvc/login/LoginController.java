package supfirst.controller.controllermvc.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import supfirst.domain.entity.Response;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
//        LOGGER.debug("Getting login page, error={}", error);
//        return new ModelAndView("login/login", "error", error);
//    }

     
    @RequestMapping("/authenticationfailure")
	public @ResponseBody Response authenticationFailure() {
		Response result = new Response();
		result.addException("Exception", "Помилковi данi.");
		return result;
	}

	@RequestMapping("/authenticated")
	public @ResponseBody Response authenticated() {
		Response result = new Response();
		result.setValue(true);
		return result;
	}

	@RequestMapping("/notauthenticated")
	public void notauthenticated(HttpServletRequest request, HttpServletResponse responce) {
		try {
			responce.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
