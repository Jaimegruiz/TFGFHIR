

import java.net.URL;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * En esta clase he modelado el tipo de datos DeviceModel del mundo FIWARE. <a href="https://fiware-datamodels.readthedocs.io/en/latest/Device/DeviceModel/doc/spec/index.html">Link al standard</a>
 * He creado los getters y los setters. Además del hasXxx() para todos los atributos. En las listas, también he creado métodos para añadir directamente objetos del tipo de la lista.
 * @author jaimegonzalezruiz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceModel {
	
	
   
    protected String id;
    
    protected String type;
    
    protected String source;
    
    protected String dataProvider;
    
    protected List<String> category ;
    protected String deviceClass;
    protected List<String> controlledProperty;
    protected List<String> function;
    
    protected List<String> supportedProtocol;
    protected List<String> supportedUnits;
    protected String energyLimitationClass;
    protected String brandName;
    protected String modelName;
    protected String manufacturerName;
    protected String name;
    protected String description;
    protected URL documentation=null;
    protected URL image=null;
    
    //automatically generated
    protected Date dateModified;
    protected Date dateCreated;
    
    
    public DeviceModel() {
    	type = "DeviceModel";
    }
    
    
   
	public String getId() {
		if (this.id == null)
	        this.id= new String();
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
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
		 if (this.category == null)
			 this.category = new ArrayList<String>();
	     return this.category;
	
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	public String getDeviceClass() {
		if (this.deviceClass == null)
	        this.deviceClass= new String();
		return deviceClass;
	}
	public void setDeviceClass(String deviceClass) {
		this.deviceClass = deviceClass;
	}
	public List<String> getControlledProperty() {
		if (this.controlledProperty == null)
			 this.controlledProperty = new ArrayList<String>();
	     return this.controlledProperty;
	}
	public void setControlledProperty(List<String> controlledProperty) {
		this.controlledProperty = controlledProperty;
	}
	public List<String> getFunction() {
		if (this.function == null)
	        this.function= new ArrayList<String>();
		return function;
	}
	public void setFunction(List<String> function) {
		this.function = function;
	}
	public List<String> getSupportedProtocol() {
		if (this.supportedProtocol == null)
			 this.supportedProtocol = new ArrayList<String>();
	     return this.supportedProtocol;
	}
	public void setSupportedProtocol(List<String> supportedProtocol) {
		this.supportedProtocol = supportedProtocol;
	}
	public List<String> getSupportedUnits() {
		if (this.supportedUnits == null)
			 this.supportedUnits = new ArrayList<String>();
	     return this.supportedUnits;
	}
	public void setSupportedUnits(List<String> supportedUnits) {
		this.supportedUnits = supportedUnits;
	}
	public String getEnergyLimitationClass() {
		if (this.energyLimitationClass == null)
	        this.energyLimitationClass= new String();
		return energyLimitationClass;
	}
	public void setEnergyLimitationClass(String energyLimitationClass) {
		this.energyLimitationClass = energyLimitationClass;
	}
	public String getBrandName() {
		if (this.brandName == null)
	        this.brandName= new String();
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		if (this.modelName == null)
	        this.modelName= new String();
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getManufacturerName() {
		if (this.manufacturerName == null)
	        this.manufacturerName= new String();
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
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
	public URL getDocumentation()  {
		/*
		if (this.documentation == null)
			try {
				this.documentation= new URL("");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		return documentation;
	}
	public void setDocumentation(URL documentation) {
		this.documentation = documentation;
	}
	public URL getImage() {
		/*
		if (this.documentation == null)
			try {
				this.documentation= new URL("");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		return image;
	}
	public void setImage(URL image) {
		this.image = image;
	}
	public Date getDateModified() {
		if (this.dateModified == null)
	        this.dateModified= new Date();
		return dateModified;
	}
	
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
	public Date getDateCreated() {
		if (this.dateCreated == null)
	        this.dateCreated= new Date();
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public  String getType() {
		return type;
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
	public void addFunction(String value) {
	      if (this.function == null)
	        this.function = new ArrayList<String>();
	      this.function.add(value);		
	}
	public void addSupportedProtocol(String value) {
	      if (this.supportedProtocol == null)
	        this.supportedProtocol = new ArrayList<String>();
	      this.category.add(value);		
	}
	/*
	public void addSupportedUnits(String value) {
		StringType t = new StringType();
	      t.setValue(value);
	      if (this.supportedUnits == null)
	        this.supportedUnits = new ArrayList<StringType>();
	      this.supportedUnits.add(t);		
	}*/
	public void addSupportedUnits(String value) {
	      if (this.supportedUnits == null)
	        this.supportedUnits = new ArrayList<String>();
	      this.supportedUnits.add(value);		
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
    
	 public boolean hasDeviceClass() { 
         return this.deviceClass != null && !this.deviceClass.isEmpty();
       }
    
	 public boolean hasFunction() { 
         return this.function != null && !this.function.isEmpty();
       }
    
	 public boolean hasSupportedProtocol() { 
         return this.supportedProtocol != null && !this.supportedProtocol.isEmpty();
       }
    
	 public boolean hasSupportedUnits() { 
         return this.supportedUnits != null && !this.supportedUnits.isEmpty();
       }
    
	 public boolean hasEnergyLimitationClass() { 
         return this.energyLimitationClass != null && !this.energyLimitationClass.isEmpty();
       }
    
	 public boolean hasModelName() { 
         return this.modelName != null && !this.modelName.isEmpty();
       }
	 public boolean hasManufacturerName() { 
         return this.manufacturerName != null && !this.manufacturerName.isEmpty();
       }
	 public boolean hasName() { 
         return this.name != null && !this.name.isEmpty();
       }
	 public boolean hasDescription() { 
         return this.description != null && !this.description.isEmpty();
       }
	 public boolean hasDocumentation() { 
         return this.documentation != null;
       }
	 
	 public boolean hasImage() { 
         return this.image != null;
       }
	 public boolean hasDateModified() { 
         return this.dateModified != null;
	 }
	 public boolean hasDateCreated() { 
         return this.dateCreated != null;
	 }


	public boolean hasBrandName() {
		return this.brandName != null && !this.brandName.isEmpty();
	}
	 
    
	
	 
    
    
    
    
    
    
    

}
