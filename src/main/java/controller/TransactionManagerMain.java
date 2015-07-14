package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.test.CustomerManager;
import service.test.CustomerManagerImpl;
import vo.test.Address;
import vo.test.Customer;

public class TransactionManagerMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
	                "config/**/*-context.xml");
	 
	        CustomerManager customerManager = ctx.getBean("customerManager",
	                CustomerManagerImpl.class);
	       	 
	        List<Customer> cusList = createDummyCustomer();
	        customerManager.createCustomer(cusList);
	 
	        ctx.close();

	}
	
	private static List<Customer> createDummyCustomer() {
		List<Customer> cusList = new ArrayList<Customer>();
		
        Customer customer = new Customer();
        customer.setId(6);
        customer.setName("Pankaj");
        Customer customer1 = new Customer();
        customer1.setId(7);
        customer1.setName("Pinky");
        Customer customer3 = new Customer();
        customer3.setId(5);
        customer3.setName("Jesy");
        
        cusList.add(customer);
        cusList.add(customer1);
        cusList.add(customer3);
        /*
        Address address = new Address();
        address.setId(2);
        address.setCountry("India");
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("Albany Dr, San Jose, CA 95129");
        customer.setAddress(address);
        return customer;
        */
        return cusList;
    }

}
