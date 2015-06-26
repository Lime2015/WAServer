package vo.committee;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stand_committee_meeting_attend")
@XmlAccessorType (XmlAccessType.FIELD)
public class CommitteeMeetingAttend {
	

	@XmlElementWrapper(name = "assemblymen")
	@XmlElement(name = "assemblyman")
	private List<CommitteeAssemblyman> assemblymen = null;
	
	//////////////////////////////////////////////////////////////////////////////////
	public List<CommitteeAssemblyman> getAssemblymen() {
		return assemblymen;
	}

	public void setAssemblymen(List<CommitteeAssemblyman> assemblymen) {
		this.assemblymen = assemblymen;
	}



}
