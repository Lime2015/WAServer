package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.UserService;
import vo.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="TestDAO.do", method = RequestMethod.GET)
	public ModelAndView TestDAO(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		
		User user = new User();
		user.setUserId("20");
		user.setUserName("rohan");
		user.setUserStatus("save");
		
		System.out.println("TestDAO" + user);
		
		userService.insert(user);
		mv.setViewName("ViewTestDAO");		
		request.setAttribute("result", "complete insert!!");
		return mv;
	}

	// saveUsers.do
	@RequestMapping(value = "saveUsers.do", method = RequestMethod.GET)
	public void saveUsers(String usersJSON, HttpServletResponse response, HttpServletRequest request) {

		System.out.println("saveUsers.do");

//		usersJSON = request.getParameter("usersJSON");
		System.out.println("usersJSON:" + usersJSON);
		
//		String test = "[{\"userStatus\":\"no\",\"userName\":\"eekek\",\"userId\":\"eekek\"},{\"userStatus\":\"no\",\"userName\":\"namnam\",\"userId\":\"namnam\"}]";
//		System.out.println("test:" + test);

		Gson gson = new GsonBuilder().create();
		List<User> userList = new ArrayList<User>();

		userList = gson.fromJson(usersJSON, new TypeToken<List<User>>(){}.getType());

		System.out.println("gson.fromJson complete");
		
		for (int idx = 0; idx < userList.size(); idx++) {
			userList.get(idx).setUserStatus("saved");
			
			User user = userService.selectUser(userList.get(idx).getUserId());
			if(user == null)
				userService.insert(userList.get(idx));
		}

		try {
			PrintWriter writer = response.getWriter();
			String result = gson.toJson(userList);

			System.out.println("result:" + result);

			writer.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
