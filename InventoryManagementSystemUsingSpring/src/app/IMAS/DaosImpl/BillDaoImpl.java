package app.IMAS.DaosImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.IMAS.Daos.BillDao;
import app.IMAS.Entities.BorrowerBill;
import app.IMAS.Entities.BorrowerBillItems;

@Repository
public class BillDaoImpl implements BillDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertBill(BorrowerBill billMain, List<BorrowerBillItems> billItems) {
		sessionFactory.getCurrentSession().save(billMain);
		for(BorrowerBillItems billItem:billItems){
			sessionFactory.getCurrentSession().save(billItem);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowerBill> getAllBills() {
		return (List<BorrowerBill>) sessionFactory.getCurrentSession().createQuery("from BorrowerBill").list();
	}

	@Override
	public BorrowerBill getSpecificBill(String cnic) {
		return (BorrowerBill) sessionFactory.getCurrentSession().createQuery("from BorrowerBill Where CNIC=:cnic").setString("cnic", cnic).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowerBillItems> getAllBillItems(int billId) {
		return (List<BorrowerBillItems>) sessionFactory.getCurrentSession().createQuery("from BorrowerBillItems Where Bill_Id=:billId").setInteger("billId", billId).list();
	}

}
