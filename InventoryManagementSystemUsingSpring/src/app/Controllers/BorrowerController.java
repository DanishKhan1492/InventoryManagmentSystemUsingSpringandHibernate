package app.Controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import app.IMAS.Entities.AmountBorrowed;
import app.IMAS.Entities.AmountPaid;
import app.IMAS.Entities.Borrower;
import app.IMAS.Entities.BorrowerBill;
import app.IMAS.Entities.BorrowerBillItems;
import app.IMAS.Services.BorrowerService;

@Controller
public class BorrowerController {
	@Autowired
	private BorrowerService borrowerService;
	private List<Borrower> borrowersList = new ArrayList<>();
	private Borrower borrower = new Borrower();
	private List<AmountPaid> amountPaidList = new ArrayList<>();
	private List<AmountBorrowed> amountBorrowedList = new ArrayList<>();
	private List<BorrowerBill> borrowerBills = new ArrayList<>();
	private List<List<BorrowerBillItems>> borrowerBillItemsList = new ArrayList<>();

	@RequestMapping(value = "/borrowerPage")
	public String borrowerMenu(HttpSession session, Model model) {
		if (session.getAttribute("userName") != null) {
			borrowersList = borrowerService.getAllBorrowers();
			model.addAttribute("borrower", new Borrower());
			model.addAttribute("borrowers", borrowersList);
			return "InventoryPages/Borrower/Borrower";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/borrower")
	public String borrower(@Valid @ModelAttribute Borrower borrower,
			BindingResult result, HttpSession session, Model model,
			@RequestParam String actionType) {

		Borrower newBorrower = new Borrower();

		if (actionType.toLowerCase().equals("search")) {
			newBorrower = borrowerService.searchBorrowerByCnic(borrower
					.getCnic());
			if (newBorrower != null) {
				model.addAttribute("borrower", newBorrower);
				borrowersList = borrowerService.getAllBorrowers();
				model.addAttribute("borrowers", borrowersList);
			} else {
				model.addAttribute("msg", "Borrower Not Found");
				borrowersList = borrowerService.getAllBorrowers();
				model.addAttribute("borrowers", borrowersList);
			}
			return "InventoryPages/Borrower/Borrower";

		} else if (session.getAttribute("userName") != null) {
			if (result.hasErrors()) {
				borrowersList = borrowerService.getAllBorrowers();
				model.addAttribute("borrowers", borrowersList);
				return "InventoryPages/Borrower/Borrower";
			} else {

				switch (actionType.toLowerCase()) {
				case "add":
					borrowerService.addBorrwer(borrower);
					borrowersList = borrowerService.getAllBorrowers();
					newBorrower = new Borrower();
					model.addAttribute("borrowers", borrowersList);
					model.addAttribute("msg", "Successfully Added");
					model.addAttribute("borrower", newBorrower);
					break;
				case "update":
					borrowerService.updateBorrower(borrower);
					borrowersList = borrowerService.getAllBorrowers();
					newBorrower = new Borrower();
					model.addAttribute("borrowers", borrowersList);
					model.addAttribute("msg", "Successfully Updated");
					model.addAttribute("borrower", newBorrower);
					break;
				case "search":

					break;
				case "delete":
					borrowerService.deleteBorrower(borrower.getCnic());
					newBorrower = new Borrower();
					borrowersList = borrowerService.getAllBorrowers();
					model.addAttribute("borrowers", borrowersList);
					break;
				}
				return "InventoryPages/Borrower/Borrower";
			}
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/searchBorrowerPage")
	public String searchBorrowerPage(HttpSession session, Model model) {
		if (session.getAttribute("userName") != null) {
			return "InventoryPages/Borrower/SearchBorrower";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/searchBorrower")
	public String searchBorrower(HttpSession session, Model model,
			@RequestParam String name) {
		if (session.getAttribute("userName") != null) {
			borrowersList = borrowerService.searchBorrowerByName(name);
			if (borrowersList == null) {
				model.addAttribute("msg", "Borrower Not Found");
				return "InventoryPages/Borrower/SearchBorrower";
			} else {
				model.addAttribute("borrowers", borrowersList);
				return "InventoryPages/Borrower/SearchBorrower";
			}
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/payAmount")
	public String payAmount(@Valid @ModelAttribute AmountPaid payAmount,
			BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("userName") != null) {
			if (result.hasErrors()) {
				return "InventoryPages/Borrower/PayAmount";
			} else {
				Borrower borrower = new Borrower();
				borrower = borrowerService.searchBorrowerByCnic(payAmount
						.getCnic());
				double lastAmount = borrower.getDebtAmount();
				double amountPayment = payAmount.getPaymentAmount();
				double remainingAmount = lastAmount - amountPayment;
				Date date = new Date();

				AmountPaid amountPaid = new AmountPaid();
				amountPaid.setCnic(borrower.getCnic());
				amountPaid.setLastAmount(lastAmount);
				amountPaid.setPaymentAmount(amountPayment);
				amountPaid.setAmountRemaining(remainingAmount);
				amountPaid.setDate(date);

				borrower.setDebtAmount(remainingAmount);

				borrowerService.amountPaid(amountPaid);
				borrowerService.updateBorrower(borrower);

				model.addAttribute("msg", "Amount Paid.............");
				model.addAttribute("payAmount", new AmountPaid());
				return "InventoryPages/Borrower/PayAmount";
			}
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/showHistory")
	public String showBorrowerHistory(HttpSession session, Model model, @RequestParam String cnic, @RequestParam String searchDate) {
		if (session.getAttribute("userName") != null) {
			if (!cnic.equals("") && !cnic.isEmpty() && searchDate.equals("") && searchDate.isEmpty()) {
				borrower = borrowerService.getSpecificBorrower(cnic);
				borrowerBills = borrowerService.getBorrowerBills(cnic);
				for (BorrowerBill borrowerBill : borrowerBills) {
					List<BorrowerBillItems> billItems = new ArrayList<>();
					billItems = borrowerService.getBillItems(borrowerBill.getBillId());
					borrowerBillItemsList.add(billItems);
				}

				amountPaidList = borrowerService.getAllPaidAmounts(cnic);
				amountBorrowedList = borrowerService.getAllBorrowedAmounts(cnic);

				model.addAttribute("borrower", borrower);
				model.addAttribute("borrowerBills", borrowerBills);
				model.addAttribute("borrowerBillItems", borrowerBillItemsList);
				model.addAttribute("borrowerAmountPaid", amountPaidList);
				model.addAttribute("borrowerAmountBorrowed", amountBorrowedList);

				return "InventoryPages/Borrower/ShowBorrowerHistory";
			} else if (!cnic.equals("") && !cnic.isEmpty() && !searchDate.equals("") && !searchDate.isEmpty()) {

				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					date = dateFormat.parse(searchDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				borrower = borrowerService.getSpecificBorrower(cnic);
				borrowerBills = borrowerService.getBorrowerBills(cnic, date);
				for (BorrowerBill borrowerBill : borrowerBills) {
					List<BorrowerBillItems> billItems = new ArrayList<>();
					billItems = borrowerService.getBillItems(borrowerBill.getBillId());
					borrowerBillItemsList.add(billItems);
				}

				amountPaidList = borrowerService.getAllPaidAmounts(cnic, date);
				amountBorrowedList = borrowerService.getAllBorrowedAmounts(
						cnic, date);

				model.addAttribute("borrower", borrower);
				model.addAttribute("borrowerBills", borrowerBills);
				model.addAttribute("borrowerBillItems", borrowerBillItemsList);
				model.addAttribute("borrowerAmountPaid", amountPaidList);
				model.addAttribute("borrowerAmountBorrowed", amountBorrowedList);

				return "InventoryPages/Borrower/ShowBorrowerHistory";
			} else {
				model.addAttribute("msg", "No Record Found");
				return "InventoryPages/Borrower/ShowBorrowerHistory";
			}
		} else {
			return "redirect:/";
		}
	}

}
