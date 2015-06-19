package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vo.Customer;

public class ViewCustomerList {
		private static final String XML_FILE_NAME = "customer.xml";
		 
		public static void main(String[] args) throws IOException {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("/config/*-context.xml");
			XMLConverter converter = (XMLConverter) appContext.getBean("XMLConverter");
			/*converter.setUnmarshaller(CustomerList.class);*/
			/*Unmarshaller un2 = new Unmarshaller(CustomerList.class);*/

	/*
			Customer customer = new Customer();

			customer.setName("mkyong");
			customer.setAge(30);
			customer.setFlag(true);
			customer.setAddress("This is address");
	 
			System.out.println("Convert Object to XML!");
			//from object to XML file
			converter.convertFromObjectToXML(customer, XML_FILE_NAME);
			System.out.println("Done \n");
	 */
			System.out.println("Convert XML back to Object!");
			System.out.println();
			//from XML to object
			List<Customer> customerList = new ArrayList();
			customerList = (List<Customer>)converter.convertFromXMLToObject(XML_FILE_NAME);
//			System.out.println(customer2);
			System.out.println("Done");
	 
		}

}
