import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class ClienteFiw {
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
	
	public int delete(String id, String type) {
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
	
	
	
	
	
	

}
