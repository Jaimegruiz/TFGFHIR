package com.example.demo;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.DeviceMetric;
import org.hl7.fhir.r4.model.Observation;

/**
 * Esta clase es devuelta por algunos métodos de la clase Bridge, al tener que devolver más de un objeto.
 * 
 * @author jaimegonzalezruiz
 *
 */
public class ReturnBundle {
	Device device;
	Observation obs;
	DeviceMetric metric;
	
	public ReturnBundle(Device device,Observation obs,DeviceMetric metric) {
		this.device = device;
		this.obs = obs;
		this.metric = metric;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Observation getObs() {
		return obs;
	}

	public void setObs(Observation obs) {
		this.obs = obs;
	}

	public DeviceMetric getMetric() {
		return metric;
	}

	public void setMetric(DeviceMetric metric) {
		this.metric = metric;
	}
	
	
}
