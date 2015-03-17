package com.nagarro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nagarro.bean.UserBean;
import com.nagarro.entity.user.InvalidUserDataException;
import com.nagarro.entity.user.User;
import com.nagarro.service.user.AuthenticationService;

/**
 * Handle authentication related mappings.
 * 
 * @author ashish2069
 *
 */
@Controller
@SessionAttributes("user")
public class Authentication {

	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value = {"/login", "index"}, method = RequestMethod.GET)
	public String showLoginPage(Model model, @RequestParam(required = false) String error) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof UsernamePasswordAuthenticationToken) {
			return "redirect:search-flights.html";
		} else {
			model.addAttribute("user", new UserBean());
			model.addAttribute("error", error);
			return "authentication/login";
		}
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String showSignUpPage(Model model, 
								 @RequestParam(required = false) String error) {
		model.addAttribute("user", new UserBean());
		model.addAttribute("error", error);
		return "authentication/sign-up";
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String performSignUp(@Valid @ModelAttribute("user") UserBean userBean, 
								BindingResult result) { 
		try {
			if (!result.hasErrors()) {
				if (authenticationService.addNewUser(prepareUserEntity(userBean))) {
					return "redirect:login.html";
				}
			}
			
			return "authentication/sign-up";
		} catch (InvalidUserDataException e) {
			return "redirect:sign-up.html?error=" + e.getMessage();
		}
	}
	
	/**
	 * @param userBean
	 * @return a user object in the form of entity.
	 */
	private User prepareUserEntity (final UserBean userBean) {
		User user = new User();
		user.setUserName(userBean.getUserName());
		user.setPassword(userBean.getPassword());
		user.setEmailId(userBean.getEmailId());
		
		return user;
	}
}
