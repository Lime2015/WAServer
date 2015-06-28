package vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "assemblyman")
@XmlAccessorType (XmlAccessType.FIELD)
public class Assemblyman {
	
	private String assemblyman_id;
	private Integer update_tag;
	
	private String assemblyman_name;
	private String image_url;
	private String org_image_url;
	private String mod_dttm;
	private Integer party_id;
	private String party_name;
	private String local_constituency;
	
	//////////////////////////////////////////////////////////////////////
	public String getAssemblyman_id() {
		return assemblyman_id;
	}
	public void setAssemblyman_id(String assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}
	public String getAssemblyman_name() {
		return assemblyman_name;
	}
	public void setAssemblyman_name(String assemblyman_name) {
		this.assemblyman_name = assemblyman_name;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getOrg_image_url() {
		return org_image_url;
	}
	public void setOrg_image_url(String org_image_url) {
		this.org_image_url = org_image_url;
	}
	public String getMod_dttm() {
		return mod_dttm;
	}
	public void setMod_dttm(String mod_dttm) {
		this.mod_dttm = mod_dttm;
	}
	public int getParty_id() {
		return party_id;
	}
	public void setParty_id(int party_id) {
		this.party_id = party_id;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getLocal_constituency() {
		return local_constituency;
	}
	public void setLocal_constituency(String local_constituency) {
		this.local_constituency = local_constituency;
	}
	public Integer getUpdate_tag() {
		return update_tag;
	}
	public void setUpdate_tag(Integer update_tag) {
		this.update_tag = update_tag;
	}
	///////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Assemblyman [assemblyman_id=" + assemblyman_id
				+ ", assemblyman_name=" + assemblyman_name + ", image_url="
				+ image_url + ", org_image_url=" + org_image_url
				+ ", mod_dttm=" + mod_dttm + ", party_id=" + party_id
				+ ", party_name=" + party_name + ", local_constituency="
				+ local_constituency + ", update_tag=" + update_tag + "]";
	}
	
}


