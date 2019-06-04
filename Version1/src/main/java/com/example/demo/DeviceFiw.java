package com.example.demo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orange.ngsi2.model.Coordinate;
/**
 * En esta clase he modelado el tipo de datos Device del mundo Fiware. <a href="https://fiware-datamodels.readthedocs.io/en/latest/Device/Device/doc/spec/index.html">Link al standard</a>
 * He creado los getters y los setters. Además del hasXxx() para todos los atributos. En las listas, también he creado métodos para añadir directamente objetos del tipo de la lista.
 * @author jaimegonzalezruiz
 *
 */
public class DeviceFiw {
	
	
	 protected String id;
	    
	 protected String type = new String("Device");
	    
	 protected String source;
	    
	 protected String dataProvider;
	    
	 protected List<String> category ;
	 protected List<String> controlledProperty;
	 protected List<String> controlledAsset;
	 protected String mnc;
	 protected String mcc;
	 protected List<String> macAddress;
	 protected List<String> ipAddress;
	 protected List<String> supportedProtocol;
	 //This attribute is intended to be a dictionary of properties which capture parameters 
	 //which have to do with the configuration of a device (timeouts, reporting periods, etc.)
	 protected Map<String,String> configuration;
	 protected Coordinate location;
	 protected String name;
	 protected String description;
	 protected Date dateInstalled;
	 protected Date dateFirstUsed;
	 protected Date dateManufactured;
	 protected String hardwareVersion;
	 protected String softwareVersion;
	 protected String firmwareVersion;
	 protected String osVersion;
	 protected Date dateLastCalibration;
	 protected String serialNumber;
	 protected String provider;
	 protected Double batteryLevel;
	 protected Double rssi;
	 protected String deviceState;
	 protected Date dateLastValueReported;
	 protected String value;
	 protected Date dateModified;
	 protected Date dateCreated;
	 
	 //LAS REFERENCIAS NO LAS TENGO MUY CLARAS
	 
	 protected List<String> owner;
	 protected String refDeviceModel;
	
	 
	 
	 public List<String> getOwner() {
		 
		 return owner;
	 }
	 
	 public String getRefDeviceModel() {
		 if(this.refDeviceModel == null)
			 this.refDeviceModel = new String();
		 return refDeviceModel;
	 }
	 public void setOwner(List<String> owner) {
			this.owner = owner;
	} 
	 public void setRefDeviceModel(String refDeviceModel) {
			this.refDeviceModel = refDeviceModel;
	} 
	 public boolean hasOwner() { 
        return this.owner != null && !this.owner.isEmpty();
    }
	 public boolean hasRefDeviceModel() { 
	        return this.refDeviceModel != null && !this.refDeviceModel.isEmpty();
	    }
	 
	 
	 public String getProvider() {
			if (this.provider == null)
		        this.provider= new String();
			return provider;
	}
	 public void setProvider(String provider) {
			this.provider = provider;
	} 
	 
	public Map<String,String> getConfiguration(){
		if (this.configuration == null)
	        this.configuration= new HashMap<>();
		return configuration;
		
	}
	public void setConfiguration(Map<String,String> map) {
		this.configuration=map;
	}
	 
	public String getId() {
		if (this.id == null)
	        this.id= new String();
		return id;
	}
	public boolean hasConfiguration() { 
        return this.configuration != null && !this.configuration.isEmpty();
    }
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		if (this.type == null)
	        this.type= new String();
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSource() {
		if (this.source == null)
	        this.source= new String();
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDataProvider() {
		if (this.dataProvider == null)
	        this.dataProvider= new String();
		return dataProvider;
	}
	public void setDataProvider(String dataProvider) {
		this.dataProvider = dataProvider;
	}
	public List<String> getCategory() {
		return category;
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	public List<String> getControlledProperty() {
		return controlledProperty;
	}
	public void setControlledProperty(List<String> controlledProperty) {
		this.controlledProperty = controlledProperty;
	}
	public List<String> getControlledAsset() {
		return controlledAsset;
	}
	public void setControlledAsset(List<String> controlledAsset) {
		this.controlledAsset = controlledAsset;
	}
	public String getMnc() {
		if (this.mnc == null)
	        this.mnc= new String();
		return mnc;
	}
	public void setMnc(String mnc) {
		this.mnc = mnc;
	}
	public String getMcc() {
		if (this.mcc == null)
	        this.mcc= new String();
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public List<String> getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(List<String> macAddress) {
		this.macAddress = macAddress;
	}
	public List<String> getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(List<String> ipAddress) {
		this.ipAddress = ipAddress;
	}
	public List<String> getSupportedProtocol() {
		return supportedProtocol;
	}
	public void setSupportedProtocol(List<String> supportedProtocol) {
		this.supportedProtocol = supportedProtocol;
	}
	public Coordinate getLocation() {
		return location;
	}
	public void setLocation(Coordinate location) {
		this.location = location;
	}
	public String getName() {
		if (this.name == null)
	        this.name= new String();
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		if (this.description == null)
	        this.description= new String();
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateInstalled() {
		return dateInstalled;
	}
	public void setDateInstalled(Date dateInstalled) {
		this.dateInstalled = dateInstalled;
	}
	public Date getDateFirstUsed() {
		return dateFirstUsed;
	}
	public void setDateFirstUsed(Date dateFirstUsed) {
		this.dateFirstUsed = dateFirstUsed;
	}
	public Date getDateManufactured() {
		return dateManufactured;
	}
	public void setDateManufactured(Date dateManufactured) {
		this.dateManufactured = dateManufactured;
	}
	public String getHardwareVersion() {
		if (this.hardwareVersion == null)
	        this.hardwareVersion= new String();
		return hardwareVersion;
	}
	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}
	public String getSoftwareVersion() {
		if (this.softwareVersion == null)
	        this.softwareVersion= new String();
		return softwareVersion;
	}
	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}
	public String getFirmwareVersion() {
		if (this.firmwareVersion == null)
	        this.firmwareVersion= new String();
		return firmwareVersion;
	}
	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}
	public String getOsVersion() {
		if (this.osVersion == null)
	        this.osVersion= new String();
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public Date getDateLastCalibration() {
		return dateLastCalibration;
	}
	public void setDateLastCalibration(Date dateLastCalibration) {
		this.dateLastCalibration = dateLastCalibration;
	}
	public String getSerialNumber() {
		if (this.serialNumber == null)
	        this.serialNumber= new String();
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public double getBatteryLevel() {
		
		return batteryLevel;
	}
	public void setBatteryLevel(double batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	public double getRssi() {
		return rssi;
	}
	public void setRssi(double rssi) {
		this.rssi = rssi;
	}
	public String getDeviceState() {
		if (this.deviceState == null)
	        this.deviceState= new String();
		return deviceState;
	}
	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}
	public Date getDateLastValueReported() {
		return dateLastValueReported;
	}
	public void setDateLastValueReported(Date dateLastValueReported) {
		this.dateLastValueReported = dateLastValueReported;
	}
	public String getValue() {
		if (this.value == null)
	        this.value= new String();
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public boolean hasId() { 
        return this.id != null && !this.id.isEmpty();
    }
	public boolean hasType() { 
        return this.type != null && !this.type.isEmpty();
    }
	public boolean hasSource() { 
        return this.source != null && !this.source.isEmpty();
    }
	public boolean hasDataProvider() { 
        return this.dataProvider != null && !this.dataProvider.isEmpty();
    }
	public boolean hasCategory() { 
        return this.category != null && !this.category.isEmpty();
    }
	public boolean hasControlledProperty() { 
        return this.controlledProperty != null && !this.controlledProperty.isEmpty();
    }
	public boolean hasControlledAsset() {
		return this.controlledAsset!= null && !this.controlledAsset.isEmpty();
	}
	public boolean hasMnc() { 
        return this.mnc != null && !this.mnc.isEmpty();
    }
	public boolean hasMcc() { 
        return this.mcc != null && !this.mcc.isEmpty();
    }
	public boolean hasMacAddress() { 
        return this.macAddress != null && !this.macAddress.isEmpty();
    }
	public boolean hasIpAddress() { 
        return this.ipAddress != null && !this.ipAddress.isEmpty();
    }
	public boolean hasSupportedProtocol() { 
        return this.supportedProtocol != null && !this.supportedProtocol.isEmpty();
    }
	public boolean hasLocation() { 
        return this.location != null ;
    }
	public boolean hasName() { 
        return this.name != null && !this.name.isEmpty();
    }
	public boolean hasDescription() { 
        return this.description != null && !this.description.isEmpty();
    }
	public boolean hasProvider() { 
        return this.provider != null && !this.provider.isEmpty();
    }
	public boolean hasDateInstalled() { 
        return this.dateInstalled != null;
    }
	public boolean hasDateFirstUsed() { 
        return this.dateFirstUsed != null;
    }
	public boolean hasDateManufactured() { 
        return this.dateManufactured != null;
    }
	public boolean hasHardwareVersion() { 
        return this.hardwareVersion != null && !this.hardwareVersion.isEmpty();
	} 
	public boolean hasSoftwareVersion() { 
        return this.softwareVersion != null && !this.softwareVersion.isEmpty();
	} 
	public boolean hasFirmwareVersion() { 
        return this.firmwareVersion != null && !this.firmwareVersion.isEmpty();
	} 
	public boolean hasOsVersion() { 
        return this.osVersion != null && !this.osVersion.isEmpty();
	} 
	public boolean hasDateLastCalibration() { 
        return this.dateLastCalibration != null;
	} 
	public boolean hasSerialNumber() { 
        return this.serialNumber != null && !this.serialNumber.isEmpty();
	} 
	
	public boolean hasBatteryLevel() { 
        return this.batteryLevel != null;
	} 
	public boolean hasRssi() { 
        return this.rssi != null;
	} 
	public boolean hasDeviceState() { 
        return this.deviceState != null && !this.deviceState.isEmpty();
	} 
	public boolean hasDateLastValueReported() { 
        return this.dateLastValueReported != null ;
	} 
	public boolean hasValue() { 
        return this.value != null && !this.value.isEmpty();
	} 
	public boolean hasDateModified() { 
        return this.dateModified != null;
	} 
	public boolean hasDateCreated() { 
        return this.dateCreated != null;
	} 
	public void addSupportedProtocol(String value) {
	      if (this.supportedProtocol == null)
	        this.supportedProtocol = new ArrayList<String>();
	      this.category.add(value);		
	}
	public void addOwner(String value) {
	      if (this.owner == null)
	        this.owner = new ArrayList<String>();
	      this.owner.add(value);		
	}
	public void addCategory(String value) {
	      if (this.category == null)
	        this.category = new ArrayList<String>();
	      this.category.add(value);		
	}
	public void addControlledProperty(String value) {
	      if (this.controlledProperty == null)
	        this.controlledProperty = new ArrayList<String>();
	      this.controlledProperty.add(value);		
	}
	public void addIpAddress(String value) {
	      if (this.ipAddress == null)
	        this.ipAddress = new ArrayList<String>();
	      this.ipAddress.add(value);		
	}
	public void addMacAddress(String value) {
	      if (this.macAddress == null)
	        this.macAddress = new ArrayList<String>();
	      this.macAddress.add(value);		
	}
	public void addControlledAsset(String value) {
	      if (this.controlledAsset == null)
	        this.controlledAsset = new ArrayList<String>();
	      this.controlledAsset.add(value);		
	}
  

}
