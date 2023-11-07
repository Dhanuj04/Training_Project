package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Policy;
import com.service.PolicyService;


@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;
    

    public PolicyController(PolicyService policyService) {
		super();
		this.policyService = policyService;
	}
    
	@PostMapping("/add")
	public ResponseEntity<Policy> savePolicy(@RequestBody Policy policy)
	{
		return new ResponseEntity<Policy>(policyService.savePolicy(policy),HttpStatus.CREATED);
		
	}
	

    @GetMapping()
    public List<Policy> getAllPolicies() {
    	return policyService.getAllPolicies();
    }

	@GetMapping("/{policyId}")
    public ResponseEntity<Policy> getPolicy(@PathVariable("policyId") Long policyId) {
        
        return new ResponseEntity<Policy>(policyService.getPolicyById(policyId),HttpStatus.OK);
    }

	
	@PutMapping("/{policyId}")
	public ResponseEntity<Policy> updatePolicy(@PathVariable("policyId")long id, @RequestBody Policy policy)
	{
		
		return new ResponseEntity<Policy>(policyService.updatePolicy(policy, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{policyId}")
	public ResponseEntity<String> deletePolicy(@PathVariable("policyId")long id)
	{
		policyService.deletePolicy(id);
		return new ResponseEntity<String>("Policy Deleted Successfully",HttpStatus.OK);
	}

	

	

}