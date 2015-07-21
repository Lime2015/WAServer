package mapper;

import java.util.List;

import vo.reply.Replybill;

public interface ReplybillMapper {

	public int insert(Replybill reply);

	public int update(Replybill reply);

	public Replybill selectReplybill(int reply_id);

	public List<Replybill> selectList();

}
