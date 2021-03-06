package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BillDAO;
import vo.bill.Bill;
import vo.bill.BillInfo;

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
	public Bill selectBill(String bill_no){
		return billDAO.selectBill(bill_no);
	}
	public List<Bill> selectList(){
		return billDAO.selectList();
	}

	public int selectUpdate() {
		return billDAO.selectUpdate();
	}

	public void saveData(int updateTAG, BillInfo billInfo) throws Exception {
		billDAO.create(updateTAG, billInfo);
	}

}
