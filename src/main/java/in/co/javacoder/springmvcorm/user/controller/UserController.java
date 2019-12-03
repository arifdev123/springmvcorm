package in.co.javacoder.springmvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.co.javacoder.springmvcorm.user.entities.User;
import in.co.javacoder.springmvcorm.user.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/registartionPage")
	ModelAndView showRegPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("regUser");
		return modelAndView;
	}
	
	@RequestMapping(value="/registerUser" , method=RequestMethod.POST)
	ModelAndView registerUser(@ModelAttribute("user") User user) {
		System.out.println(user);
		int result = this.service.save(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", "User created with id : " + result);
		modelAndView.setViewName("regUser");
		return modelAndView;
	}
	
	@RequestMapping("/getUsers")
	String getUsers(ModelMap model) {
		List<User> users = this.service.getAllUsers();
		model.addAttribute("users", users);
		return "displayUsers";
	}
	
	@RequestMapping("validateEmail")
	@ResponseBody String validateEmail(@RequestParam("id") int id) {
		 User user = service.findUser(id);
		 String msg = "";
		 if(user != null) {
			 msg = id + " is taken already";
		} /*
			 * else { msg = "Congrats ! " + id + " is for you. You can keep it."; }
			 */
		 
		 return msg;
		
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

}
