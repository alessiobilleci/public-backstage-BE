package it.backstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import it.backstage.response.BaseResponse;
import it.backstage.response.TestResponse;
import it.backstage.service.TestService;
import it.backstage.vo.TestVO;

@Validated
@RestController
@RequestMapping("/backstage/v1/test")
public class TestController {
	@Autowired
	TestService testService;

	@GetMapping(name = "Retrieve example", value = "/example", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getExample() {
		
		TestVO exampleVO=testService.exampleService("Fabio", "Chiefari", 45L);
		TestResponse response = new TestResponse();
		response.setVo(exampleVO);
		return TestResponse.getSuccessfulRequestResponse(response,"Record Trovato",
				"Record Trovato");
		
	}
	
	@GetMapping(name = "Retrieve example error", value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getError() {
		BaseResponse response= new BaseResponse();
		response.setCode(400);
		response.setDescription("Test Errore BadRequest");
		response.setMessage("Test Errore BadRequest");
	
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
	@GetMapping(name = "Retrieve example input parameter", value = "/input", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getInput(@ApiParam(name = "limit", value = "Quantità massima di dati da individuare") 
	@RequestParam(value = "limit", required = true, defaultValue = "10") int limit) {
		BaseResponse response= new BaseResponse();
		if(limit==10) {
			response.setCode(200);
			response.setDescription("OK");
			response.setMessage("OK");
		}
		else {
			response.setCode(400);
			response.setDescription("Test Errore BadRequest");
			response.setMessage("Test Errore BadRequest");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
}
