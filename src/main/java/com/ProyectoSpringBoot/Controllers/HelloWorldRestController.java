package com.ProyectoSpringBoot.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
         
	
	@GetMapping({"/hello", "/hola", "/hi"})
	public String HelloWorld() {
		System.out.println("Solicitud ejecutada");
		return "Hola mundo";
	}
	
	
}
