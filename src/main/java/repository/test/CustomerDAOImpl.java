package repository.test;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import vo.test.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO {
	private DataSource dataSource;
	 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
 
	@Override
	public void create(List<Customer> cusList) {
		 String queryCustomer = "insert into Customer (id, name) values (?,?)";
	     String queryAddress = "insert into Address (id, address,country) values (?,?,?)";
	 
	     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        
	     for(Customer cus : cusList){
	     jdbcTemplate.update(queryCustomer, new Object[] { cus.getId(), cus.getName() });
	     System.out.println("Inserted into Customer Table Successfully" + cus.getId());
	     }
	        /*
	        jdbcTemplate.update(queryAddress, new Object[] { customer.getId(),
	                customer.getAddress().getAddress(),
	                customer.getAddress().getCountry() });
	        System.out.println("Inserted into Address Table Successfully");
		*/
	}
 

}
