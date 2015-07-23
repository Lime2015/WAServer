package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.AssemblymanService;
import service.TagService;

@Controller
public class TagController {
	private TagService service;
	

	@Autowired
	public void setService(TagService service) {
		this.service = service;
	}
	
	// //////////////////////////////////////////////////////////////

	// check MemberInfo
	@RequestMapping(value = "checkTag.do")
	public void requestAssemblyman(HttpServletResponse response) {
		service.checkTag(response);
	}
	
}
