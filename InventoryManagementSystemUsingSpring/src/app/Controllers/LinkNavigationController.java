package app.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.IMAS.Entities.ChangePassword;
import app.IMAS.Entities.Login;

@Controller
public class LinkNavigationController {
	
	@RequestMapping(value={"/","/loginPage"})
	public ModelAndView loginPage(){
		ModelAndView model=new ModelAndView();
		model.addObject("login", new Login());
		model.setViewName("AuthenticationPages/Login");
		return model;
	}
	
	@RequestMapping("/changePasswordPage")
	public ModelAndView changePasswordPage(){
		ModelAndView model=new ModelAndView();
		model.addObject("changePassword",new ChangePassword());
		model.setViewName("AuthenticationPages/ChangePassword");
		return model;
	}
	
	@RequestMapping("/mainPage")
	public ModelAndView viewMainPage(HttpSession session){
		ModelAndView model=new ModelAndView();
		if(session != null && session.getAttribute("userName")!=null){
			model.setViewName("InventoryPages/MainForm");
		}else{
			model.setViewName("redirect:/");
		}
		
		return model;
	}
}
