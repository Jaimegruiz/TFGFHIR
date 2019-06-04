package com.example.demo;
import java.util.List;
/**
 * Orion de Fiware envía en este formato los datos ,en el body del mensaje POST, cuando se produce un cambio en algún DeviceModel.
 * Esta clase sirve para parsear ese mensaje.
 * @author jaimegonzalezruiz
 *
 */
public class DeviceModelUpdate {
	private String subscriptionId;
	private List<DeviceModel> data;
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public List<DeviceModel> getData() {
		return data;
	}
	public void setData(List<DeviceModel> data) {
		this.data = data;
	}

}
