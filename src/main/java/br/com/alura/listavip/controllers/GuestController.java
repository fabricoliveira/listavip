package br.com.alura.listavip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emailsender.service.EmailService;

import br.com.alura.listavip.model.Guest;
import br.com.alura.listavip.service.GuestService;

@Controller
@RequestMapping("/")
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@RequestMapping("viplist")
	public String vipList(Model model) {
		List<Guest> guests = guestService.findAll();
		
		model.addAttribute("guests", guests);
		
		return "viplist";
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(@RequestParam String name, @RequestParam String email, @RequestParam String telephone) {
		Guest guest = new Guest(name, email, telephone);
		guestService.save(guest);
				
		String subject = "Invite to Code";
		
		StringBuilder message = new StringBuilder();
		message.append("<h1>Olá " + name + ", </h1>");
		message.append("<h3>");
		message.append("Você acabou de receber o convite para o curso de programação. <br> Te espero lá!");
		message.append("</h3>");
		
		EmailService emailService = new EmailService();
		emailService.sendEmail(email, subject, message.toString());
		
		return "redirect:viplist";
	} 

}
