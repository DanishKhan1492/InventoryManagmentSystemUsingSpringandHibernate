package app.IMAS.ServicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.IMAS.Daos.BillDao;
import app.IMAS.Entities.BorrowerBill;
import app.IMAS.Entities.BorrowerBillItems;
import app.IMAS.Services.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDao billDao;
	
	@Transactional
	public void insertBill(BorrowerBill billMain, List<BorrowerBillItems> billItems) {
		billDao.insertBill(billMain, billItems);
	}

	@Transactional
	public List<BorrowerBill> getAllBills() {
		return billDao.getAllBills();
	}

	@Transactional
	public BorrowerBill getSpecificBill(String cnic) {
		return billDao.getSpecificBill(cnic);
	}

	@Transactional
	public List<BorrowerBillItems> getAllBillItems(int billId) {
		return billDao.getAllBillItems(billId);
	}

}
