package nwt.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nwt.orders.model.Receipt;

public interface ReceiptsRepository extends JpaRepository<Receipt, Long> {

}
