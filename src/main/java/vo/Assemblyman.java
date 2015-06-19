package vo;

public class Assemblyman {
	int manId;
	String name;
	String imgUrl;
	String orgImg;
	int partyId;
	String partyName;
	String localConstituency;
	
	// getter & setter
	public int getManId() {
		return manId;
	}
	public void setManId(int manId) {
		this.manId = manId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getOrgImg() {
		return orgImg;
	}
	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getLocalConstituency() {
		return localConstituency;
	}
	public void setLocalConstituency(String localConstituency) {
		this.localConstituency = localConstituency;
	}
	
	@Override
	public String toString() {
		return "Assemblyman [manId=" + manId + ", name=" + name + ", imgUrl="
				+ imgUrl + ", orgImg=" + orgImg + ", partyId=" + partyId
				+ ", partyName=" + partyName + ", localConstituency="
				+ localConstituency + "]";
	}

}
