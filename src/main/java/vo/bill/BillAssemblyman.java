package vo.bill;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "assemblyman")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillAssemblyman {

	@XmlElement(name = "assemblyman_id")
	private Integer assemblyman_id;
	@XmlElement(name = "assemblyman_name")
	private String assemblyman_name;

	@XmlElementWrapper(name = "bills")
	@XmlElement(name = "bill")
	private List<Bill> bills;
	
	/////////////////////////////////////////////////////////////////////////////////////////
	public Integer getAssemblyman_id() {
		return assemblyman_id;
	}

	public void setAssemblyman_id(Integer assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}

	public String getAssemblyman_name() {
		return assemblyman_name;
	}

	public void setAssemblyman_name(String assemblyman_name) {
		this.assemblyman_name = assemblyman_name;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	

}
