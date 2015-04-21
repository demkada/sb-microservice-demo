package org.thesoftwarecraftsman.demo.sbOrderService.restAPI;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.client.RestTemplate;

@Named
@Path("/")
public class OrderAPI {
	private long id = 1;
	
	@Inject
	private RestTemplate restTemplate;
	
	@GET
	@Path("order")
	@Produces(MediaType.APPLICATION_JSON)
	public Order submitOrder(@QueryParam("idCustomer") long idCustomer,
			@QueryParam("idProduct") long idProduct,
			@QueryParam("amount") long amount) {
		
		Order order = new Order();
		
		Customer customer = (Customer) restTemplate.getForObject(
				"http://localhost:7001/customer?id={id}", Customer.class,
				idCustomer);
		
		Product product = (Product) restTemplate.getForObject(
				"http://localhost:7002/product?id={id}", Product.class,
				idProduct);
		
		order.setAmount(amount);
		order.setCustomer(customer);
		order.setDateOrder(new Date());
		order.setId(id);
		order.setProduct(product);
		
		id++;
		return order;
	}
}
