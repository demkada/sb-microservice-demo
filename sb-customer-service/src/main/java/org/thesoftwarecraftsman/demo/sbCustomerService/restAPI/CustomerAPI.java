package org.thesoftwarecraftsman.demo.sbCustomerService.restAPI;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class CustomerAPI {
	
	private static List<Customer> customers = new ArrayList<Customer>();
	
	static {
		for (int i = 0; i <= 5 ; i++) {
			Customer customer = new Customer();
			customer.setId(i);
			customer.setName("Customer " + i);
			customer.setEmail("Customer" + i +"@gmail.com");
			customers.add(customer);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomers() {
		System.out.println(customers.toString());
		return customers;
	}
	
	@GET
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@QueryParam("id") long id) {
		Customer customer = null;
		
		for (Customer c : customers) {
			if (c.getId() == id)
				customer = c;
		}
		return customer;
	}
	
	@POST
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer addCustomer(@QueryParam("name") String name, @QueryParam("email") String email) {
		Customer customer = new Customer();
		customer.setId(customers.size());
		customer.setEmail(email);
		customer.setName(name);
		
		customers.add(customer);
		
		return customer;
	}
	
}
