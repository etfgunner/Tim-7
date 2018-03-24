package nwt.orders.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nwt.orders.model.Receipt;
import nwt.orders.repository.ReceiptsRepository;

@RestController
@RequestMapping(value="/rest/receipts")
public class ReceiptsResource {
	
	@Autowired
	ReceiptsRepository receiptsRepository;
	
	@GetMapping(value="/all")
	public List<Receipt> getAll(){
		return receiptsRepository.findAll();
	}
	@PostMapping(value="/load")
	public List<Receipt> persist(@RequestBody final Receipt receipt){
		receiptsRepository.save(receipt);
		return receiptsRepository.findAll();		
	}
}
