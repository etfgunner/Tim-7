package nwt.orders.resource;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.omg.CosNaming.NamingContextPackage.NotFoundHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import nwt.orders.DateValidator;
import nwt.orders.model.Rental;
import nwt.orders.repository.RentalsRepository;

@RestController
@RequestMapping(value="/rest/rentals")
public class RentalsResource {

	@Autowired 
	RentalsRepository rentalsRepository;
	
	@GetMapping(value="/all")
	public List<Rental> getAll(){
		return rentalsRepository.findAll();
	}
	@GetMapping("/get/{id}")
	public Rental getRentalById(@PathVariable(value = "id") Long rentalId) throws NotFoundException {
	    return rentalsRepository.findById(rentalId).orElseThrow(() -> new NotFoundException("Rental with given id not found"));
	}
	@PutMapping("update/{id}")
	public Rental updateRental(@PathVariable(value = "id") Long rentalId,
	                                        @Valid @RequestBody Rental rentalUpdated) throws NotFoundException {

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
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long rentalId) throws NotFoundException {
	    Rental rental = rentalsRepository.findById(rentalId)
	            .orElseThrow(() -> new NotFoundException("Rental with given id not found"));

	    rentalsRepository.delete(rental);

	    return ResponseEntity.ok().build();
	}
	@PostMapping(value="/insert")
	public Rental createRental(@Valid @RequestBody final Rental rental){
	 DateValidator.validateDate(rental.getDateRented());
	 DateValidator.compareDates(rental.getDateFrom(), rental.getDateTo());
	 return rentalsRepository.save(rental);
		//return rentalsRepository.findAll();		
	}
	@GetMapping("/before/{date}")
	public List<Rental> getRentalsBefore(@PathVariable(value = "date") String date) {
		@SuppressWarnings("deprecation")
		Date date1=new Date(date.replace('-','/'));
	    return rentalsRepository.findByDateRentedBefore(date1);
	}
	@GetMapping("/after/{date}")
	public List<Rental> getRentalsAfter(@PathVariable(value = "date") String date) {
		@SuppressWarnings("deprecation")
		Date date1=new Date(date.replace('-','/'));
	    return rentalsRepository.findByDateRentedAfter(date1);
	}
}
