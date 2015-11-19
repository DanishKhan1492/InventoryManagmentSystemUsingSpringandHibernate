package app.IMAS.CustomValidators;

import java.util.HashMap;
import java.util.Map;

public class BillItemsValidator {
	
	public static Map<String,String> validateBilling(String catName, String itemName,String itemQuantity){
		Map<String,String> message=new HashMap<>();
		
			if(catName.equals("") || catName.isEmpty() || catName.equals("Select Category")){
				message.put("errorCategoryName", "Select Category Name");
			}
			
			if(itemName.equals("") || itemName.isEmpty() || itemName.equals("Select Items")){
				message.put("errorItemName", "Select Item Name");
			
			}
			
			if(itemQuantity.equals("") || itemQuantity.isEmpty() ){
				message.put("errorItemQuantity", "Enter Item Quantity");
			
			}
			
		return message;
	}
}
