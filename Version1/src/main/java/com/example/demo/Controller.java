package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Este controlador captura los mensajes POST a http://localhost:8080/devicemodel y a http://localhost:8080/device. Obtiendo los datos del cuerpo del mensaje.
 * A continuación, usa un objeto de la clase FhiCaller para transformar y enviar los datos a un servidor Fhir.
 * 
 * @author jaimegonzalezruiz
 *
 */
@RestController
public class Controller {

	
	@Autowired
	FhirCaller apiCaller;

    @PostMapping(value = "/devicemodel",
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			})
	public ResponseEntity<HttpStatus> deviceModelUpdate(@RequestBody DeviceModelUpdate update) {
    	
    	apiCaller.callFhir(update);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
		
	}
    @PostMapping(value = "/device",
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			})
	public ResponseEntity<HttpStatus> deviceUpdate(@RequestBody DeviceUpdate update) {

		apiCaller.callFhir2(update);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
    
    
}  