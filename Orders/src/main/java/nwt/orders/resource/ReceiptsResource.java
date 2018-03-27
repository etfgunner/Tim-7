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
	
	@GetMapping("/get/{id}")
	public Receipt getReceiptById(@PathVariable(value = "id") Long receiptId) throws NotFoundException {
	    return receiptsRepository.findById(receiptId).orElseThrow(() -> new NotFoundException("Receipt with given id not found"));
	}
	
	@PutMapping("update/{id}")
	public Receipt updateReceipt(@PathVariable(value = "id") Long receiptId,
	                                        @Valid @RequestBody Receipt receiptUpdated) throws NotFoundException {

	    Receipt receipt = receiptsRepository
	    		.findById(receiptId)
	    		.orElseThrow(
	    				() -> new NotFoundException("Receipt with given id not found")
	    				);
	    DateValidator.validateDate(receiptUpdated.getDateCreated());
	    receipt.setDateCreated(receiptUpdated.getDateCreated());
	    receipt.setDiscount(receiptUpdated.getDiscount());
	    receipt.setPrice(receiptUpdated.getPrice());
	    receipt.setRental(receiptUpdated.getRental());
	    receipt.setTransactionNumber(receiptUpdated.getTransactionNumber());
	    

	    Receipt updatedReceipt = receiptsRepository.save(receipt);
	    return updatedReceipt;
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long receiptId) throws NotFoundException {
	    Receipt Receipt = receiptsRepository.findById(receiptId)
	            .orElseThrow(() -> new NotFoundException("Receipt with given id not found"));

	    receiptsRepository.delete(Receipt);

	    return ResponseEntity.ok().build();
	}
	@PostMapping(value="/insert")
	public Receipt createReceipt(@Valid @RequestBody final Receipt receipt){
	DateValidator.validateDate(receipt.getDateCreated());
	 return receiptsRepository.save(receipt);
		//return receiptsRepository.findAll();		
	}
	@GetMapping(value="/price/{price}")
	public List<Receipt> receiptsWithPriceLessThan(@PathVariable("price") Double price){
		return receiptsRepository.findByPriceLessThan(price);
	}
	
	
}
