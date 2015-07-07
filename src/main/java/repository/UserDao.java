package repository;

import java.util.List;

import mapper.UserMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.User;

@Component
public class UserDao {
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	//////////////////////////////////////////////////
	
	public int insert(User user){
		UserMapper mapper=session.getMapper(UserMapper.class);
		return mapper.insert(user);
	}
	
	public int update(User user){
		UserMapper mapper=session.getMapper(UserMapper.class);
		return mapper.update(user);
	}

	public User selectUser(String userId){
		UserMapper mapper=session.getMapper(UserMapper.class);
		return mapper.selectUser(userId);
	}

	public List<User> selectList(){
		UserMapper mapper=session.getMapper(UserMapper.class);
		return mapper.selectList();
	}

}
