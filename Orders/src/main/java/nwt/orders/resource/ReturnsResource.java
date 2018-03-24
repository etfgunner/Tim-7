package nwt.orders.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@PostMapping(value="/load")
	public List<Returns> persist(@RequestBody final Returns returns){
		returnsRepository.save(returns);
		return returnsRepository.findAll();		
	}
}
