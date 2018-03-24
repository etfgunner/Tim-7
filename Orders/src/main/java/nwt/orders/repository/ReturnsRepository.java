package nwt.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nwt.orders.model.Returns;

public interface ReturnsRepository extends JpaRepository<Returns, Long> {

}