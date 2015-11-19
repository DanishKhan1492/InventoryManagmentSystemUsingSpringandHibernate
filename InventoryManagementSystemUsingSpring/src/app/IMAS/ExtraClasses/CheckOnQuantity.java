package app.IMAS.ExtraClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import app.IMAS.Entities.Product;

public class CheckOnQuantity {
  
	@Autowired
	private static SessionFactory session;
	
    @SuppressWarnings("unchecked")
	public static HashMap<String,Double> checkKgQuantity(){
        HashMap<String,Double> checkQuantity=new HashMap<>();
        List<Product> productList=new ArrayList<>();
        
        productList=(List<Product>)session.getCurrentSession().createQuery("select Prod_Name,Prod_Quantity from Product INNER JOIN Category on Product.Cat_Name=Category.Cat_Name Where Prod_Quantity <= 300 And Category.Cat_Unit=Kg)").list();
        
        for(Product product:productList){
        	checkQuantity.put(product.getItemName(), product.getItemQuantity());
        }
        
        return checkQuantity;
    }
    
    @SuppressWarnings("unchecked")
	public static HashMap<String,Double> checkPacketProduct(){
        HashMap<String,Double> checkQuantity=new HashMap<>();
        
List<Product> productList=new ArrayList<>();
        
        productList=(List<Product>)session.getCurrentSession().createQuery("select Prod_Name,Prod_Quantity from Product INNER JOIN Category on Product.Cat_Name=Category.Cat_Name Where Prod_Quantity <= 40 And Category.Cat_Unit=Kg)").list();
        
        for(Product product:productList){
        	checkQuantity.put(product.getItemName(), product.getItemQuantity());
        }
        
        return checkQuantity;
    }
}
