package br.com.alura.listavip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.listavip.model.Guests;
import br.com.alura.listavip.repository.GuestsRepository;

@Controller
public class GuestController {
	
	@Autowired
	private GuestsRepository guestsRepository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("viplist")
	public String vipList(Model model) {
		List<Guests> guests = guestsRepository.findAll();
		
		model.addAttribute("guests", guests);
		
		return "viplist";
	}

}
