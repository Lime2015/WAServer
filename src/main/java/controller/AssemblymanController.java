package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.AssemblymanService;
import vo.Assemblyman;
import vo.Assemblymen;

@Controller
public class AssemblymanController {
	
	private static AssemblymanService assemblymanService;
	static Assemblymen assemblymen = new Assemblymen();
	
	@Autowired
	public void setAssemblymanService(AssemblymanService abmService) {
		this.assemblymanService = abmService;
	}
	
	// saveAssemblyman.do
		@RequestMapping(value = "saveAssemblyman.do", method = RequestMethod.GET)
		public void saveAssemblyman(String xmlUrl, HttpServletResponse response, HttpServletRequest request) throws JAXBException {

			System.out.println("saveAssemblyman.do");

//			xmlUrl = request.getParameter("xmlUrl");
			System.out.println("xmlUrl:" + xmlUrl);
			
			
			unMarshalingExample(xmlUrl);
			System.out.println(assemblymen);
			
			for(Assemblyman man : assemblymen.getAssemblymen()) {
				if(man == null){
					assemblymanService.insert(man);
				} 
			}
		}

//			Gson gson = new GsonBuilder().create();
//			List<User> userList = new ArrayList<User>();

//			userList = gson.fromJson(usersJSON, new TypeToken<List<User>>(){}.getType());

//			System.out.println("gson.fromJson complete");
			
//			for (int idx = 0; idx < assemblymen.size(); idx++) {
//				userList.get(idx).setUserStatus("saved");
				
//				User user = userService.selectUser(userList.get(idx).getUserId());
//				if(user == null)
//					userService.insert(userList.get(idx));
//			}
/*
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
		*/
		//////////////////////////////////////////////////////////////
		private static void unMarshalingExample(String url) throws JAXBException {
			String xmlUrl = url;
			File file = new File(xmlUrl);
			JAXBContext jaxbContext = JAXBContext.newInstance(Assemblymen.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Assemblymen manList = (Assemblymen) jaxbUnmarshaller.unmarshal(file);
			assemblymen = null;
			assemblymen = manList;
			for(Assemblyman man : manList.getAssemblymen())
			{
				System.out.println(man.getAssemblyman_id());
				System.out.println(man.getAssemblyman_name());
			}
			
		}

		private static void marshalingExample() throws JAXBException {
			JAXBContext jaxbContext = JAXBContext.newInstance(Assemblymen.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(assemblymen, System.out);
			jaxbMarshaller.marshal(assemblymen, new File("c:/temp/assemblymen.xml"));
		}

	

}
