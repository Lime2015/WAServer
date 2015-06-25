package vo.general;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "general_meeting_attend")
@XmlAccessorType (XmlAccessType.FIELD)
public class GeneralMeetingAttend {
	
	@XmlElementWrapper(name = "assemblymen")
	@XmlElement(name = "assemblyman")
	private List<GeneralAssemblyman> assemblymen = null;

	public List<GeneralAssemblyman> getAssemblymen() {
		return assemblymen;
	}

	public void setAssemblymen(List<GeneralAssemblyman> assemblymen) {
		this.assemblymen = assemblymen;
	}


}
