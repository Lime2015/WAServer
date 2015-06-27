package controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.AssemblymanService;
import vo.Assemblyman;
import vo.Assemblymen;

@Controller
public class AssemblymanController {

	private static final Logger logger = LoggerFactory
			.getLogger(AssemblymanController.class);

	private AssemblymanService assemblymanService;
	static Assemblymen assemblymen = new Assemblymen();

	@Autowired
	public void setAssemblymanService(AssemblymanService assemblymanService) {
		this.assemblymanService = assemblymanService;
	}

	// saveAssemblyman.do
	@RequestMapping(value = "saveAssemblyman.do", method = RequestMethod.GET)
	public void saveAssemblyman(String xmlUrl, HttpServletResponse response,
			HttpServletRequest request) throws JAXBException {

		System.out.println("saveAssemblyman.do");
		System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println(assemblymen);

		for (Assemblyman man : assemblymen.getAssemblymen()) {
			
			// mo_dttm 을 insert 시간으로 변경
			Date date = new Date();
			man.setMod_dttm(date.toString());
			System.out.println(date.toString());
			System.out.println(man);
			
			try{
				//처음 insert update_tag = 1
				man.setUpdate_tag(1);
				assemblymanService.insert(man);
			} catch(Exception e) {
				
				Integer manId = man.getAssemblyman_id();
				Integer ver = assemblymanService.selectAssemblyman(manId).getUpdate_tag();
				
				System.out.println("update ver :" + ver);
				man.setUpdate_tag(ver + 1);
				
				assemblymanService.update(man);
			}
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectAssemblyman.do
	@RequestMapping(value = "selectAssemblyman.do", method = RequestMethod.GET)
	public ModelAndView selectAssemblyman(int manId,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		Assemblyman assemblyman = assemblymanService.selectAssemblyman(manId);
		System.out.println("AssemblymanId" + manId);

		mv.setViewName("viewAssemblyman");
		mv.addObject("result", assemblyman);
		return mv;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListAssemblyman.do
	@RequestMapping(value = "selectListAssemblyman.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<Assemblyman> assemblymen = assemblymanService.selectList();
		System.out.println("Assemblymen : " + assemblymen);

		mv.setViewName("viewAssemblymanList");
		mv.addObject("list", assemblymen);
		return mv;
	}

	// ////////////////////////////////////////////////////////////
	private static void unMarshalingExample(String url) throws JAXBException {
		String xmlUrl = url;
		File file = new File(xmlUrl);
		JAXBContext jaxbContext = JAXBContext.newInstance(Assemblymen.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Assemblymen manList = (Assemblymen) jaxbUnmarshaller.unmarshal(file);
		assemblymen = null;
		assemblymen = manList;
		for (Assemblyman man : manList.getAssemblymen()) {
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
