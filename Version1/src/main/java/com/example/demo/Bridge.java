package com.example.demo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r4.model.Annotation;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.DecimalType;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.DeviceDefinition;
import org.hl7.fhir.r4.model.DeviceMetric;
import org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionCapabilityComponent;
import org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionDeviceNameComponent;
import org.hl7.fhir.r4.model.DeviceDefinition.DeviceDefinitionSpecializationComponent;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystemEnumFactory;
import org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent;
import org.hl7.fhir.r4.model.Device.DevicePropertyComponent;
import org.hl7.fhir.r4.model.Device.DeviceSpecializationComponent;
import org.hl7.fhir.r4.model.Device.DeviceVersionComponent;
import org.hl7.fhir.r4.model.DeviceDefinition.DeviceNameTypeEnumFactory;
import org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent;
import org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState;
import org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationStateEnumFactory;
import org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType;
import org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationTypeEnumFactory;
import org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategoryEnumFactory;
import org.hl7.fhir.r4.model.Location.LocationPositionComponent;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import ca.uhn.fhir.context.FhirContext;


/**
 * Bridge se encarga de transformar un objeto del mundo Fiware a uno o varios objetos del mundo Fhir.
 * 
 * @author jaimegonzalezruiz
 *
 */
public class Bridge {
	
	public Bridge()
	{
	}
	
	/*Este metodo va a obtener un string con formato JSON, que contiene un objeto DeviceModel(FIWARE).
	*Este deber ser transformado en un objeto DeviceDefinition(FHIR) que será devuelto en un string con 
	*formato JSON. Para que pueda ser enviado a un servidor de fhir.
	*/
	
	public String deviceModeltoDeviceDefinition(FhirContext ctx,String jsonDeviceModel){
		
		DeviceDefinition deviceDefinition = new DeviceDefinition();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		DeviceModel deviceModel = gson.fromJson(jsonDeviceModel, DeviceModel.class);
		
		if (deviceModel.hasId()) {
			List <Identifier> list = new ArrayList<Identifier>();
			Identifier aux = new Identifier().setValue(deviceModel.getId());
			if (deviceModel.hasSource()) {
				
				aux.setAssigner(new Reference().setReference(deviceModel.getSource()));
				
			}
			list.add(aux);	
			deviceDefinition.setIdentifier(list);
		}
		if (deviceModel.hasType()) {
			//no existe nada parecido en fhir, es irrelevante
		}
		
		if (deviceModel.hasDataProvider()) {
			List<ContactPoint> list = new ArrayList<ContactPoint>();
			ContactPoint aux = new ContactPoint();
			aux.setSystem(new ContactPointSystemEnumFactory().fromCode("url"));
			aux.setValue(deviceModel.getDataProvider());
			list.add(aux);
			deviceDefinition.setContact(list);
		}
		if (deviceModel.hasCategory()) {
			//el problema radica en que en fiware es una lista de tipos mientras que en fhir es unico
			CodeableConcept aux = new CodeableConcept();
			Iterator<String> iterator = deviceModel.getCategory().iterator();
			String categories="";
			while(iterator.hasNext()) {
				String debug = iterator.next();
				categories= categories+debug;
				if(iterator.hasNext()) {
					categories+=" ";
				}
			}
			
			aux.setText(categories);
			deviceDefinition.setType(aux);
	
		}
		if (deviceModel.hasDeviceClass()) {
			//no sé dónde meterlo aún
			
		}
		if (deviceModel.hasControlledProperty()) {
			
			Iterator<String> iterator = deviceModel.getControlledProperty().iterator();
			while(iterator.hasNext()) {
				CodeableConcept type = new CodeableConcept();
				type.setText(iterator.next());
				DeviceDefinitionCapabilityComponent aux = new DeviceDefinitionCapabilityComponent(type);
				List<CodeableConcept> lista = new ArrayList<CodeableConcept>();
				CodeableConcept desc = new CodeableConcept();
				desc.setText("controlledProperty");
				lista.add(desc);
				
				aux.setDescription(lista);
				deviceDefinition.addCapability(aux);
				
			}
			
			
			
		}
		if (deviceModel.hasFunction()) {
			Iterator<String> iterator = deviceModel.getFunction().iterator();
			while(iterator.hasNext()) {
				CodeableConcept type = new CodeableConcept();
				type.setText(iterator.next());
				DeviceDefinitionCapabilityComponent aux = new DeviceDefinitionCapabilityComponent(type);
				List<CodeableConcept> lista = new ArrayList<CodeableConcept>();
				CodeableConcept desc = new CodeableConcept();
				desc.setText("function");
				lista.add(desc);
				
				aux.setDescription(lista);
				deviceDefinition.addCapability(aux);
				
			}
		}
		
		if (deviceModel.hasSupportedProtocol()) {
			Iterator<String> iterator = deviceModel.getSupportedProtocol().iterator();
			while(iterator.hasNext()) {
				DeviceDefinitionSpecializationComponent aux = new DeviceDefinitionSpecializationComponent(new StringType(iterator.next()));
				
				deviceDefinition.addSpecialization(aux);
				
			}
		}
		
		if (deviceModel.hasSupportedUnits()) {
			Iterator<String> iterator = deviceModel.getSupportedUnits().iterator();
			while(iterator.hasNext()) {
				CodeableConcept type = new CodeableConcept();
				type.setText(iterator.next());
				DeviceDefinitionCapabilityComponent aux = new DeviceDefinitionCapabilityComponent(type);
				List<CodeableConcept> lista = new ArrayList<CodeableConcept>();
				CodeableConcept desc = new CodeableConcept();
				desc.setText("supportedUnits");
				lista.add(desc);
				
				aux.setDescription(lista);
				deviceDefinition.addCapability(aux);
				
			}
		}
		if (deviceModel.hasEnergyLimitationClass()) {
			//no sé cómo hacerlo aún
		}
		if (deviceModel.hasBrandName()) {
			
			DeviceDefinitionDeviceNameComponent aux = new DeviceDefinitionDeviceNameComponent();
			aux.setName(deviceModel.getBrandName());
			aux.setType(new DeviceNameTypeEnumFactory().fromCode("other"));
			deviceDefinition.addDeviceName(aux);
			/*
			Annotation aux = new Annotation();
			aux.setText(deviceModel.getBrandName());
			deviceDefinition.addNote(aux);*/
		}
		if (deviceModel.hasModelName()) {
			//ojo disconcordancia number/name. Lo ideal seria dentro de deviceName con el type model-name. 
			//Pero entonces que hago con la variable de fiware name. De este modo no habría colisión. En fhir solo 
			//deviceDefinition.setModelNumber(deviceModel.getModelName());
			
			DeviceDefinitionDeviceNameComponent aux = new DeviceDefinitionDeviceNameComponent();
			aux.setName(deviceModel.getModelName());
			aux.setType(new DeviceNameTypeEnumFactory().fromCode("model-name"));
			deviceDefinition.addDeviceName(aux);
			
		}
		
		if (deviceModel.hasManufacturerName()) {
			deviceDefinition.setManufacturer(new StringType(deviceModel.getManufacturerName()));
		}
		if (deviceModel.hasName()) {
			DeviceDefinitionDeviceNameComponent aux = new DeviceDefinitionDeviceNameComponent();
			aux.setName(deviceModel.getName());
			aux.setType(new DeviceNameTypeEnumFactory().fromCode("user-friendly-name"));
			deviceDefinition.addDeviceName(aux);
		}
		if (deviceModel.hasDescription()) {
			
			Annotation aux = new Annotation();
			aux.setText(deviceModel.getDescription());
			deviceDefinition.addNote(aux);
		}
		if (deviceModel.hasDocumentation()) {
			deviceDefinition.setOnlineInformation(deviceModel.getDocumentation().toString());
		}
		if (deviceModel.hasImage()) {
			
		}
		if (deviceModel.hasDateCreated()) {
			
		}
		if (deviceModel.hasDateModified()) {
			
		}
		
		String encoded = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(deviceDefinition);
		
		
		
		
		
		
		return encoded;
	}
	public DeviceDefinition deviceModeltoFHIR(DeviceModel deviceModel){
		
		DeviceDefinition deviceDefinition = new DeviceDefinition();
		
		
		if (deviceModel.hasId()) {
			List <Identifier> list = new ArrayList<Identifier>();
			Identifier aux = new Identifier().setValue(deviceModel.getId());
			if (deviceModel.hasSource()) {
				
				aux.setAssigner(new Reference().setReference(deviceModel.getSource()));
				
			}
			list.add(aux);	
			deviceDefinition.setIdentifier(list);
		}
		if (deviceModel.hasType()) {
			//no existe nada parecido en fhir, es irrelevante
		}
		
		if (deviceModel.hasDataProvider()) {
			List<ContactPoint> list = new ArrayList<ContactPoint>();
			ContactPoint aux = new ContactPoint();
			aux.setSystem(new ContactPointSystemEnumFactory().fromCode("url"));
			aux.setValue(deviceModel.getDataProvider());
			list.add(aux);
			deviceDefinition.setContact(list);
		}
		if (deviceModel.hasCategory()) {
			//el problema radica en que en fiware es una lista de tipos mientras que en fhir es unico
			CodeableConcept aux = new CodeableConcept();
			Iterator<String> iterator = deviceModel.getCategory().iterator();
			String categories="";
			while(iterator.hasNext()) {
				String debug = iterator.next();
				categories= categories+debug;
				if(iterator.hasNext()) {
					categories+=" ";
				}
			}
			
			aux.setText(categories);
			deviceDefinition.setType(aux);
	
		}
		if (deviceModel.hasDeviceClass()) {
			//no sé dónde meterlo aún
			
		}
		if (deviceModel.hasControlledProperty()) {
			
			Iterator<String> iterator = deviceModel.getControlledProperty().iterator();
			while(iterator.hasNext()) {
				CodeableConcept type = new CodeableConcept();
				type.setText(iterator.next());
				DeviceDefinitionCapabilityComponent aux = new DeviceDefinitionCapabilityComponent(type);
				List<CodeableConcept> lista = new ArrayList<CodeableConcept>();
				CodeableConcept desc = new CodeableConcept();
				desc.setText("controlledProperty");
				lista.add(desc);
				
				aux.setDescription(lista);
				deviceDefinition.addCapability(aux);
				
			}
			
			
			
		}
		if (deviceModel.hasFunction()) {
			Iterator<String> iterator = deviceModel.getFunction().iterator();
			while(iterator.hasNext()) {
				CodeableConcept type = new CodeableConcept();
				type.setText(iterator.next());
				DeviceDefinitionCapabilityComponent aux = new DeviceDefinitionCapabilityComponent(type);
				List<CodeableConcept> lista = new ArrayList<CodeableConcept>();
				CodeableConcept desc = new CodeableConcept();
				desc.setText("function");
				lista.add(desc);
				
				aux.setDescription(lista);
				deviceDefinition.addCapability(aux);
				
			}
		}
		
		if (deviceModel.hasSupportedProtocol()) {
			Iterator<String> iterator = deviceModel.getSupportedProtocol().iterator();
			while(iterator.hasNext()) {
				DeviceDefinitionSpecializationComponent aux = new DeviceDefinitionSpecializationComponent(new StringType(iterator.next()));
				
				deviceDefinition.addSpecialization(aux);
				
			}
		}
		
		if (deviceModel.hasSupportedUnits()) {
			Iterator<String> iterator = deviceModel.getSupportedUnits().iterator();
			while(iterator.hasNext()) {
				CodeableConcept type = new CodeableConcept();
				type.setText(iterator.next());
				DeviceDefinitionCapabilityComponent aux = new DeviceDefinitionCapabilityComponent(type);
				List<CodeableConcept> lista = new ArrayList<CodeableConcept>();
				CodeableConcept desc = new CodeableConcept();
				desc.setText("supportedUnits");
				lista.add(desc);
				
				aux.setDescription(lista);
				deviceDefinition.addCapability(aux);
				
			}
		}
		if (deviceModel.hasEnergyLimitationClass()) {
			//no sé cómo hacerlo aún
		}
		if (deviceModel.hasBrandName()) {
			
			DeviceDefinitionDeviceNameComponent aux = new DeviceDefinitionDeviceNameComponent();
			aux.setName(deviceModel.getBrandName());
			aux.setType(new DeviceNameTypeEnumFactory().fromCode("other"));
			deviceDefinition.addDeviceName(aux);
			/*
			Annotation aux = new Annotation();
			aux.setText(deviceModel.getBrandName());
			deviceDefinition.addNote(aux);*/
		}
		if (deviceModel.hasModelName()) {
			//ojo disconcordancia number/name. Lo ideal seria dentro de deviceName con el type model-name. 
			//Pero entonces que hago con la variable de fiware name. De este modo no habría colisión. En fhir solo 
			//deviceDefinition.setModelNumber(deviceModel.getModelName());
			
			DeviceDefinitionDeviceNameComponent aux = new DeviceDefinitionDeviceNameComponent();
			aux.setName(deviceModel.getModelName());
			aux.setType(new DeviceNameTypeEnumFactory().fromCode("model-name"));
			deviceDefinition.addDeviceName(aux);
			
		}
		
		if (deviceModel.hasManufacturerName()) {
			deviceDefinition.setManufacturer(new StringType(deviceModel.getManufacturerName()));
		}
		if (deviceModel.hasName()) {
			DeviceDefinitionDeviceNameComponent aux = new DeviceDefinitionDeviceNameComponent();
			aux.setName(deviceModel.getName());
			aux.setType(new DeviceNameTypeEnumFactory().fromCode("user-friendly-name"));
			deviceDefinition.addDeviceName(aux);
		}
		if (deviceModel.hasDescription()) {
			
			Annotation aux = new Annotation();
			aux.setText(deviceModel.getDescription());
			deviceDefinition.addNote(aux);
		}
		if (deviceModel.hasDocumentation()) {
			deviceDefinition.setOnlineInformation(deviceModel.getDocumentation().toString());
		}
		if (deviceModel.hasImage()) {
			
		}
		if (deviceModel.hasDateCreated()) {
			
		}
		if (deviceModel.hasDateModified()) {
			
		}
		
	//	String encoded = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(deviceDefinition);
		
		
		
		
		
		
		return deviceDefinition;
	}
	public ReturnBundle deviceFiwareToFhir(String jsonDeviceFiw) {
	
	
	Device deviceFhir = new Device();
	Observation obs = new Observation();
	DeviceMetric metric = new DeviceMetric();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	DeviceFiw deviceFiw = gson.fromJson(jsonDeviceFiw, DeviceFiw.class);
	
	//aquí hay que ver que hacemos ya que de un objeto salen 3
	if(deviceFiw.hasId()) {
		
		List <Identifier> list = new ArrayList<Identifier>();
		Identifier aux = new Identifier().setValue(deviceFiw.getId());
		
		if (deviceFiw.hasSource()) {
			
			aux.setAssigner(new Reference().setReference(deviceFiw.getSource()));
			
		}
		list.add(aux);	
		deviceFhir.setIdentifier(list);
		obs.setIdentifier(list);
		metric.setIdentifier(list);

	}
	if (deviceFiw.hasDataProvider()) {
		List<ContactPoint> list = new ArrayList<ContactPoint>();
		ContactPoint aux = new ContactPoint();
		aux.setSystem(new ContactPointSystemEnumFactory().fromCode("url"));
		aux.setValue(deviceFiw.getDataProvider());
		list.add(aux);
		deviceFhir.setContact(list);
	}
	if (deviceFiw.hasCategory()) {
		//el problema radica en que en fiware es una lista de tipos mientras que en fhir es unico
		CodeableConcept aux = new CodeableConcept();
		Iterator<String> iterator = deviceFiw.getCategory().iterator();
		String categories="";
		while(iterator.hasNext()) {
			String debug = iterator.next();
			categories= categories+debug;
			if(iterator.hasNext()) {
				categories+=" ";
			}
		}
		
		aux.setText(categories);
		deviceFhir.setType(aux);

	}
	
	if (deviceFiw.hasControlledProperty()) {
		//habría que crear uno por controlledproperty otro problema, por ahora solo con uno
		Iterator<String> iterator = deviceFiw.getControlledProperty().iterator();
		CodeableConcept type = new CodeableConcept();
		String text = "";
		while(iterator.hasNext()) {
			text = text + iterator.next();
			text = text + " ";
			
		}
		type.setText(text);
		metric.setType(type);
		DeviceMetricCategoryEnumFactory aux = new DeviceMetricCategoryEnumFactory();
		metric.setCategory(aux.fromCode("unspecified"));
		
	}
	if(deviceFiw.hasControlledAsset()) {
		//big problem
	}
	
	if(deviceFiw.hasHardwareVersion()) {
		
		DeviceVersionComponent aux = new DeviceVersionComponent(new StringType(deviceFiw.getHardwareVersion()));
		CodeableConcept type =  new CodeableConcept();
		type.setText("hardware");
		aux.setType(type);
		deviceFhir.addVersion(aux);
		
	}
	
	if (deviceFiw.hasSoftwareVersion()) {
		DeviceVersionComponent aux = new DeviceVersionComponent(new StringType(deviceFiw.getSoftwareVersion()));
		CodeableConcept type =  new CodeableConcept();
		type.setText("software");
		aux.setType(type);
		deviceFhir.addVersion(aux);
		
	}
	if(deviceFiw.hasFirmwareVersion()) {
		DeviceVersionComponent aux = new DeviceVersionComponent(new StringType(deviceFiw.getFirmwareVersion()));
		CodeableConcept type =  new CodeableConcept();
		type.setText("firmware");
		aux.setType(type);
		deviceFhir.addVersion(aux);
	}
	if(deviceFiw.hasOsVersion()) {
		DeviceVersionComponent aux = new DeviceVersionComponent(new StringType(deviceFiw.getOsVersion()));
		CodeableConcept type =  new CodeableConcept();
		type.setText("os");
		aux.setType(type);
		deviceFhir.addVersion(aux);
	}
	if(deviceFiw.hasDateLastCalibration()) {
		DeviceMetricCalibrationComponent aux = new DeviceMetricCalibrationComponent();
		DeviceMetricCalibrationTypeEnumFactory typefac = new DeviceMetricCalibrationTypeEnumFactory();
		
		DeviceMetricCalibrationType type = typefac.fromCode("unspecified");
		DeviceMetricCalibrationStateEnumFactory statefac = new DeviceMetricCalibrationStateEnumFactory();
		DeviceMetricCalibrationState state = statefac.fromCode("calibrated");
		aux.setType(type);
		aux.setState(state);
		aux.setTime(deviceFiw.getDateLastCalibration());
		metric.addCalibration(aux);
	}
	
	if(deviceFiw.hasSerialNumber()) {
		deviceFhir.setSerialNumber(deviceFiw.getSerialNumber());
	}
	if(deviceFiw.hasBatteryLevel()) {
		//no se como modelarlo
	}
	if(deviceFiw.hasRssi()) {
		//no se como modelarlo
	}
	if(deviceFiw.hasDateInstalled()) {
		
	}
	if(deviceFiw.hasDateFirstUsed()) {
		
	}
	if(deviceFiw.hasDateLastValueReported())
	{
		
	}
	if (deviceFiw.hasDateCreated()) {
		
	}
	if (deviceFiw.hasDateModified()) {
		
	}
	
	if(deviceFiw.hasDeviceState()) {
		CodeableConcept status = new CodeableConcept();
		status.setText(deviceFiw.getDeviceState());
		deviceFhir.addStatusReason(status);
		
	}
	if(deviceFiw.hasValue()) {
		//este es un principio el valor principal que alimenta la clase Observation
		//esta clase tienes dos atributos obligatorios, status y code
		obs.setStatus(ObservationStatus.REGISTERED);
		//este codigo sigue el standar LOINC y es extremadamente amplio: https://www.hl7.org/fhir/valueset-observation-codes.html
		CodeableConcept aux = new CodeableConcept();
		aux.setText("undefined");
		obs.setCode(aux);
		obs.setValue(new StringType(deviceFiw.getValue()));
		
		
		
	}
	if(deviceFiw.hasName()) {
		//Colisión con DeviceDefinition.DeviceNameTypeEnumFactory;
		org.hl7.fhir.r4.model.Device.DeviceNameTypeEnumFactory typefac = new org.hl7.fhir.r4.model.Device.DeviceNameTypeEnumFactory();
		
		DeviceDeviceNameComponent aux = new DeviceDeviceNameComponent();
		aux.setName(deviceFiw.getName());
		
		aux.setType(typefac.fromCode("user-friendly-name"));
		deviceFhir.addDeviceName(aux);
	}
	if(deviceFiw.hasDescription()) {
		Annotation aux = new Annotation();
		aux.setText(deviceFiw.getDescription());
		deviceFhir.addNote(aux);
	
	}
	if(deviceFiw.hasDateManufactured()) {
		deviceFhir.setManufactureDate(deviceFiw.getDateManufactured());
	}
	if(deviceFiw.hasLocation()) {
		double latitud = deviceFiw.getLocation().getLatitude()	;		
		double longitud = deviceFiw.getLocation().getLongitude();
		Location loc = new Location();
		LocationPositionComponent position = new LocationPositionComponent(new DecimalType(longitud),new DecimalType(latitud));
		loc.setPosition(position);
		//es una ref a un objeto Location. tengo que mirarlo
	}
	
	
	if(deviceFiw.hasSupportedProtocol()) {
		Iterator<String> iterator = deviceFiw.getSupportedProtocol().iterator();
		while(iterator.hasNext()) {
			CodeableConcept type = new CodeableConcept();
			type.setText(iterator.next());
			DeviceSpecializationComponent aux = new DeviceSpecializationComponent(type);
			deviceFhir.addSpecialization(aux);
		}
	}
	if(deviceFiw.hasMacAddress()) {
		//esto no esta realmente contemplado en fhir pero lo he modelado así 
		DevicePropertyComponent aux = new DevicePropertyComponent();
		CodeableConcept type  = new CodeableConcept();
		type.setText("MacAddress");
		aux.setType(type);
		CodeableConcept address = new CodeableConcept();
		address.setText(deviceFiw.getMacAddress().get(0));
		aux.addValueCode(address);
		deviceFhir.addProperty(aux);
		
	}
	if(deviceFiw.hasIpAddress()) {
		//aunque en fiware puede tener más de una en fhir solo se admite 1
		deviceFhir.setUrl(deviceFiw.getIpAddress().get(0));
		
	}
	if(deviceFiw.hasMcc()) {
		CodeableConcept systemType = new CodeableConcept();
		Coding code = new Coding();
		code.setCode(deviceFiw.getMcc());
		code.setVersion("mcc");
		systemType.addCoding(code);
		DeviceSpecializationComponent aux = new DeviceSpecializationComponent(systemType);
		deviceFhir.addSpecialization(aux);
		
	}
	if(deviceFiw.hasMnc()) {
		CodeableConcept systemType = new CodeableConcept();
		Coding code = new Coding();
		code.setCode(deviceFiw.getMnc());
		code.setVersion("mnc");
		
		systemType.addCoding(code);
		DeviceSpecializationComponent aux = new DeviceSpecializationComponent(systemType);
		deviceFhir.addSpecialization(aux);
	}
	if(deviceFiw.hasConfiguration()) {
		List<DevicePropertyComponent> lista = new ArrayList<DevicePropertyComponent>();
		Map<String,String> mapa = deviceFiw.getConfiguration();	
		Iterator<String> itr = mapa.keySet().iterator();
		while(itr.hasNext()) {
			CodeableConcept type = new CodeableConcept();
			CodeableConcept valueCode = new CodeableConcept();
			String key = itr.next();
			type.setText(key);
			valueCode.setText(mapa.get(key));
			DevicePropertyComponent property = new DevicePropertyComponent(type);
			property.addValueCode(valueCode);
			lista.add(property);
			
		}
		deviceFhir.setProperty(lista);

	}
	if(deviceFiw.hasProvider()) {
		deviceFhir.setManufacturer(deviceFiw.getProvider());
	}
	if(deviceFiw.hasOwner()) {
		//no sé como hacer la referencia
	}
	if(deviceFiw.hasRefDeviceModel()) {
		//no sé como hacer la referencia
		
	}
	
	ReturnBundle result = new ReturnBundle(deviceFhir,obs,metric);
	
	return result;	
}
	public ReturnBundle deviceFiwareToFhir(DeviceFiw deviceFiw) {
		
		
		Device deviceFhir = new Device();
		Observation obs = new Observation();
		DeviceMetric metric = new DeviceMetric();
		
		
		//aquí hay que ver que hacemos ya que de un objeto salen 3
		if(deviceFiw.hasId()) {
			
			List <Identifier> list = new ArrayList<Identifier>();
			Identifier aux = new Identifier().setValue(deviceFiw.getId());
			
			if (deviceFiw.hasSource()) {
				
				aux.setAssigner(new Reference().setReference(deviceFiw.getSource()));
				
			}
			list.add(aux);	
			deviceFhir.setIdentifier(list);
			obs.setIdentifier(list);
			metric.setIdentifier(list);

		}
		if (deviceFiw.hasDataProvider()) {
			List<ContactPoint> list = new ArrayList<ContactPoint>();
			ContactPoint aux = new ContactPoint();
			aux.setSystem(new ContactPointSystemEnumFactory().fromCode("url"));
			aux.setValue(deviceFiw.getDataProvider());
			list.add(aux);
			deviceFhir.setContact(list);
		}
		if (deviceFiw.hasCategory()) {
			//el problema radica en que en fiware es una lista de tipos mientras que en fhir es unico
			CodeableConcept aux = new CodeableConcept();
			Iterator<String> iterator = deviceFiw.getCategory().iterator();
			String categories="";
			while(iterator.hasNext()) {
				String debug = iterator.next();
				categories= categories+debug;
				if(iterator.hasNext()) {
					categories+=" ";
				}
			}
			
			aux.setText(categories);
			deviceFhir.setType(aux);

		}
		
		if (deviceFiw.hasControlledProperty()) {
			//habría que crear uno por controlledproperty otro problema, por ahora solo con uno
			Iterator<String> iterator = deviceFiw.getControlledProperty().iterator();
			CodeableConcept type = new CodeableConcept();
			String text = "";
			while(iterator.hasNext()) {
				text = text + iterator.next();
				text = text + " ";
				
			}
			type.setText(text);
			metric.setType(type);
			DeviceMetricCategoryEnumFactory aux = new DeviceMetricCategoryEnumFactory();
			metric.setCategory(aux.fromCode("unspecified"));
			
		}
		if(deviceFiw.hasControlledAsset()) {
			//big problem
		}
		
		if(deviceFiw.hasHardwareVersion()) {
			
			DeviceVersionComponent aux = new DeviceVersionComponent(new StringType(deviceFiw.getHardwareVersion()));
			CodeableConcept type =  new CodeableConcept();
			type.setText("hardware");
			aux.setType(type);
			deviceFhir.addVersion(aux);
			
		}
		
		if (deviceFiw.hasSoftwareVersion()) {
			DeviceVersionComponent aux = new DeviceVersionComponent(new StringType(deviceFiw.getSoftwareVersion()));
			CodeableConcept type =  new CodeableConcept();
			type.setText("software");
			aux.setType(type);
			deviceFhir.addVersion(aux);
			
		}
		if(deviceFiw.hasFirmwareVersion()) {
			DeviceVersionComponent aux = new DeviceVersionComponent(new StringType(deviceFiw.getFirmwareVersion()));
			CodeableConcept type =  new CodeableConcept();
			type.setText("firmware");
			aux.setType(type);
			deviceFhir.addVersion(aux);
		}
		if(deviceFiw.hasOsVersion()) {
			DeviceVersionComponent aux = new DeviceVersionComponent(new StringType(deviceFiw.getOsVersion()));
			CodeableConcept type =  new CodeableConcept();
			type.setText("os");
			aux.setType(type);
			deviceFhir.addVersion(aux);
		}
		if(deviceFiw.hasDateLastCalibration()) {
			DeviceMetricCalibrationComponent aux = new DeviceMetricCalibrationComponent();
			DeviceMetricCalibrationTypeEnumFactory typefac = new DeviceMetricCalibrationTypeEnumFactory();
			
			DeviceMetricCalibrationType type = typefac.fromCode("unspecified");
			DeviceMetricCalibrationStateEnumFactory statefac = new DeviceMetricCalibrationStateEnumFactory();
			DeviceMetricCalibrationState state = statefac.fromCode("calibrated");
			aux.setType(type);
			aux.setState(state);
			aux.setTime(deviceFiw.getDateLastCalibration());
			metric.addCalibration(aux);
		}
		
		if(deviceFiw.hasSerialNumber()) {
			deviceFhir.setSerialNumber(deviceFiw.getSerialNumber());
		}
		if(deviceFiw.hasBatteryLevel()) {
			//no se como modelarlo
		}
		if(deviceFiw.hasRssi()) {
			//no se como modelarlo
		}
		if(deviceFiw.hasDateInstalled()) {
			
		}
		if(deviceFiw.hasDateFirstUsed()) {
			
		}
		if(deviceFiw.hasDateLastValueReported())
		{
			
		}
		if (deviceFiw.hasDateCreated()) {
			
		}
		if (deviceFiw.hasDateModified()) {
			
		}
		
		if(deviceFiw.hasDeviceState()) {
			CodeableConcept status = new CodeableConcept();
			status.setText(deviceFiw.getDeviceState());
			deviceFhir.addStatusReason(status);
			
		}
		if(deviceFiw.hasValue()) {
			//este es un principio el valor principal que alimenta la clase Observation
			//esta clase tienes dos atributos obligatorios, status y code
			obs.setStatus(ObservationStatus.REGISTERED);
			//este codigo sigue el standar LOINC y es extremadamente amplio: https://www.hl7.org/fhir/valueset-observation-codes.html
			CodeableConcept aux = new CodeableConcept();
			aux.setText("undefined");
			obs.setCode(aux);
			obs.setValue(new StringType(deviceFiw.getValue()));
			
			
			
		}
		if(deviceFiw.hasName()) {
			//Colisión con DeviceDefinition.DeviceNameTypeEnumFactory;
			org.hl7.fhir.r4.model.Device.DeviceNameTypeEnumFactory typefac = new org.hl7.fhir.r4.model.Device.DeviceNameTypeEnumFactory();
			
			DeviceDeviceNameComponent aux = new DeviceDeviceNameComponent();
			aux.setName(deviceFiw.getName());
			
			aux.setType(typefac.fromCode("user-friendly-name"));
			deviceFhir.addDeviceName(aux);
		}
		if(deviceFiw.hasDescription()) {
			Annotation aux = new Annotation();
			aux.setText(deviceFiw.getDescription());
			deviceFhir.addNote(aux);
		
		}
		if(deviceFiw.hasDateManufactured()) {
			deviceFhir.setManufactureDate(deviceFiw.getDateManufactured());
		}
		if(deviceFiw.hasLocation()) {
			double latitud = deviceFiw.getLocation().getLatitude()	;		
			double longitud = deviceFiw.getLocation().getLongitude();
			Location loc = new Location();
			LocationPositionComponent position = new LocationPositionComponent(new DecimalType(longitud),new DecimalType(latitud));
			loc.setPosition(position);
			//es una ref a un objeto Location. tengo que mirarlo
		}
		
		
		if(deviceFiw.hasSupportedProtocol()) {
			Iterator<String> iterator = deviceFiw.getSupportedProtocol().iterator();
			while(iterator.hasNext()) {
				CodeableConcept type = new CodeableConcept();
				type.setText(iterator.next());
				DeviceSpecializationComponent aux = new DeviceSpecializationComponent(type);
				deviceFhir.addSpecialization(aux);
			}
		}
		if(deviceFiw.hasMacAddress()) {
			//esto no esta realmente contemplado en fhir pero lo he modelado así 
			DevicePropertyComponent aux = new DevicePropertyComponent();
			CodeableConcept type  = new CodeableConcept();
			type.setText("MacAddress");
			aux.setType(type);
			CodeableConcept address = new CodeableConcept();
			address.setText(deviceFiw.getMacAddress().get(0));
			aux.addValueCode(address);
			deviceFhir.addProperty(aux);
			
		}
		if(deviceFiw.hasIpAddress()) {
			//aunque en fiware puede tener más de una en fhir solo se admite 1
			deviceFhir.setUrl(deviceFiw.getIpAddress().get(0));
			
		}
		if(deviceFiw.hasMcc()) {
			CodeableConcept systemType = new CodeableConcept();
			Coding code = new Coding();
			code.setCode(deviceFiw.getMcc());
			code.setVersion("mcc");
			systemType.addCoding(code);
			DeviceSpecializationComponent aux = new DeviceSpecializationComponent(systemType);
			deviceFhir.addSpecialization(aux);
			
		}
		if(deviceFiw.hasMnc()) {
			CodeableConcept systemType = new CodeableConcept();
			Coding code = new Coding();
			code.setCode(deviceFiw.getMnc());
			code.setVersion("mnc");
			
			systemType.addCoding(code);
			DeviceSpecializationComponent aux = new DeviceSpecializationComponent(systemType);
			deviceFhir.addSpecialization(aux);
		}
		if(deviceFiw.hasConfiguration()) {
			List<DevicePropertyComponent> lista = new ArrayList<DevicePropertyComponent>();
			Map<String,String> mapa = deviceFiw.getConfiguration();	
			Iterator<String> itr = mapa.keySet().iterator();
			while(itr.hasNext()) {
				CodeableConcept type = new CodeableConcept();
				CodeableConcept valueCode = new CodeableConcept();
				String key = itr.next();
				type.setText(key);
				valueCode.setText(mapa.get(key));
				DevicePropertyComponent property = new DevicePropertyComponent(type);
				property.addValueCode(valueCode);
				lista.add(property);
				
			}
			deviceFhir.setProperty(lista);

		}
		if(deviceFiw.hasProvider()) {
			deviceFhir.setManufacturer(deviceFiw.getProvider());
		}
		if(deviceFiw.hasOwner()) {
			//no sé como hacer la referencia
		}
		if(deviceFiw.hasRefDeviceModel()) {
			//no sé como hacer la referencia
			
		}
		
		ReturnBundle result = new ReturnBundle(deviceFhir,obs,metric);
		
		return result;	
	}
}