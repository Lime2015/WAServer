package vo.general;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="meeting")
@XmlAccessorType (XmlAccessType.FIELD)
public class GeneralMeeting {
	
	private Integer assemblyman_id;
	private Integer update_tag;
	
	private Integer meeting_id;
	private String meeting_order;
	private String meeting_dttm;
	private String mod_dttm;
	private String attend_status;
	

	/////////////////////////////////////////////////////////////////////
	public String getMod_dttm() {
		return mod_dttm;
	}
	public void setMod_dttm(String mod_dttm) {
		this.mod_dttm = mod_dttm;
	}
	
	public Integer getAssemblyman_id() {
		return assemblyman_id;
	}
	public void setAssemblyman_id(Integer assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}
	public Integer getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(Integer meeting_id) {
		this.meeting_id = meeting_id;
	}
	public String getMeeting_order() {
		return meeting_order;
	}
	public void setMeeting_order(String meeting_order) {
		this.meeting_order = meeting_order;
	}
	public String getMeeting_dttm() {
		return meeting_dttm;
	}
	public void setMeeting_dttm(String meeting_dttm) {
		this.meeting_dttm = meeting_dttm;
	}
	public String getAttend_status() {
		return attend_status;
	}
	public void setAttend_status(String attend_status) {
		this.attend_status = attend_status;
	}
	public Integer getUpdate_tag() {
		return update_tag;
	}
	public void setUpdate_tag(Integer update_tag) {
		this.update_tag = update_tag;
	}
	////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "GeneralMeeting [assemblyman_id=" + assemblyman_id
				+ ", meeting_id=" + meeting_id + ", meeting_order="
				+ meeting_order + ", meeting_dttm=" + meeting_dttm
				+ ", attend_status=" + attend_status + ", update_tag="
				+ update_tag + "]";
	}
	
}
