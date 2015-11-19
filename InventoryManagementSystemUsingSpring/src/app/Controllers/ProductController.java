package app.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import app.IMAS.Entities.Price;
import app.IMAS.Entities.Product;
import app.IMAS.Services.CategoryService;
import app.IMAS.Services.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	private Category category=new Category();
	private List<Product> productList;
	private List<Category> categoriesList;
	private Price price=new Price();
	private List<Price> pricesList=new ArrayList<>();

	@RequestMapping(value = "/insertItemPage")
	public String viewProductPage(HttpSession session, Model model) {
		if (session.getAttribute("userName") != null) {
			productList = productService.getAllItems();
			categoriesList = categoryService.getAllCategories();
			model.addAttribute("product", new Product());
			model.addAttribute("categoriesList", categoriesList);
			model.addAttribute("items", productList);
			return "InventoryPages/Stock/InsertItem";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "insertItem")
	public String itemControll(@Valid @ModelAttribute Product product,
			BindingResult result,HttpSession session, Model model,
			@RequestParam String actionType) {
		Product newProduct = new Product();

		if (session.getAttribute("userName") != null) {
			
			if (result.hasErrors()) {
				return "InventoryPages/Stock/InsertItem";

			} else {

				switch (actionType.toLowerCase()) {

				case "add":
					category=categoryService.getWholeCategory(product.getItemCategory().getCatName());
					product.setItemCategory(category);
					productService.addItem(product);
					newProduct = new Product();
					model = callToCategoryProduct(model);
					model.addAttribute("product", newProduct);
					model.addAttribute("msg", "Successfully Added");
					break;
				case "update":
					double oldPrice=(double) session.getAttribute("oldPrice"); //getting old Price
					double newPrice=product.getItemPrice(); // getting new price
					Date date=new Date(); //generating data for price change
					Set<Price> prices=new HashSet<>();
					
					if(oldPrice != newPrice){
						// setting values in Price Entity
						price.setOldPrice(oldPrice); 
						price.setNewPrice(newPrice);
						price.setDate(date);
						price.setProduct(product);
						prices.add(price);
					}
					
					session.removeAttribute("oldPrice");
					//getting category for product
					category=categoryService.getWholeCategory(product.getItemCategory().getCatName());
					product.setItemCategory(category);
					product.setPrices(prices);
					productService.updateItems(product);
					newProduct = new Product();
					model = callToCategoryProduct(model);
					model.addAttribute("product", newProduct);
					model.addAttribute("msg", "Successfully Updated");
					break;
				case "delete":
					productService.deleteItems(product.getItemId());
					product = new Product();
					model=callToCategoryProduct(model);
					model.addAttribute("product", newProduct);
					model.addAttribute("msg", "Deleted Successfully");
					break;
				case "search":
					newProduct=productService.getItemsforupdate(product.getItemName());
					if(newProduct != null){
						model.addAttribute("product", newProduct);
						session.setAttribute("oldPrice", newProduct.getItemPrice());
						model=callToCategoryProduct(model);
					}else{
						model.addAttribute("msg", "Product Not Found");
						productList = productService.getAllItems();
						model.addAttribute("items", productList);
					}
					break;
				}
				return "InventoryPages/Stock/InsertItem";
			}
			
			
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value="/searchItem")
	public String searchItems(HttpSession session, @RequestParam String searchItem,Model model){
			if(session.getAttribute("userName") != null){
				productList=productService.searchItemsByAnyValue(searchItem);
				model.addAttribute("items",productList);
				return "InventoryPages/Stock/SearchItem";
			}else{
				return "redirect:/";
			}
	}
	
	@RequestMapping(value="/itemPricePage")
	public String viewItemPricePage(HttpSession session, Model model){
			if(session.getAttribute("userName") != null){
				pricesList=productService.getAllPrice();
				model.addAttribute("prices", pricesList);
				return "InventoryPages/Stock/ShowPrices";
			}else{
				return "redirect:/";
			}
	}
	
	@RequestMapping(value="/searchItemPrice")
	public String searchItemPrices(HttpSession session, @RequestParam String itemPrice,Model model){
			if(session.getAttribute("userName") != null){
				pricesList=productService.getSpecificPrice(itemPrice);
				model.addAttribute("prices", pricesList);
				return "InventoryPages/Stock/SearchItem";
			}else{
				return "redirect:/";
			}
	}
	
	
	private Model callToCategoryProduct(Model model) {
		productList = productService.getAllItems();
		categoriesList = categoryService.getAllCategories();
		model.addAttribute("categoriesList", categoriesList);
		model.addAttribute("items", productList);
		return model;
	}
}
