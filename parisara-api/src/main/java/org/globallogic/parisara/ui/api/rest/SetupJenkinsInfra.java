package org.globallogic.parisara.ui.api.rest;

import java.util.Arrays;

import org.globallogic.parisara.ui.api.rest.services.CommandParameters;
import org.globallogic.parisara.ui.api.rest.services.JenkinsPlaybookServices;
import org.globallogic.parisara.ui.api.rest.services.KeyValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetupJenkinsInfra {
	
	@Autowired
	JenkinsPlaybookServices jenkinsServices;
	
	@GetMapping("/buildInstance")
	public ResponseEntity buildJenkinsInstance(@RequestParam(value = "hostName") String jenkisnVMHostName) {
		
		CommandParameters commandParameters = new CommandParameters();
		commandParameters.setEnvVars(Arrays.asList(new KeyValuePair("hostName", jenkisnVMHostName)));
		
		if(jenkinsServices.executePlayBook(commandParameters)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
	}
}
