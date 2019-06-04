package com.example.demo;

import java.util.List;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.DeviceDefinition;
import org.hl7.fhir.r4.model.DeviceMetric;
import org.hl7.fhir.r4.model.Observation;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
/**
 * Uso esta clase para transformar mediante la clase {@link com.example.com.Bridge} los objetos Fiware ,recibidos 
 * como consecuencia de las subscripciones a Orion, a objetos del estandar Fhir. Así como para enviar de forma 
 * asíncrona mensajes POST al servidor público <a href=""http://test.fhir.org/r4"">"http://test.fhir.org/r4"</a> con estos objetos.
 * Si el objeto no existe en el servidor "http://test.fhir.org/r4" se crea uno nuevo. Si existiera, se hace un search para obtener su id dentro
 * del servidor y a continuación se actualiza el objeto con los datos nuevos.
 * @author jaimegonzalezruiz
 *
 */
@Component
public class FhirCaller {
	public FhirContext ctx = null;
	String serverBase = "http://test.fhir.org/r4";
	
	IGenericClient client = null;
	public int init = 0;
	Bridge bridge = new Bridge();
	public HttpHeaders headers = new HttpHeaders();
	
	
	@Async
	public void callFhir(DeviceModelUpdate update) {
		//La primera vez tengo que crear el contexto y el cliente de Fhir.
		if(init==0) {
			ctx = FhirContext.forR4();
			client = ctx.newRestfulGenericClient(serverBase);
			init =1;
		}
		//Extraigo la información del body del mensaje POST de las subscripciones de Fiware.
		List<DeviceModel> aux = update.getData();
		DeviceModel devicemodel = aux.get(0);
		
		//Paso del mundo Fiware a Fhir
		DeviceDefinition devicedef=bridge.deviceModeltoFHIR(devicemodel);
		
		//Creo el objeto en el servidor fhir si no existiera ninguno con el mismo id.
		MethodOutcome outcome2 = client.create()
		        .resource(devicedef)
		        .conditional()
		        .where(DeviceDefinition.IDENTIFIER.exactly().identifier(devicemodel.getId()))
		        .execute();
		
		Boolean created = outcome2.getCreated();
		//compruebo si existía para proceder a actualizarlo 
		if(created==null) {
			System.out.println("el objeto ya existe, procedemos a actualizarlo");
			//hago una búsqueda para optener el id necesario del servidor para actualizar la información
			Bundle response = (Bundle) client.search()
					.forResource(DeviceDefinition.class)
					.where(DeviceDefinition.IDENTIFIER.exactly().identifier(devicemodel.getId()))
			        .execute();
			
			String fullUrl = response.getEntryFirstRep().getFullUrl();
			
			System.out.println(fullUrl);
			String resourdeid = fullUrl.substring(fullUrl.lastIndexOf("/"));
			
			//le asigno el id obtenido
			devicedef.setId("DeviceDefinition/"+resourdeid);
			
			//actualizo el objeto
			MethodOutcome outcome = client.update()
					   .resource(devicedef)
					   .execute();

		}
		else{
			System.out.println("nuevo objeto creado");
			System.out.println("Got ID: " + outcome2.getId().getValue());
		}
	
	}
	public void callFhir2(DeviceUpdate update) {
		if(init==0) {
			ctx = FhirContext.forR4();
			client = ctx.newRestfulGenericClient(serverBase);
			init =1;
		}
		List<DeviceFiw> aux = update.getData();
		DeviceFiw deviceFiw = aux.get(0);
		
		
		//en este caso la función devuelve 3 objetos Fhir. Device, DeviceMetric y Observation. Hago lo mismo pero 3 veces.
		ReturnBundle bundle= bridge.deviceFiwareToFhir(deviceFiw);
		Device device = bundle.getDevice();
		Observation obs = bundle.getObs();
		DeviceMetric metric = bundle.getMetric();
		

		MethodOutcome outcome2 = client.create()
		        .resource(device)
		        .conditional()
		        .where(Device.IDENTIFIER.exactly().identifier(deviceFiw.getId()))
		        .execute();
		Boolean created = outcome2.getCreated();
		if(created==null) {
			
			System.out.println("el objeto ya existe, procedemos a actualizarlo");
			
			Bundle response = (Bundle) client.search()
					.forResource(Device.class)
					.where(Device.IDENTIFIER.exactly().identifier(deviceFiw.getId()))
			        .execute();
			String fullUrl = response.getEntryFirstRep().getFullUrl();
			System.out.println(fullUrl);
			String resourdeid = fullUrl.substring(fullUrl.lastIndexOf("/"));
		
			
			
			device.setId("Device/"+resourdeid);
			MethodOutcome outcome = client.update()
					   .resource(device)
					   .execute();	
		}
		else{
			System.out.println("nuevo objeto creado");
			System.out.println("Got ID: " + outcome2.getId().getValue());
		}
		
		
		MethodOutcome outcome3 = client.create()
		        .resource(obs)
		        .conditional()
		        .where(Observation.IDENTIFIER.exactly().identifier(deviceFiw.getId()))
		        .execute();
		Boolean created3 = outcome3.getCreated();
		if(created3==null) {
			
			System.out.println("el objeto ya existe, procedemos a actualizarlo");
			
			Bundle response = (Bundle) client.search()
					.forResource(Observation.class)
					.where(Observation.IDENTIFIER.exactly().identifier(deviceFiw.getId()))
			        .execute();
			String fullUrl = response.getEntryFirstRep().getFullUrl();
			System.out.println(fullUrl);
			String resourdeid = fullUrl.substring(fullUrl.lastIndexOf("/"));
			
			obs.setId("Observation/"+resourdeid);
			MethodOutcome outcome = client.update()
					   .resource(obs)
					   .execute();	
		}
		else{
			System.out.println("nuevo objeto creado");
			System.out.println("Got ID: " + outcome3.getId().getValue());
		}

		MethodOutcome outcome4 = client.create()
		        .resource(metric)
		        .conditional()
		        .where(DeviceMetric.IDENTIFIER.exactly().identifier(deviceFiw.getId()))
		        .execute();
		Boolean created4 = outcome4.getCreated();
		if(created4==null) {
			
			System.out.println("el objeto ya existe, procedemos a actualizarlo");
			
			Bundle response = (Bundle) client.search()
					.forResource(DeviceMetric.class)
					.where(DeviceMetric.IDENTIFIER.exactly().identifier(deviceFiw.getId()))
			        .execute();
			String fullUrl = response.getEntryFirstRep().getFullUrl();
			System.out.println(fullUrl);
			String resourdeid = fullUrl.substring(fullUrl.lastIndexOf("/"));
			//System.out.println(resourdeid);
			
			
			metric.setId("DeviceMetric/"+resourdeid);
			MethodOutcome outcome = client.update()
					   .resource(metric)
					   .execute();	
		}
		else{
			System.out.println("nuevo objeto creado");
			System.out.println("Got ID: " + outcome4.getId().getValue());
		}
	}
}
