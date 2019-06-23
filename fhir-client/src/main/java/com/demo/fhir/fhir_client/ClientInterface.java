package com.demo.fhir.fhir_client;

import java.util.List;

import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.DeviceDefinition;
import org.hl7.fhir.r4.model.DeviceMetric;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.rest.annotation.Delete;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.ResourceParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.annotation.Update;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IRestfulClient;


public interface ClientInterface extends IRestfulClient{

	//example
	@Search
    public List<Patient> getPatient(@RequiredParam(name = Patient.SP_FAMILY) StringDt theFamilyName);
	
	//obtener Device
	@Read
	Device readDevice(@IdParam IdType theId);
	
	//obtener DeviceDefinition
	@Read
	DeviceDefinition readDeviceDefinition(@IdParam IdType theId);
	
	//obtener Observation
	@Read
	Observation readObservation(@IdParam IdType theId);
	
	//obtener DeviceMetric
	@Read
	DeviceMetric readDeviceMetric(@IdParam IdType theId);
	
	//obtener Organization
	@Read
	Organization readOrganization(@IdParam IdType theId);
	
	//obtener Patient
	@Read
	Patient readPatient(@IdParam IdType theId);
	
	
	//actualizar Device
	@Update
	public abstract MethodOutcome updateDevice(@IdParam IdType theId, @ResourceParam Device theDevice);
	
	//actualizar DeviceDefinition
	@Update
	public abstract MethodOutcome updateDeviceDefinition(@IdParam IdType theId, @ResourceParam DeviceDefinition theDeviceDefinition);
	
	//actualizar Observation
	@Update
	public abstract MethodOutcome updateObservation(@IdParam IdType theId, @ResourceParam Observation theObservation);
	
	//actualizar DeviceMetric
	@Update
	public abstract MethodOutcome updateDeviceMetric(@IdParam IdType theId, @ResourceParam DeviceMetric theDeviceMatric);
	
	//actualizar Organization
	@Update
	public abstract MethodOutcome updateOrganization(@IdParam IdType theId, @ResourceParam Organization theOrganization);
	
	//actualizar Patient
	@Update
	public abstract MethodOutcome updatePatient(@IdParam IdType theId, @ResourceParam Patient thePatient);
	
	
	
	
	
	
	//borrar DeviceDefinition
		@Delete(type=DeviceDefinition.class)
		public void deleteDeviceDefinition(@IdParam IdType theId);
		/*
	//borrar Device
	@Delete()
	public void deleteDevice(@IdParam IdType theId);
	
	
	
	//borrar Observation
	@Delete
	public void deleteObservation(@IdParam IdType theId);
	
	//borrar DeviceMetric
	@Delete
	public void deleteDeviceMetric(@IdParam IdType theId);
	
	//borrar Organization
	@Delete
	public void deleteOrganization(@IdParam IdType theId);
	
	//borrar Patient
	@Delete
	public void deletePatient(@IdParam IdType theId);
	*/
}
