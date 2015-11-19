package app.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.IMAS.CustomValidators.BillItemsValidator;
import app.IMAS.Entities.BorrowerBillItems;
import app.IMAS.Entities.Category;
import app.IMAS.Services.BorrowerService;
import app.IMAS.Services.CategoryService;
import app.IMAS.Services.ProductService;

@Controller
public class BillController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BorrowerService borrowerService;

	@Autowired
	private ProductService productService;

	private List<String> itemNames = new ArrayList<>();
	private List<Category> categoriesList = new ArrayList<>();
	private Map<String,String> validate=new HashMap<>();
	private String billId = "";

	@RequestMapping(value = "/createBillPage")
	public String viewBillPage(HttpSession session, Model model) {
		if (session.getAttribute("userName") != null) {
			categoriesList = categoryService.getAllCategories();
			billId = borrowerService.billId("CustomerBill");
			model.addAttribute("categories", categoriesList);
			model.addAttribute("BillId", billId);
			return "InventoryPages/Billing/CreateBill";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/populateBillId")
	public @ResponseBody String populateBillId(@RequestParam String table) {
		billId = borrowerService.billId(table);
		return billId;
	}

	@RequestMapping(value = "/populateBillItems")
	public @ResponseBody List<String> populateItems(@RequestParam String catName) {
		itemNames = productService.getItemNames(catName);
		return itemNames;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertBillItems")
	public String insertItemToBill(HttpSession session, Model model,@RequestParam String itemCategory, @RequestParam String itemName,@RequestParam String itemQuantity) {
		BorrowerBillItems billItems = new BorrowerBillItems();
		
		if (session.getAttribute("userName") != null) {
			double item_Quantity = 0, price = 0, totalPrice = 0;
			double totalAmount = 0.0;
			if (session.getAttribute("totalAmount") != null) {
				totalAmount = (Double) session.getAttribute("totalAmount");
			}
			
			validate=BillItemsValidator.validateBilling(itemCategory, itemName, itemQuantity);
			
			if(!validate.isEmpty()){
				categoriesList = categoryService.getAllCategories();
				billId = borrowerService.billId("BorrowerBill");
				model.addAttribute("categories", categoriesList);
				model.addAttribute("BillId", billId);
				model.addAttribute("validate", validate);
				return "InventoryPages/Billing/CreateBill";
			}else{
				item_Quantity = Double.parseDouble(itemQuantity);
				price=borrowerService.getPrice(itemName);
				totalPrice=item_Quantity*price;
				
				billItems.setItemName(itemName);
		        billItems.setItemQuantity(item_Quantity);
		        billItems.setItemPrice(price);
		        billItems.setTotalItemPrice(totalPrice);
		         
		         totalAmount += totalPrice;
		         
		         ArrayList<BorrowerBillItems> itemsList = (ArrayList<BorrowerBillItems>) session.getAttribute("billItems");
		         if (itemsList == null) {
		        	 itemsList = new ArrayList<BorrowerBillItems>();
		         }
				
		         itemsList.add(billItems);
		         session.setAttribute("billItems", itemsList);
		         session.setAttribute("totalAmount", totalAmount);
		         
		         categoriesList = categoryService.getAllCategories();
				 billId = borrowerService.billId("BorrowerBill");
				 model.addAttribute("categories", categoriesList);
				 model.addAttribute("BillId", billId);
				 model.addAttribute("totalAmount", totalAmount);
				 model.addAttribute("billItems", itemsList);
				return "InventoryPages/Billing/CreateBill";
			}
		}else{
			return "redirect:/";
		}
		
	}

}
