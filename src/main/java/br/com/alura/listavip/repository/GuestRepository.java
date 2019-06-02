package br.com.alura.listavip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.listavip.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
