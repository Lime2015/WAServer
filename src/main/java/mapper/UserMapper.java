package mapper;

import java.util.List;

import vo.User;

public interface UserMapper {
	public int insert(User user);
	public int update(User user);
	public List<User> selectList();
	public User selectUser(String userId);
}
