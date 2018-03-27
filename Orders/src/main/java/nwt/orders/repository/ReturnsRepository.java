package nwt.orders.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nwt.orders.model.Returns;

public interface ReturnsRepository extends JpaRepository<Returns, Long> {
	List<Returns> findByDateReturnBefore(Date date);
}