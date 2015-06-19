package jaxb;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import vo.Assemblyman;
import vo.AssemblymanList;
import vo.Assemblymen;

public class TestAssemblyMarshing {
	
	static Assemblymen assemblyList = new Assemblymen();
	static 
	{
		assemblyList.setAssemblymanList(new ArrayList<Assemblyman>());
		
		Assemblyman man = new Assemblyman();
		man.setAssemblyman_id(20);
		man.setAssemblyman_name("강대진");
		man.setImage_url("http://url");
		man.setOrg_image_url("org_image_url");
		man.setParty_id(3);
		man.setParty_name("노동당");
		man.setLocal_constituency("서울특별시");
		
		assemblyList.getAssemblymanList().add(man);
	}
	
	public static void main(String[] args) throws JAXBException { 
	
		marshalingExample();
		System.out.println("************************************************");
		unMarshalingExample();
	}

	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(AssemblymanList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AssemblymanList manList = (AssemblymanList) jaxbUnmarshaller.unmarshal( new File("c:/temp/assemblymen.xml") );
		
		for(Assemblyman man : manList.getAssemblymanList())
		{
			System.out.println(man.getAssemblyman_id());
			System.out.println(man.getAssemblyman_name());
		}
	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(assemblyList, System.out);
		jaxbMarshaller.marshal(assemblyList, new File("c:/temp/assemblymen.xml"));
	}

}
