package com.demo.fhir.fhir_client;

import java.math.BigDecimal;
import java.util.List;

import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.rest.client.api.IRestfulClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FhirContext ctx = FhirContext.forR4();
        String serverBase = "http://test.fhir.org/r4";
        
        ClientInterface client = ctx.newRestfulClient(ClientInterface.class,serverBase);
        /*
       List<Patient> patients = client.getPatient(new StringDt("Levin"));
       System.out.println(patients.size());
       System.out.println(patients.get(45).getId());*/
        
       client.deleteDeviceDefinition(new IdType("DeviceDefinition","2")); 
        
    
}}

