import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    public static void main(String args[]) {
    	ClienteFiw client = new ClienteFiw();
    	/*
        DeviceModel devicemodel = client.getDeviceModelFromId("myDevice-wastecontainer-sensor-345");
        if(devicemodel == null) {
        	log.info("Error get DeviceModel from id");
        }else {
        	log.info(devicemodel.getId());
        }
        DeviceFiw device = client.getDeviceFromId("device-9845A");
        if(device == null) {
        	log.info("Error get Device from id");
        }else {
        	log.info(device.getId());
        }
        */
        //client.delete("device-9845A", "Device");
        /*
        Attribute attr = new Attribute();
        attr.setValue("1440");
        client.updateAttribute("device-9845A", "Device", "value", attr);
        client.removeAttribute("device-9845A", "Device", "value");*/
    	/*
    	DeviceModel devicemodel = new DeviceModel();
    	devicemodel.setId("prueba");
    	devicemodel.setDescription("esto es una prueba");
    	Entity entity = new Entity();
    	entity = NgsiParser.deviceModelAdapter(devicemodel);
    	URI location = client.createEntity(entity);
    	log.info(location.toString());
    	*/
    	/*
    	DeviceModel devicemodel = new DeviceModel();
    	devicemodel.setId("prueba");
    	devicemodel.setDescription("esto es una prueba");
    	devicemodel.setBrandName("NOKIA");
    	Entity entity = new Entity();
    	entity = NgsiParser.deviceModelAdapter(devicemodel);
    	
    	URI locationAttr = client.appendAttribute("prueba", "DeviceModel", newValue)*/
    	/*
    	Map<String,Attribute> mapa = new HashMap<String, Attribute>();
    	Attribute brandName = new Attribute();
    	brandName.setValue("Nokia");
    	mapa.put("brandName", brandName);
    	client.updateEntity("prueba", "DeviceModel", mapa);*/
    	
    	/*
    	Subscription sub = new Subscription();
    	sub.setDescription("Esto es una prueba");
    	SubjectSubscription aux= new SubjectSubscription();
    	
    	SubjectEntity entity = new SubjectEntity(".*","DeviceModel");
    	
    	Condition cond = new Condition();
    	List<String> attrs = new ArrayList<String>();
    	attrs.add("brandName");
    	cond.setAttrs(attrs);
    	
    	aux.setCondition(cond);
    	aux.addEntities(entity);
    	
    	sub.setSubject(aux);
    	
    	Notification not = new Notification();
    	HttpFiw http = new HttpFiw();
    	try {
			http.setUrl(new URL("http://ptsv2.com/t/96gc8-1561228803/post"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	not.setHttp(http);
    	sub.setNotification(not);
    	Date date = new Date(System.currentTimeMillis());

    	
    	SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    	sdf.setTimeZone(TimeZone.getTimeZone("CET"));
    	String text = sdf.format(date);
    	sub.setExpires(text);
    	sub.setThrottling(5);
    	
    	URI returnvalue = client.createSubscription(sub);
    	log.info(returnvalue.toString());*/
    	/*
    	Subscription prueba = client.getSubscription("5d0f598d67c802a1b12e8b0c");
    	log.info(prueba.getDescription());
    	List<Subscription> list = client.listSubscription("10");
    	log.info(list.get(0).getDescription());
    	log.info(""+list.size());
    	*/
    	/*
    	Subscription nuevaexpire = new Subscription();
    	nuevaexpire.setExpires("2022-04-05T14:00:00.00Z");
    	int result = client.updateSubscription("5d0f598d67c802a1b12e8b0c", nuevaexpire);
    	log.info(""+result);*/
    	//client.deleteSubscription("5d0f598d67c802a1b12e8b0c");
    	
    }
    

}
