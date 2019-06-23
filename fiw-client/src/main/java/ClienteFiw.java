import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClienteFiw {
	private static final Logger log = LoggerFactory.getLogger(ClienteFiw.class);
	private String address;
	private String port;
	private RestTemplate restTemplate;
	public ClienteFiw() {
		//default
		this.address="localhost";
		this.port = "1026";
		restTemplate = new RestTemplate();
	}
	public ClienteFiw(String address,String port) {
		this.address=address;
		this.port =port;
		restTemplate = new RestTemplate();
	}
	
		
	public DeviceModel getDeviceModelFromId(String id) {
		
		String url = String.format("http://%s:%s/v2/entities/%s?options=keyValues",address, port,id);
		DeviceModel model = null;
		try {
			model = restTemplate.getForObject(url, DeviceModel.class);
		}catch(Exception e) {
			
		}
		
		return model;
	}
	
	public DeviceFiw getDeviceFromId(String id) {
			
		String url = String.format("http://%s:%s/v2/entities/%s?options=keyValues",address, port, id);
		DeviceFiw device = null;
		try {
			device = restTemplate.getForObject(url, DeviceFiw.class);
		}catch(Exception e) {
				
		}
			
		return device;
		}
	
	public Attribute getAttribute(String id,String type,String atrributeName) {
		
		String url = String.format("http://%s:%s/v2/entities/%s/attrs/%s?type=%s", address,port,id,atrributeName,type);
		Attribute attr = null;
		try {
			attr = restTemplate.getForObject(url, Attribute.class);
		}catch(Exception e) {
			
		}
		
		return attr;
	}
	
	public int deleteEntity(String id, String type) {
		int returnValue = 0;
		String url = String.format("http://%s:%s/v2/entities/%s?type=%s", address,port,id,type);
		try {
			restTemplate.delete(url);
			returnValue = 1;
		}catch(Exception e){
			
		}
		
		return returnValue;
		}
	
	public int updateAttribute(String id,String type,String attributeName,Attribute newValue) {
		int returnValue = 0;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Attribute> requestUpdate = new HttpEntity<Attribute>(newValue,headers);
		String url = String.format("http://%s:%s/v2/entities/%s/attrs/%s?type=%s", address,port,id,attributeName,type);
		
		try {
			restTemplate.exchange(url, HttpMethod.PUT,requestUpdate,Void.class);
			returnValue = 1;
		}catch(Exception e){
			
		}
		return returnValue;	
	}
	
	public int removeAttribute(String id,String type, String attributeName) {
		int returnValue=0;
		String url = String.format("http://%s:%s/v2/entities/%s/attrs/%s?type=%s", address,port,id,attributeName,type);
		try {
			restTemplate.delete(url);
			returnValue=1;
		}catch(Exception e){
			
		}
	
		return returnValue;
	}
	
	public URI createEntity(Entity entity) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Entity> request = new HttpEntity<Entity>(entity,headers);
		String url = String.format("http://%s:%s/v2/entities",address,port);
		URI location = null;
		try {
			location = restTemplate.postForLocation(url, request);
		}catch(Exception e){
			
		}
		return location;
	}
	/*work in progress: no le pasa exactamente un Attribute, es un tipo de dato que no está definido como una clase, en Entity es un Map. de String , Attribute
	queria hacer el update/append entity attributes
	public URI appendAttribute(String id, String type,Attribute newValue) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Attribute> request = new HttpEntity<Attribute>(newValue,headers);
		String url = String.format("http://%s:%s/v2/entities/%s/attrs?%s", address,port,id,type);
		URI location = null;
		try {
			location = restTemplate.postForLocation(url, request);
		
		}catch(Exception e) {
			
		}
		return location;
	}*/
	
	
	
	
	
	public int updateEntity(String id,String type,Map<String,Attribute> map) {
		int returnValue = 0;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String,Attribute>> request = new HttpEntity<Map<String,Attribute>>(map,headers);
		String url = String.format("http://%s:%s/v2/entities/%s/attrs?type=%s", address,port,id,type);
		try {
			restTemplate.exchange(url, HttpMethod.PUT,request,Void.class);
			returnValue = 1;
		}catch(Exception e){
			
		}
		return returnValue;	
	}
	
	//entonces de lo importante quedaría actualiazr entidades
	//paso al tema de las subscripciones
	
	//crear subscripción
	
	public URI createSubscription(Subscription sub) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Subscription> request = new HttpEntity<Subscription>(sub,headers);
		String url = String.format("http://%s:%s/v2/subscriptions",address,port);
		// de la url podemos sacar la id 
		//String url = "http://ptsv2.com/t/96gc8-1561228803/post";
		URI location = null;
		try {
			location = restTemplate.postForLocation(url, request);
		}catch(Exception e){
			
		}
		return location;
		
	}
	
	public Subscription getSubscription(String subId) {
		String url = String.format("http://%s:%s/v2/subscriptions/%s",address, port, subId);
		Subscription subs = null;
		try {
			subs = restTemplate.getForObject(url, Subscription.class);
		}catch(Exception e) {
				
		}
		return subs;
	}
	
	public List<Subscription> listSubscription(String limit){
		//al ser una lista hay que hacerlo de forma especial
		
		String url = String.format("http://%s:%s/v2/subscriptions?limit=%s", address,port,limit);
		List<Subscription> list = new ArrayList<Subscription>();
		try {
			ResponseEntity<List<Subscription>> response = restTemplate.exchange(
					url,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<Subscription>>(){});
					list = response.getBody();
		}catch(Exception e){
			
		}
		return list;
	}
	//no admite patch y es la que indica el standar?
	public int updateSubscription(String subId,Subscription sub) {
		
		String url = String.format("http://%s:%s/v2/subscriptions/%s", address,port, subId);
		int returnValue = 0;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Subscription> request = new HttpEntity<Subscription>(sub,headers);
		
		try {
			restTemplate.exchange(url, HttpMethod.PATCH,request,Void.class);
			returnValue = 1;
		}catch(Exception e){
			log.info(e.toString());
		}
		return returnValue;
		
	}
	
	public int deleteSubscription(String subId){
		int returnValue = 0;
		String url = String.format("http://%s:%s/v2/subscriptions/%s", address,port,subId);
		try {
			restTemplate.delete(url);
			returnValue = 1;
		}catch(Exception e){
			
		}
		
		return returnValue;
		}
	}
	
	
	


