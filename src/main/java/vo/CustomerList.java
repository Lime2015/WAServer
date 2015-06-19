package vo;

import java.util.ArrayList;
import java.util.List;

public class CustomerList {
	private String CustomerListName;
	private List customer = new ArrayList();

	public CustomerList() {
		super();
		// TODO Auto-generated constructor stub
	}
	//////////////////////////////////////////////////////////////////
	public void addCustomer(Customer customer){
		this.customer.add(customer);
	}

	public List getCustomer() {
		return customer;
	}
	///////////////////////////////////////////////////////////////////
	public String getCustomerListName() {
		return CustomerListName;
	}
	public void setCustomerListName(String customerListName) {
		CustomerListName = customerListName;
	}

}
