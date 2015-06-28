package controller;

import java.io.File;
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
		System.out.println("xmlUrl:" + xmlUrl);

		unMarshalingExample(xmlUrl);
		System.out.println("unMarshingFinish : " + billInfo);

		for (BillAssemblyman man : billInfo.getAssemblymen()) {
			
			logger.info("man :", man);
			Integer assemblyman_id = man.getAssemblyman_id();
			
			for(Bill bill : man.getBills()){
				
				//bill 마다 assemblyman_id 를 추가 입력
				bill.setAssemblyman_id(assemblyman_id);
				System.out.println("assemblyman_id : " + bill.getAssemblyman_id());
				
				try{
					//처음 insert update_tag = 1
					bill.setUpdate_tag(1);
					billService.insert(bill);
					
				} catch(Exception e) {

					Integer bill_no = bill.getBill_no();
					Integer ver = billService.selectBill(bill_no).getUpdate_tag();
					
					System.out.println("update ver :" + ver);
					bill.setUpdate_tag(ver + 1);
					
					billService.update(bill);
				}
			}
		}
	}
	
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectBill.do
	@RequestMapping(value = "selectBill.do", method = RequestMethod.GET)
	public ModelAndView selectAssemblyman(int bill_id, 
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		Bill bill = billService.selectBill(bill_id);
		System.out.println("bill_id" + bill_id);

		mv.setViewName("Bill");
		mv.addObject("result", bill);
		
		return mv;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	// selectListBill.do
	@RequestMapping(value = "selectListBill.do", method = RequestMethod.GET)
	public ModelAndView selecList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		List<Bill> bills = billService.selectList();
		System.out.println("bills : " + bills);

		mv.setViewName("billList");
		mv.addObject("list", bills);
		return mv;
	}

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
