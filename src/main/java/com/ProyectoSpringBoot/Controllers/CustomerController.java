package com.ProyectoSpringBoot.Controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.ProyectoSpringBoot.domain.Customer;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	   private List<Customer> customers = new ArrayList<>(Arrays.asList(
			   new Customer(1, "Claudio Gomez", "Ivancho", "pepsi"),
			   new Customer(2, "Paula Arzamendia", "gordins", "cocacola"),
			   new Customer(3, "Hernan Aguirre", "Largui", "fanta"),
			   new Customer                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           (4, "Olga Vilaqui", "mama", "sprite")
			   ));                                                                                                                 
	   
	   
	   //Obtener tabla customer
	   
	// @RequestMapping(method = RequestMethod.GET)
	   @GetMapping
	   public List<Customer> getCustomers() {    
		   return customers;
	   }
	   
	 //Obtener tabla customer por nombre de usuario
     //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	   @GetMapping("/{username}")
	   public Customer getCliente(@PathVariable String username) {
          for(Customer c: customers) {
        	  if(c.getUsername().equalsIgnoreCase(username)) {
        		  return c;
        	  }
          }
          return null;
	   }
       
      //Añadir nuevo cliente a la tabla customer
      //@RequestMapping(method = RequestMethod.POST)
	   @PostMapping
	   public Customer postCustomer(@RequestBody Customer customer) {
    	   customers.add(customer);
    	   return customer;
       }
       
       // Modificar datos del cliente 
       //@RequestMapping(method = RequestMethod.PUT)
	   @PutMapping
	   public Customer putCustomer(@RequestBody Customer customer) {
    	   for(Customer c: customers) {
    		   if(c.getID() == customer.getID()) {
    			   c.setName(customer.getName());
    			   c.setUsernmae(customer.getUsername());
    			   c.setPassword(customer.getPassword());
    			   return c;
    		   }
    	   }
    	   return null;
       }
       
       // Eliminar cliente mediente el id
       // @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	   @DeleteMapping("/{id}")
	   public Customer deleteCustomer(@PathVariable int id) {
    	   for(Customer c: customers) {
    		   if(c.getID() == id) {
    			   customers.remove(c);
    			   return c;
    		   }
    	   }
    	   return null;
       }
       
       // Modificar datos del cliente pero con una instancia especifica
       // @RequestMapping(method = RequestMethod.PATCH)
	   @PatchMapping
	   public Customer patchCustomer(@RequestBody Customer customer) {
    	   for(Customer c: customers) {
    		   if(c.getID() == customer.getID()) {
    			   if(customer.getName() != null) {
    				   c.setName(customer.getName());
    			   }
    			   if(customer.getUsername() != null) {
    				   c.setUsernmae(customer.getUsername());
    			   }
    			   if(customer.getPassword() != null) {
    				   c.setPassword(customer.getPassword());
    			   }
    			   return c;
    		   }
    	   }
    	   return null;
       }
}
