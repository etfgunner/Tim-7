package nwt.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nwt.orders.model.Rental;


public interface RentalsRepository extends JpaRepository<Rental, Long> {

}