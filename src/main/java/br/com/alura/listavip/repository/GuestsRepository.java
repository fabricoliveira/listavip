package br.com.alura.listavip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.listavip.model.Guests;

public interface GuestsRepository extends JpaRepository<Guests, Long> {

}
