package org.thesoftwarecraftsman.demo.sbProductService.restAPI;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class ProductAPI {

	private static List<Product> products = new ArrayList<Product>();

	static {
		for (int i = 0; i <= 5 ; i++) {
			Product product = new Product();
			product.setId(i);
			product.setName("Product " + i);
			product.setDesc("Product " + i + " is a programming book wich teachs you how to build modern software");
			product.setPrice(i*75.6);
			products.add(product);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
		return products;
	}

	@GET
	@Path("product")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@QueryParam("id") long id) {
		Product product = null;

		for (Product p : products) {
			if (p.getId() == id)
				product = p;
		}
		return product;
	}	
}
