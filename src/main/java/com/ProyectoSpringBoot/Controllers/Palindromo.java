package com.ProyectoSpringBoot.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Palindromo {
     
	@GetMapping("/validar-palindromo/{palabra}")
	public String validar(@PathVariable String palabra) {
		return validarPalindromo(palabra) ? palabra + " SI es palindromo": palabra + " NO es palindromo";
	}
	
	public boolean validarPalindromo(String palabra) {
		int primero = 0;
		int ultimo = palabra.length() - 1;
		while(primero < ultimo) {
			if(palabra.charAt(primero) != palabra.charAt(ultimo)) {
				return false;
			}
			primero++;
			ultimo--;
		}
		return true;
	}
}
