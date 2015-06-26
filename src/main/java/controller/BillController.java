package controller;

import java.io.File;

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

import service.BillService;
import vo.bill.Bill;
import vo.bill.BillAssemblyman;
import vo.bill.BillInfo;

@Controller
public class BillController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AssemblymanController.class);

	private BillService billService;
	static BillInfo billInfo = new BillInfo();

	@Autowired
	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	// saveBill.do
	@RequestMapping(value = "saveBill.do", method = RequestMethod.GET)
	public void saveAssemblyman(String xmlUrl, HttpServletResponse response,
			HttpServletRequest request) throws JAXBException {

		System.out.println("saveBill.do");

		// xmlUrl = request.getParameter("xmlUrl");
		System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println("unMarshingFinish : " + billInfo);

		for (BillAssemblyman man : billInfo.getAssemblymen()) {
			
			System.out.println(man);
			Integer assemblyman_id = man.getAssemblyman_id();
			
			for(Bill bill : man.getBills()){
				bill.setAssemblyman_id(assemblyman_id);
				System.out.println("meeting assembly_id : "+ bill.getAssemblyman_id());
				//billService.insert(bill);
				try{
					billService.insert(bill);
				} catch(Exception e) {
					billService.update(bill);
				}
			}
		}
	}
	
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectAssemblyman.do
/*	@RequestMapping(value = "selectAssemblyman.do", method = RequestMethod.GET)
	public ModelAndView selectAssemblyman(int manId,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		Assemblyman assemblyman = assemblymanService.selectAssemblyman(manId);
		System.out.println("AssemblymanId" + manId);

		mv.setViewName("viewAssemblyman");
		mv.addObject("result", assemblyman);
		return mv;
	}*/

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListAssemblyman.do
/*	@RequestMapping(value = "selectListAssemblyman.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<Assemblyman> assemblymen = assemblymanService.selectList();
		System.out.println("Assemblymen : " + assemblymen);

		mv.setViewName("viewAssemblymanList");
		mv.addObject("list", assemblymen);
		return mv;
	}*/

	// ////////////////////////////////////////////////////////////
	private static void unMarshalingExample(String url) throws JAXBException {
		String xmlUrl = url;
		File file = new File(xmlUrl);
		JAXBContext jaxbContext = JAXBContext.newInstance(BillInfo.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		BillInfo assemblymanLsit = (BillInfo) jaxbUnmarshaller.unmarshal(file);
		billInfo = null;
		billInfo = assemblymanLsit;
		for (BillAssemblyman man : assemblymanLsit.getAssemblymen()) {
			System.out.println(man.getAssemblyman_id());
			System.out.println(man.getBills());
		}

	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(BillInfo.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(billInfo, System.out);
		jaxbMarshaller
				.marshal(billInfo, new File("c:/temp/assemblymen.xml"));
	}



}
