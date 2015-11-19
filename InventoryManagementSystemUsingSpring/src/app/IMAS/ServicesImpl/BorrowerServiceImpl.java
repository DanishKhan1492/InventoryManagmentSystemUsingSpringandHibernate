package app.IMAS.ServicesImpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.IMAS.Daos.BorrowerDao;
import app.IMAS.Entities.AmountBorrowed;
import app.IMAS.Entities.AmountPaid;
import app.IMAS.Entities.Borrower;
import app.IMAS.Entities.BorrowerBill;
import app.IMAS.Entities.BorrowerBillItems;
import app.IMAS.Services.BorrowerService;

@Service
public class BorrowerServiceImpl implements BorrowerService {

	@Autowired	
	private BorrowerDao borrowerDao;
	
	@Transactional
	public List<Borrower> getAllBorrowers() {
		return borrowerDao.getAllBorrowers();
	}

	@Transactional
	public void addBorrwer(Borrower borrower) {
		borrowerDao.addBorrwer(borrower);
	}

	@Transactional
	public Borrower searchBorrowerByCnic(String cnic) {
		return borrowerDao.searchBorrowerByCnic(cnic);
	}

	@Transactional
	public List<Borrower> searchBorrowerByName(String borrowerName) {
		return borrowerDao.searchBorrowerByName(borrowerName);
	}

	@Transactional
	public void updateBorrower(Borrower borrower) {
		borrowerDao.updateBorrower(borrower);
	}

	@Transactional
	public void deleteBorrower(String cnic) {
		borrowerDao.deleteBorrower(cnic);
	}

	@Transactional
	public void amountPaid(AmountPaid amountPaid) {
		borrowerDao.amountPaid(amountPaid);
	}

	@Transactional
	public Borrower getSpecificBorrower(String cnic) {
		return borrowerDao.getSpecificBorrower(cnic);
	}

	@Transactional
	public List<BorrowerBill> getBorrowerBills(String cnic) {
		return borrowerDao.getBorrowerBills(cnic);
	}

	@Transactional
	public List<BorrowerBillItems> getBillItems(int billId) {
		return borrowerDao.getBillItems(billId);
	}

	@Transactional
	public List<AmountBorrowed> getAllBorrowedAmounts(String cnic) {
		return borrowerDao.getAllBorrowedAmounts(cnic);
	}

	@Transactional
	public List<AmountPaid> getAllPaidAmounts(String cnic) {
		return borrowerDao.getAllPaidAmounts(cnic);
	}

	@Transactional
	public List<BorrowerBill> getBorrowerBills(String cnic, Date date) {
		return borrowerDao.getBorrowerBills(cnic);
	}

	@Transactional
	public List<AmountBorrowed> getAllBorrowedAmounts(String cnic, Date date) {
		return borrowerDao.getAllBorrowedAmounts(cnic);
	}

	@Transactional
	public List<AmountPaid> getAllPaidAmounts(String cnic, Date date) {
		return borrowerDao.getAllPaidAmounts(cnic);
	}

	@Transactional
	public String billId(String tableName) {
		return borrowerDao.billId(tableName);
	}

	@Transactional
	public double getPrice(String itemName) {
		return borrowerDao.getPrice(itemName);
	}

}
