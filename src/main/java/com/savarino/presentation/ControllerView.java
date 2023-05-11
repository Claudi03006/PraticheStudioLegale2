package com.savarino.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ControllerView {
	
	@GetMapping("/login")
	public String home() {
		return "index";
	}
	@GetMapping("/vediClienti")
	public String viewClienti() {
		return "listaClienti";
	}
	@GetMapping("/vediPratiche")
	public String view() {
		return "listaPratiche";
	}

}
