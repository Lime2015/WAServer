package vo.reply;

public class Reply {
	
	private String assemblyman_id;
	private String member_id;
	private String member_img;
	private String modt;
	private String comment;
	
	
	public Reply() {}

	public Reply(String member_id, String member_img, String modt,
			String comment, String assemblyman_id) {
		super();
		this.member_id = member_id;
		this.member_img = member_img;
		this.modt = modt;
		this.comment = comment;
		this.assemblyman_id = assemblyman_id;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
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
	public String getAssemblyman_id() {
		return assemblyman_id;
	}
	public void setAssemblyman_id(String assemblyman_id) {
		this.assemblyman_id = assemblyman_id;
	}
	@Override
	public String toString() {
		return "reply [member_id=" + member_id + ", member_img=" + member_img
				+ ", modt=" + modt + ", comment=" + comment
				+ ", assemblyman_id=" + assemblyman_id + "]";
	}
	
	
	

}
