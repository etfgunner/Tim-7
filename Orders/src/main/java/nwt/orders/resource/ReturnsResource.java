package nwt.orders.resource;

import java.util.List;

import javax.validation.Valid;

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
import nwt.orders.model.Returns;
import nwt.orders.model.Returns;
import nwt.orders.repository.ReturnsRepository;

@RestController
@RequestMapping(value="/rest/returns")
public class ReturnsResource {

	@Autowired
	ReturnsRepository returnsRepository;
	
	@GetMapping(value="/all")
	public List<Returns> getAll(){
		return returnsRepository.findAll();
	}
	@GetMapping("/get/{id}")
	public Returns getReturnsById(@PathVariable(value = "id") Long returnsId) throws NotFoundException {
	    return returnsRepository.findById(returnsId).orElseThrow(() -> new NotFoundException("Returns with given id not found"));
	}
	@PutMapping("update/{id}")
	public Returns updateReturns(@PathVariable(value = "id") Long returnsId,
	                                        @Valid @RequestBody Returns returnsUpdated) throws NotFoundException {

	    Returns returns = returnsRepository
	    		.findById(returnsId)
	    		.orElseThrow(
	    				() -> new NotFoundException("Returns with given id not found")
	    				);
	    DateValidator.validateDate(returnsUpdated.getDateReturn());
	    returns.setDateReturn(returnsUpdated.getDateReturn());
	    returns.setReason(returnsUpdated.getReason());
	    returns.setRental(returnsUpdated.getRental());

	    Returns updatedReturns = returnsRepository.save(returns);
	    return updatedReturns;
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long returnsId) throws NotFoundException {
	    Returns returns = returnsRepository.findById(returnsId)
	            .orElseThrow(() -> new NotFoundException("Returns with given id not found"));

	    returnsRepository.delete(returns);

	    return ResponseEntity.ok().build();
	}
	@PostMapping(value="/insert")
	public Returns createReturns(@Valid @RequestBody final Returns returns){
		DateValidator.validateDate(returns.getDateReturn());
	 return returnsRepository.save(returns);
		//return returnsRepository.findAll();		
	}
}
