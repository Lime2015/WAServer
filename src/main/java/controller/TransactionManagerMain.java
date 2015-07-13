package controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.test.CustomerManager;
import service.test.CustomerManagerImpl;
import vo.test.Address;
import vo.test.Customer;

public class TransactionManagerMain {

	public static void main(String[] args) {
		
		Customer cust = createDummyCustomer();
		CustomerManagerImpl customerManagerImpl = new CustomerManagerImpl();
        customerManagerImpl.createCustomer(cust);
 
//        ctx.close();
		//ApplicationContext ctx;

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
	                "config/**/*-context.xml");
	 
	        CustomerManager customerManager = ctx.getBean("customerManager",
	                CustomerManagerImpl.class);
	       	 
//	        Customer cust = createDummyCustomer();
	        customerManager.createCustomer(cust);
	 
	        ctx.close();

	}
	
	private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Pankaj");
        Address address = new Address();
        address.setId(2);
        address.setCountry("India");
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("Albany Dr, San Jose, CA 95129");
        customer.setAddress(address);
        return customer;
    }

}
