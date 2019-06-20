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
        
        Attribute attr = new Attribute();
        attr.setValue("1440");
        client.updateAttribute("device-9845A", "Device", "value", attr);
        client.removeAttribute("device-9845A", "Device", "value");
    }

}
