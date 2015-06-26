package vo.committee;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "assemblyman")
@XmlAccessorType (XmlAccessType.FIELD)
public class CommitteeAssemblyman {
	
	@XmlElement(name = "assemblyman_id")
	private Integer assemblyman_id;
	
	@XmlElementWrapper(name="meetings")
	@XmlElement(name = "meeting")
	private List<CommitteeMeeting> mettings;

	///////////////////////////////////////////////////////////////////////
	public Integer getAssemblyman_id() {
		return assemblyman_id;
	}

	public void setAssemblyman_id(Integer assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}

	public List<CommitteeMeeting> getMettings() {
		return mettings;
	}

	public void setMettings(List<CommitteeMeeting> mettings) {
		this.mettings = mettings;
	}
	

}

