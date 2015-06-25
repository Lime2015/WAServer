package jaxb2;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TestEmployeeMarshing 
{	
//	static Meeting meeting = new Meeting();
//	static Employee employee = new Employee();
	static Employees employees = new Employees();
	
	static
	{	
		employees.setEmployees(new ArrayList<Employee>());
		Employee employee = new Employee();
		employee.setId(10);
		employee.setMettings(new ArrayList<Meeting>());
		Meeting meeting = new Meeting();
		meeting.setMeeting_id("200");
		meeting.setMeeting_order("잘되나요?");
		
		Employee employee2 = new Employee();
		employee2.setId(30);
		employee2.setMettings(new ArrayList<Meeting>());
		Meeting meeting2 = new Meeting();
		meeting2.setMeeting_id("300");
		meeting2.setMeeting_order("정말 잘되나요?");
		
		employee.getMettings().add(meeting);
		employee.getMettings().add(meeting2);

		employee2.getMettings().add(meeting2);
		employee2.getMettings().add(meeting);

		employees.getEmployees().add(employee);
		employees.getEmployees().add(employee2);
		
	}
	/*
	static 
	{
		employees.setEmployees(new ArrayList<Employee>());
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("로빈");
		emp.setLastName("Gupta");
		emp.setIncome(100.0);
		
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setFirstName("Haro");
		emp2.setLastName("Gupta");
		emp2.setIncome(200.0);
		
		
		employees.getEmployees().add(emp);
		employees.getEmployees().add(emp2);
	}
	*/
	public static void main(String[] args) throws JAXBException 
	{
		marshalingExample();
		System.out.println("************************************************");
		unMarshalingExample();
	}
 
	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("c:/temp/sample_general.xml") );
		
		for(Employee emp : emps.getEmployees())
		{
			System.out.println(emp.getId());
			System.out.println(emp.getMettings());
		}
	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(employees, System.out);
		jaxbMarshaller.marshal(employees, new File("c:/temp/assemblymen.xml"));
	}
}
