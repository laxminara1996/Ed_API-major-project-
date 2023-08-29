package in.laxmi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.laxmi.binding.EdResponse;
import in.laxmi.service.EligServcie;

@RestController
public class EdRestController {
	@Autowired
	private EligServcie service;

	@GetMapping("/elig-determine/{caseNum}")
	public ResponseEntity<EdResponse> determineElig(@PathVariable Long caseNum) {
		EdResponse response = service.determineEligibility(caseNum);
		return new ResponseEntity<EdResponse>(response, HttpStatus.OK);
	}
    
	public ResponseEntity<String> generateCo(Long caseNum){
		boolean status = service.generateCo(caseNum);
	if(status) {
		return new ResponseEntity<String>("Notice generated",HttpStatus.OK);
	}else {
		return new ResponseEntity<String>("Notice not generated",HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	}
}
