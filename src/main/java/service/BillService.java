package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BillDAO;
import vo.bill.Bill;
import vo.general.GeneralMeeting;

@Component
public class BillService {
	
	private BillDAO billDAO;
	
	@Autowired
	public void setBillDAO(BillDAO billDAO) {
		this.billDAO = billDAO;
	}
	/////////////////////////////////////////////////////////////////
	
	public int insert(Bill bill) {
		return billDAO.insert(bill);
	}
	public int update(Bill bill) {
		return billDAO.update(bill);
	}
	public Bill selectBill(int bill_id){
		return billDAO.selectBill(bill_id);
	}
	public List<Bill> selectList(){
		return billDAO.selectList();
	}

}
