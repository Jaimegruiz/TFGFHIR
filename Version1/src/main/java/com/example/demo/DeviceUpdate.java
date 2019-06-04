package com.example.demo;
import java.util.List;
/**
 * Orion de Fiware envía en este formato los datos ,en el body del mensaje POST, cuando se produce un cambio en algún Device.
 * Esta clase sirve para parsear ese mensaje.
 * @author jaimegonzalezruiz
 *
 */
public class DeviceUpdate {
	private String subscriptionId;
	private List<DeviceFiw> data;
	
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public List<DeviceFiw> getData() {
		return data;
	}
	public void setData(List<DeviceFiw> data) {
		this.data = data;
	}
	
}
