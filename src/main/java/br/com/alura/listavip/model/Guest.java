package br.com.alura.listavip.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "GUESTS")
@Data
@AllArgsConstructor
public class Guest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String telephone;
	
	public Guest() {
		super();
	}
	
	public Guest(String name, String email, String telephone) {
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}
	
}
