package com.example.demo;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orange.ngsi2.model.Entity;
import com.orange.ngsi2.model.Attribute;;

/**
 * Esta clase sirve para convertir el formato json simplificado al formato ngsi2, sirve para Device y DeviceModel de Fiware.
 * 
 * @author jaimegonzalezruiz
 *
 */

public class NgsiParser {
	
	
	public NgsiParser() {
		
	}
	
	public String deviceModelAdapter(String jsonDeviceModel){
		
		Entity entity = null;
		HashMap<String,Attribute> attributes = new HashMap<String, Attribute>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		DeviceModel deviceModel = gson.fromJson(jsonDeviceModel, DeviceModel.class); 
		
		if (deviceModel.hasId() && deviceModel.hasType() ) {
			entity = new Entity(deviceModel.getId(),deviceModel.getType());
			
		}
		else {
			//son los dos esenciales
			return null;
		}
		
		if (deviceModel.hasSource()) {
			Attribute sourceAttr = new Attribute(deviceModel.getSource());
			attributes.put("source", sourceAttr);
			
		}
		
		if (deviceModel.hasDataProvider()) {
			Attribute dataProviderAttr = new Attribute(deviceModel.getDataProvider());
			attributes.put("dataProvider", dataProviderAttr);
		}
		if (deviceModel.hasCategory()) {
			Attribute categoryAttr= new Attribute(deviceModel.getCategory());
			attributes.put("category",categoryAttr);
	
		}
		if (deviceModel.hasDeviceClass()) {
			Attribute deviceClassAttr = new Attribute(deviceModel.getDeviceClass());
			attributes.put("deviceClass", deviceClassAttr);
			
		}
		if (deviceModel.hasControlledProperty()) {
			Attribute controlledPropertyAttr = new Attribute(deviceModel.getControlledProperty());
			attributes.put("controlledProperty",controlledPropertyAttr);
		}
		if (deviceModel.hasFunction()) {
			Attribute functionAttr = new Attribute(deviceModel.getFunction());
			attributes.put("function",functionAttr);
		}
		
		if (deviceModel.hasSupportedProtocol()) {
			Attribute supportedProtocolAttr = new Attribute(deviceModel.getSupportedProtocol());
			attributes.put("supportedProtocol", supportedProtocolAttr);
		}
		
		if (deviceModel.hasSupportedUnits()) {
			Attribute supportedUnitsAttr = new Attribute(deviceModel.getSupportedUnits());
			attributes.put("supportedUnits",supportedUnitsAttr);
			
		}
		if (deviceModel.hasEnergyLimitationClass()) {
			Attribute energyLimitationClassAttr = new Attribute(deviceModel.getEnergyLimitationClass());
			attributes.put("energyLimitationClass",energyLimitationClassAttr);
		}
		if (deviceModel.hasBrandName()) {
			Attribute brandNameAttr = new Attribute(deviceModel.getBrandName());
			attributes.put("brandName", brandNameAttr);
			
			
		}
		if (deviceModel.hasModelName()) {
			Attribute modelNameAttr = new Attribute(deviceModel.getModelName());
			attributes.put("modelName",modelNameAttr);
		}
		
		if (deviceModel.hasManufacturerName()) {
			Attribute manufacturerNameAttr = new Attribute(deviceModel.getManufacturerName());
			attributes.put("manufacturerName",manufacturerNameAttr);
		}
		if (deviceModel.hasName()) {
			Attribute nameAttr = new Attribute(deviceModel.getName());
			attributes.put("name", nameAttr);
		}
		if (deviceModel.hasDescription()) {
			Attribute descriptionAttr = new Attribute(deviceModel.getDescription());
			attributes.put("description",descriptionAttr);
			
		}
		if (deviceModel.hasDocumentation()) {
			Attribute documentationAttr = new Attribute(deviceModel.getDocumentation());
			attributes.put("documentation", documentationAttr);
		}
		if (deviceModel.hasImage()) {
			Attribute imageAttr = new Attribute(deviceModel.getImage());
			attributes.put("image",imageAttr);
		}
		if (deviceModel.hasDateCreated()) {
			Attribute dateCreatedAttr = new Attribute(deviceModel.getDateCreated());
			attributes.put("dateCreated", dateCreatedAttr);
			
		}
		if (deviceModel.hasDateModified()) {
			Attribute dateModifiedAttr = new Attribute(deviceModel.getDateModified());
			attributes.put("dateModified", dateModifiedAttr);
		}
		
		entity.setAttributes(attributes);
		ObjectWriter writer = Utils.objectMapper.writer(new DefaultPrettyPrinter());
		String json = null;
		try {
		json = writer.writeValueAsString(entity);

	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		return json;
		
	}
	
	public String deviceAdapter(String jsonDevice) {
		
		Entity entity = null;
		HashMap<String,Attribute> attributes = new HashMap<String, Attribute>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		DeviceFiw deviceFiw = gson.fromJson(jsonDevice, DeviceFiw.class); 
		
		if(deviceFiw.hasId()&&deviceFiw.hasType()) {
			
			entity = new Entity(deviceFiw.getId(),deviceFiw.getType());
	
		}
		else {
			//son esenciales
			return null;
		}
		if(deviceFiw.hasSource()) {
			Attribute sourceAttr = new Attribute(deviceFiw.getSource());
			attributes.put("source", sourceAttr);
		}
		if (deviceFiw.hasDataProvider()) {
			Attribute dataProviderAttr = new Attribute(deviceFiw.getDataProvider());
			attributes.put("dataProvider", dataProviderAttr);
		}
		if (deviceFiw.hasCategory()) {
			Attribute categoryAttr = new Attribute(deviceFiw.getCategory());
			attributes.put("category",categoryAttr);
	
		}
		
		if (deviceFiw.hasControlledProperty()) {
			Attribute controlledPropertyAttr = new Attribute(deviceFiw.getControlledProperty());
			attributes.put("controlledProperty", controlledPropertyAttr);
			
			
		}
		if(deviceFiw.hasControlledAsset()) {
			Attribute controlledAssetAttr = new Attribute(deviceFiw.getControlledAsset());
			attributes.put("controlledAsset", controlledAssetAttr);
		}
		
		if(deviceFiw.hasHardwareVersion()) {
			Attribute hardwareVersionAttr = new Attribute(deviceFiw.getHardwareVersion());
			attributes.put("hardwareVersion",hardwareVersionAttr);
			
			
		}
		
		if (deviceFiw.hasSoftwareVersion()) {
			Attribute softwareVersionAttr = new Attribute(deviceFiw.getSoftwareVersion());
			attributes.put("softwareVersion",softwareVersionAttr);
			
		}
		if(deviceFiw.hasFirmwareVersion()) {
			Attribute firmwareVersionAttr = new Attribute(deviceFiw.getFirmwareVersion());
			attributes.put("firmwareVersion",firmwareVersionAttr);
		}
		if(deviceFiw.hasOsVersion()) {
			Attribute osVersionAttr = new Attribute(deviceFiw.getOsVersion());
			attributes.put("osVersion", osVersionAttr);
			
		}
		if(deviceFiw.hasDateLastCalibration()) {
			Attribute dateLastCalibrationAttr = new Attribute(deviceFiw.getDateLastCalibration());
			attributes.put("dateLastCalibration", dateLastCalibrationAttr);
		}
		
		if(deviceFiw.hasSerialNumber()) {
			Attribute serialNumberAttr = new Attribute(deviceFiw.getSerialNumber());
			attributes.put("serialNumber",serialNumberAttr);
		}
		if(deviceFiw.hasBatteryLevel()) {
			Attribute batteryLevelAttr = new Attribute(deviceFiw.getBatteryLevel());
			attributes.put("batteryLevel",batteryLevelAttr);
		}
		if(deviceFiw.hasRssi()) {
			Attribute rssiAttr = new Attribute(deviceFiw.getRssi());
			attributes.put("rssi",rssiAttr);
		}
		if(deviceFiw.hasDateInstalled()) {
			Attribute dateInstalledAttr = new Attribute(deviceFiw.getDateInstalled());
			attributes.put("dateInstalled", dateInstalledAttr);
		}
		if(deviceFiw.hasDateFirstUsed()) {
			Attribute dateFirstUsedAttr = new Attribute(deviceFiw.getDateFirstUsed());
			attributes.put("dateFirstUsed", dateFirstUsedAttr);
		}
		if(deviceFiw.hasDateLastValueReported())
		{
			Attribute dateLastValueReportedAttr = new Attribute(deviceFiw.getDateLastValueReported());
			attributes.put("dateLastValueReportedAttr",dateLastValueReportedAttr);
		}
		if (deviceFiw.hasDateCreated()) {
			Attribute dateCreatedAttr = new Attribute(deviceFiw.getDateCreated());
			attributes.put("dateCreated",dateCreatedAttr);
		}
		if (deviceFiw.hasDateModified()) {
			Attribute dateModifiedAttr = new Attribute(deviceFiw.getDateModified());
			attributes.put("dateModified", dateModifiedAttr);
		}
		
		if(deviceFiw.hasDeviceState()) {
			Attribute deviceStateAttr = new Attribute(deviceFiw.getDeviceState());
			attributes.put("deviceState", deviceStateAttr);
			
		}
		if(deviceFiw.hasValue()) {
			Attribute valueAttr = new Attribute(deviceFiw.getValue());
			attributes.put("value",valueAttr);
			
			
			
		}
		if(deviceFiw.hasName()) {
			Attribute nameAttr = new Attribute(deviceFiw.getName());
			attributes.put("name", nameAttr);
		}
		if(deviceFiw.hasDescription()) {
			Attribute descriptionAttr = new Attribute(deviceFiw.getDescription());
			attributes.put("descriptiom", descriptionAttr);
		
		}
		if(deviceFiw.hasDateManufactured()) {
			Attribute dateManufacturedAttr = new Attribute(deviceFiw.getDateManufactured());
			attributes.put("dateManufactured",dateManufacturedAttr);
		}
		if(deviceFiw.hasLocation()) {
			Attribute locationAttr = new Attribute(deviceFiw.getLocation());
			attributes.put("location",locationAttr);
		}
		
		if(deviceFiw.hasConfiguration()) {
			Attribute configurationAttr = new Attribute(deviceFiw.getConfiguration());
			attributes.put("configuration",configurationAttr);
		}
		if(deviceFiw.hasProvider()) {
			Attribute providerAttr = new Attribute(deviceFiw.getProvider());
			attributes.put("provider",providerAttr);
		}
		if(deviceFiw.hasOwner()) {
			Attribute ownerAttr = new Attribute(deviceFiw.getOwner());
			attributes.put("owner", ownerAttr);
		}
		if(deviceFiw.hasRefDeviceModel()) {
			Attribute refDeviceModelAttr = new Attribute(deviceFiw.getRefDeviceModel());
			attributes.put("refDeviceModel", refDeviceModelAttr);
		}
		
		if(deviceFiw.hasSupportedProtocol()) {
			Attribute supportedProtocolAttr = new Attribute(deviceFiw.getSupportedProtocol());
			attributes.put("supportedProtocol", supportedProtocolAttr);
		}
		if(deviceFiw.hasMacAddress()) {
			Attribute macAddressAttr = new Attribute(deviceFiw.getMacAddress());
			attributes.put("macAddress",macAddressAttr);
			
		}
		if(deviceFiw.hasIpAddress()) {
			Attribute ipAddressAttr = new Attribute(deviceFiw.getIpAddress());
			attributes.put("ipAddress",ipAddressAttr);
		}
		if(deviceFiw.hasMcc()) {
			Attribute mccAttr = new Attribute(deviceFiw.getMcc());
			attributes.put("mcc", mccAttr);
			
		}
		if(deviceFiw.hasMnc()) {
			
			Attribute mncAttr = new Attribute(deviceFiw.getMnc());
			attributes.put("mnc",mncAttr);
			
		}
		
		
		
		
		
		entity.setAttributes(attributes);
		ObjectWriter writer = Utils.objectMapper.writer(new DefaultPrettyPrinter());
		String json = null;
		try {
		json = writer.writeValueAsString(entity);

	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		return json;
		
	}
	
	
	
	
	
	
	
	

}
