package app.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.IMAS.Entities.Category;
import app.IMAS.Services.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	private List<Category> categories;
	
	@RequestMapping(value="/insertCategoryPage")
	public String viewCategoryPage(HttpSession session,Model model){
		if(session.getAttribute("userName") != null){
			categories=categoryService.getAllCategories();
			model.addAttribute("categories", categories);
			model.addAttribute("category", new Category());
			return "InventoryPages/Stock/InsertCategory";
		}else{
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/addCategory")
	public String addCategory(@Valid @ModelAttribute Category category,BindingResult result,HttpSession session,Model model){
		if(session.getAttribute("userName") != null && session !=null){
			if(result.hasErrors()){
				return "InventoryPages/Stock/InsertCategory";
			}else{
				categoryService.addCategory(category);
				categories=categoryService.getAllCategories();
				model.addAttribute("categories", categories);
				model.addAttribute("color", "green");
				model.addAttribute("msg", "Category Inserted Successfully");
				return "InventoryPages/Stock/InsertCategory";
			}
		}else{
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/deleteCategory")
	public String deleteCategory(HttpSession session, @RequestParam String catId,Model model){
			
			if(session.getAttribute("userName") != null){
				int categId=Integer.parseInt(catId);
				categoryService.deleteCategory(categId);
				categories=categoryService.getAllCategories();
				model.addAttribute("categories", categories);
				model.addAttribute("color", "red");
				model.addAttribute("msg", "Category deleted Successfully");
				return "redirect:/insertCategoryPage";
			}else{
				return "redirect:/";
			}
	}
	
}
