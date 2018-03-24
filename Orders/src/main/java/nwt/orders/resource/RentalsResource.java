package nwt.orders.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@PostMapping(value="/load")
	public List<Rental> persist(@RequestBody final Rental rental){
		rentalsRepository.save(rental);
		return rentalsRepository.findAll();		
	}
}
