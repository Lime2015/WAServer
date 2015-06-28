package vo.general;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "assemblyman")
@XmlAccessorType (XmlAccessType.FIELD)
public class GeneralAssemblyman 
{
	@XmlElement(name = "assemblyman_id")
	private String assemblyman_id;
	
	@XmlElementWrapper(name="meetings")
	@XmlElement(name = "meeting")
	private List<GeneralMeeting> mettings;
	
	///////////////////////////////////////////////////////////////////////
	public String getAssemblyman_id() {
		return assemblyman_id;
	}

	public void setAssemblyman_id(String assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}

	public List<GeneralMeeting> getMettings() {
		return mettings;
	}

	public void setMettings(List<GeneralMeeting> mettings) {
		this.mettings = mettings;
	}
	
	
	
	
}
