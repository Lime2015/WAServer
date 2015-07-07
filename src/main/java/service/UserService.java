package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.UserDao;
import vo.User;

@Component
public class UserService {
	
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public int insert(User user){
		return userDao.insert(user);
	}
	
	public int update(User user){
		return userDao.update(user);
	}

	public User selectUser(String userId){
		return userDao.selectUser(userId);
	}
	
	public List<User> selectList(){
		return userDao.selectList();
	}
}
