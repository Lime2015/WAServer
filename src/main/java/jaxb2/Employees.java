package jaxb2;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "general_meeting_attend")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employees 
{
	@XmlElementWrapper(name = "assemblymen")
	@XmlElement(name = "employee")
	private List<Employee> employees = null;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
