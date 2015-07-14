package service.test;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repository.test.CustomerDAO;
import vo.test.Customer;
import vo.test.CustomerList;

@Component
public class CustomerManagerImpl implements CustomerManager{
	private CustomerDAO customerDAO;
	 
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
 
	@Override
	@Transactional
	public void createCustomer(List<Customer> cusList) {
		customerDAO.create(cusList);
		
	}

}
