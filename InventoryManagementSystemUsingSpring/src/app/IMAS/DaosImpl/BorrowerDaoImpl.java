package app.IMAS.DaosImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.IMAS.Daos.BorrowerDao;
import app.IMAS.Entities.AmountBorrowed;
import app.IMAS.Entities.AmountPaid;
import app.IMAS.Entities.Borrower;
import app.IMAS.Entities.BorrowerBill;
import app.IMAS.Entities.BorrowerBillItems;

@Repository
public class BorrowerDaoImpl implements BorrowerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Borrower> getAllBorrowers() {
		return (List<Borrower>) sessionFactory.getCurrentSession().createQuery("from Borrower").list();
	}

	@Override
	public void addBorrwer(Borrower borrower) {
		sessionFactory.getCurrentSession().save(borrower);
	}

	@Override
	public Borrower searchBorrowerByCnic(String cnic) {
		return (Borrower) sessionFactory.getCurrentSession().createQuery("from Borrower Where CNIC=:cnic").setString("cnic", cnic).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Borrower> searchBorrowerByName(String borrowerName) {
		return (List<Borrower>)sessionFactory.getCurrentSession().createQuery("from Borrower Where Name LIKE :name").setString("name", "%"+borrowerName+"%").list();
	}

	@Override
	public void updateBorrower(Borrower borrower) {
		sessionFactory.getCurrentSession().update(borrower);
	}

	@Override
	public void deleteBorrower(String cnic) {
		sessionFactory.getCurrentSession().createQuery("from Borrower Where CNIC=:cnic").setString("cnic", cnic).executeUpdate();
	}

	@Override
	public void amountPaid(AmountPaid amountPaid) {
		sessionFactory.getCurrentSession().save(amountPaid);
	}

	@Override
	public Borrower getSpecificBorrower(String cnic) {
		return (Borrower) sessionFactory.getCurrentSession().createQuery("from Borrower Where CNIC=:cnic").setString("cnic", cnic).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowerBill> getBorrowerBills(String cnic) {
		return (List<BorrowerBill>) sessionFactory.getCurrentSession().createQuery("from BorrowerBill Where CNIC=:cnic").setString("cnic", cnic).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowerBillItems> getBillItems(int billId) {
		return (List<BorrowerBillItems>) sessionFactory.getCurrentSession().createQuery("from BorrowerBillItems Where Bill_Id=:id").setInteger("id", billId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AmountBorrowed> getAllBorrowedAmounts(String cnic) {
		return (List<AmountBorrowed>) sessionFactory.getCurrentSession().createQuery("from AmountBorrowed Where CNIC=:cnic").setString("cnic", cnic).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AmountPaid> getAllPaidAmounts(String cnic) {
		return (List<AmountPaid>) sessionFactory.getCurrentSession().createQuery("from AmountPaid Where CNIC=:cnic").setString("cnic", cnic).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowerBill> getBorrowerBills(String cnic, Date date) {
		return (List<BorrowerBill>) sessionFactory.getCurrentSession().createQuery("from BorrowerBill Where CNIC=:cnic AND Date=:date").setString("cnic", cnic).setDate("date", date).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AmountBorrowed> getAllBorrowedAmounts(String cnic, Date date) {
		return (List<AmountBorrowed>) sessionFactory.getCurrentSession().createQuery("from AmountBorrowed Where CNIC=:cnic AND Date=:date").setString("cnic", cnic).setDate("date", date).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AmountPaid> getAllPaidAmounts(String cnic, Date date) {
		return (List<AmountPaid>) sessionFactory.getCurrentSession().createQuery("from AmountPaid Where CNIC=:cnic AND Date=:date").setString("cnic", cnic).setDate("date", date).list();
	}

	@Override
	public String billId(String tableName) {
		int id=(Integer) sessionFactory.getCurrentSession().createQuery("select MAX(billId) from "+tableName).uniqueResult();
		String billId="";
		
		if(tableName.equals("BorrowerBill")){
			billId=generateId(id, "BB");
		}else if(tableName.equals("CustomerBill")){
			billId=generateId(id, "CB");
		}
		
		return billId;
	}

	private String generateId(int key,String type){
        String billId;
         if(key<10){
                billId=type+"-"+"000"+key;
            }else if(key<100 && key>9){
                billId=type+"-"+"00"+key;
            }else if(key<1000 && key >99){
                 billId=type+"-"+"0"+key;
            }else{
                 billId=type+key;
            }
        
        return billId;
    }

	@Override
	public double getPrice(String itemName) {
		return (Double) sessionFactory.getCurrentSession().createQuery("select itemQuantity from Product WHERE Prod_Name=:itemName").setString("itemName", itemName).uniqueResult();
	}
	
}
