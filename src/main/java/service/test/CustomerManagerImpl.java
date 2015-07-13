package service.test;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repository.test.CustomerDAO;
import vo.test.Customer;

@Component
public class CustomerManagerImpl implements CustomerManager{
	private CustomerDAO customerDAO;
	 
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
 
    @Override
    @Transactional
    public void createCustomer(Customer cust) {
        customerDAO.create(cust);
    }

}
