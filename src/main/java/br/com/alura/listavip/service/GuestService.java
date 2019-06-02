package br.com.alura.listavip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listavip.model.Guest;
import br.com.alura.listavip.repository.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
	private GuestRepository guestRepository;
	
	public List<Guest> findAll() {
		return guestRepository.findAll();
	}
	
	public void save(Guest guest) {
		guestRepository.saveAndFlush(guest);
	}

}
