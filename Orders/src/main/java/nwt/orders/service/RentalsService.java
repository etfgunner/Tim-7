package nwt.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import nwt.orders.DateValidator;
import nwt.orders.model.Rental;
import nwt.orders.repository.RentalsRepository;

@Service
public class RentalsService {
	
	@Autowired
	RentalsRepository rentalsRepository;
	
	public Rental updateRental(Long rentalId, Rental rentalUpdated) throws NotFoundException {
		Rental rental = rentalsRepository
				.findById(rentalId)
				.orElseThrow(
						() -> new NotFoundException("Rental with given id not found")
						);
		DateValidator.validateDate(rentalUpdated.getDateRented());
		DateValidator.compareDates(rentalUpdated.getDateFrom(), rentalUpdated.getDateTo());
		rental.setClientId(rentalUpdated.getClientId());
		rental.setDateFrom(rentalUpdated.getDateFrom());
		rental.setDateRented(rentalUpdated.getDateRented());
		rental.setDateTo(rentalUpdated.getDateTo());
		rental.setVehicleId(rentalUpdated.getVehicleId());

		Rental updatedRental = rentalsRepository.save(rental);
		return updatedRental;
	}
	
	public Rental createRental(Rental rental) {
		DateValidator.validateDate(rental.getDateRented());
		 DateValidator.compareDates(rental.getDateFrom(), rental.getDateTo());
		 return rentalsRepository.save(rental);
	}
}
