package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IBudgetService;
import com.example.demo.modelo.Budget;


@Controller
@RequestMapping
public class Controler {
	
	@Autowired
	private IBudgetService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Budget>budget = service.lastTen();
		String s = service.sum();
		model.addAttribute("budgets", budget);
		model.addAttribute("suma", s);
		return "inde";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("budget", new Budget());		
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid Budget b, BindingResult bindingResult , Model model) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		if(b.getType().equals("Egreso")) {			
			b.setAmount(b.getAmount() * -1);
		}
		service.save(b);
		return "redirect:/list";
	}
	
	@GetMapping("/edit/{nrotrans}")
	public String edit(@PathVariable int nrotrans, Model model) {
		boolean isActive=false;
		if(nrotrans>0) {
			isActive = true;
		}
		Optional<Budget>budget=service.listNrotrans(nrotrans);
		model.addAttribute("isActive", isActive);
		model.addAttribute("budget", budget);
		return "form";
	}
	
	@GetMapping("/delete/{nrotrans}")
	public String delete(@PathVariable int nrotrans, Model model) {
		service.delete(nrotrans);
		return "redirect:/list";
	}	
}