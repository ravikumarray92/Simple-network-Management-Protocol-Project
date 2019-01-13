import java.io.*;
import java.util.*;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
public class SNMPManager
{

Snmp snmp = null;
String address = null;
public SNMPManager(String add)
{
address = add;
}

public static void main(String[] args) throws IOException 
	{
	
	SNMPManager client = new SNMPManager("udp:169.254.46.184/161");
	//SNMPManager client = new SNMPManager("udp:127.0.0.1/161");
	client.start();
	String usi = client.getAsString(new OID(MibOid.deviceStorageUnits+1));
	System.out.println(" Sector Size="+usi);
	String unt = client.getAsString(new OID(MibOid.deviceTotalUnits+1));
	System.out.println(" Total Sector="+unt);
	Long ll=Long.parseLong(usi)*Long.parseLong(unt)/(1024*1024*1024);
	System.out.println(" TOTAL SIZE ="+ll);
	int i=1;
	
	String upt = client.getAsString(new OID(MibOid.packageName+i));
	 while(!upt.equals("Null"))
		{

		System.out.println(" Time Started="+upt);
		i++;
		upt = client.getAsString(new OID(MibOid.packageName+i));
		}
	System.out.println(" Total SOftware ="+i);
        
	
	
	
	}

	public void start() throws IOException
	 {
	TransportMapping transport = new DefaultUdpTransportMapping();
	snmp = new Snmp(transport);
	transport.listen();
	}

	public String getAsString(OID oid) throws IOException
	 {
	ResponseEvent event = get(new OID[]{ oid});
	return event.getResponse().get(0).getVariable().toString();
	}
	
	public ResponseEvent get(OID oids[]) throws IOException 
	{
	PDU pdu = new PDU();
		for (OID oid : oids) 
		{
		pdu.add(new VariableBinding(oid));
		}
		pdu.setType(PDU.GET);
		ResponseEvent event = snmp.send(pdu, getTarget(), null);
		if(event != null) 
		{
			return event;
		}
		throw new RuntimeException("GET timed out");
	}

	public Vector<String> getReponseList(OID oids[]) throws IOException
		{
		ResponseEvent event = get(oids);
		Vector<String> vv=new Vector<String>();
		for(int k=0;k<oids.length;k++)
			{
			vv.addElement(event.getResponse().get(k).getVariable().toString());	
			}
		 return(vv);
		}
	private Target getTarget()
	 {
	Address targetAddress = GenericAddress.parse(address);
	CommunityTarget target = new CommunityTarget();
	target.setCommunity(new OctetString("bluetech"));
	target.setAddress(targetAddress);
	target.setRetries(2);
	target.setTimeout(1500);
	target.setVersion(SnmpConstants.version2c);
	return target;
	}

}
