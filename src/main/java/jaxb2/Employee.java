package jaxb2;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employee 
{
	@XmlElement(name = "id")
	private Integer id;
	
	@XmlElementWrapper(name="meetings")
	@XmlElement(name = "meeting")
	private List<Meeting> mettings;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Meeting> getMettings() {
		return mettings;
	}
	public void setMettings(List<Meeting> mettings) {
		this.mettings = mettings;
	}
	
	
	
	//////////////////////////////////////////////////////////////
	
	
}
