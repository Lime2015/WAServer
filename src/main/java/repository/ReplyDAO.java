package repository;

import java.util.List;

import mapper.ReplyMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.reply.Reply;

@Component
public class ReplyDAO {
	
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
/////////////////////////////////////////////////////////////////////////
	
	public int insert(Reply reply) {
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		return mapper.insert(reply);
		
	}

	public int update(Reply reply) {
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		return mapper.update(reply);
		
	}

	public List<Reply> selectList() {
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		return mapper.selectList();
		
	}

	public Reply selectReply(int reply_id) {
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		return mapper.selectReply(reply_id);
	}

}
