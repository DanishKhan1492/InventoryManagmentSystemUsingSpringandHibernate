package app.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.IMAS.Entities.ChangePassword;
import app.IMAS.Entities.Login;
import app.IMAS.Services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String authenticateAdmin(@Valid @ModelAttribute Login login,BindingResult result,HttpSession session,Model model){
			if(result.hasErrors()){
				return "AuthenticationPages/Login";
			}else{
				String userName=login.getUserName();
				String password=login.getPassword();
				
				login=loginService.getAdmin();
				
				String dbUserName=login.getUserName();
				String dbPassword=login.getPassword();
				
				if(userName.equals(dbUserName) && password.equals(dbPassword)){
					session.setAttribute("userName", userName);
					return "redirect:mainPage";
				}else{
					model.addAttribute("msg", "User Name or Password donot Match");
					return "AuthenticationPages/Login";
				}
			}
	}
	
	@RequestMapping(value="/logout")
	public String invalidateAdmin(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/changePassword")
	public String changePassword(@Valid @ModelAttribute ChangePassword changePassword,BindingResult result,Model model){
			if(result.hasErrors()){
				return "AuthenticationPages/ChangePassword";
			}else{
				loginService.changePassword(changePassword.getNewPassword());
				model.addAttribute("msg", "Password Changed Successfully");
				model.addAttribute("login", new Login());
				return "AuthenticationPages/Login";
			}
	}
}
