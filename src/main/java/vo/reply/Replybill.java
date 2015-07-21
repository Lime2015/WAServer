package vo.reply;

public class Replybill {

	private String assemblyman_id;
	private int member_id;
	private String member_img;
	private String modt;
	private String comment;
	private int report;
	
	
	public Replybill() {}
	

	public Replybill(String assemblyman_id, int member_id, String member_img,
			String modt, String comment, int report) {
		super();
		this.assemblyman_id = assemblyman_id;
		this.member_id = member_id;
		this.member_img = member_img;
		this.modt = modt;
		this.comment = comment;
		this.report = report;
	}
	
	public String getAssemblyman_id() {
		return assemblyman_id;
	}
	public void setAssemblyman_id(String assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getMember_img() {
		return member_img;
	}
	public void setMember_img(String member_img) {
		this.member_img = member_img;
	}
	public String getModt() {
		return modt;
	}
	public void setModt(String modt) {
		this.modt = modt;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "Reply [assemblyman_id=" + assemblyman_id + ", member_id="
				+ member_id + ", member_img=" + member_img + ", modt=" + modt
				+ ", comment=" + comment + ", report=" + report + "]";
	}
	

}
