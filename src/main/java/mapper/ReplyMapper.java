package mapper;

import java.util.List;

import vo.reply.Reply;

public interface ReplyMapper {

	public int insert(Reply reply);
	public int update(Reply reply);
	public Reply selectReply(int reply_id);
	public List<Reply> selectList();

}
