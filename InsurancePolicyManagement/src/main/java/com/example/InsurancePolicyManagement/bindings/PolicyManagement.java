package com.example.InsurancePolicyManagement.bindings;

import com.example.InsurancePolicyManagement.datamodel.Policies;
import com.example.InsurancePolicyManagement.datamodel.PolicyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.util.List;

@Api(value = "Insurance Policy Management", description = "Insurance Policy Management")
@RestController
@CrossOrigin("*")
@RequestMapping("/policies")
public class PolicyManagement {

	@Autowired
	private PolicyManagementService policyManagementService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity savepolicies(@RequestBody Policies policies) {
		PolicyConfiguration policyConfiguration = policyManagementService.savePolicy(policies);
		return new ResponseEntity(policyConfiguration, HttpStatus.OK);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity getpolicies(@RequestBody Policies policies) {
		PolicyConfiguration policybynumber = policyManagementService.getPolicybynumber(policies);
		return new ResponseEntity(policybynumber, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllpolicies", method = RequestMethod.GET)
	public ResponseEntity getAllpolicies() {
		List<PolicyConfiguration> policybynumber = policyManagementService.getAllPolicy();
		return new ResponseEntity(policybynumber, HttpStatus.OK);
	}

	@RequestMapping(value = "/deletePolicy", method = RequestMethod.DELETE)
	@Transactional
	@CrossOrigin("*")
	public ResponseEntity<Boolean> deletePolicy(String id) {
		Boolean aBoolean = policyManagementService.deletePolicy(id);
		return new ResponseEntity(aBoolean, HttpStatus.OK);
	}

	@RequestMapping(value = "/updatePolicy", method = RequestMethod.PUT)
	public ResponseEntity updatePolicy(@RequestBody Policies policies) {
	PolicyConfiguration policyConfiguration = policyManagementService.updatePolicy(policies);
		return new ResponseEntity(policyConfiguration, HttpStatus.OK);
	}





}
