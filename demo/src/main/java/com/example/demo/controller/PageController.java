package com.example.demo.controller;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = {"/greeting", "/greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "apap");
		}

		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian(
			@RequestParam(value = "a", required = false, defaultValue = "0") int a, 
			@RequestParam(value = "b", required = false, defaultValue = "0") int b,
			Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		int c = a * b;
		model.addAttribute("c", c);
		
		return "perkalian";
	}
}