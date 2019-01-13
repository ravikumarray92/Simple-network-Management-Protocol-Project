class SnmpFormat
 {      static int yy=0,mm=0,dd=0,hh=0,mn=0,ss=0,ml=0;
	
	public SnmpFormat()
		{
		
		
		}
	public static String  getDiskType(String oid)
		{
		    if(oid.equals(MibOid.HD_DRIVE_OID))
			{
			 return("HD");
			}
		    else if(oid.equals(MibOid.CD_ROM_OID))
			{
			 return("CDROM");
			}
		    else if(oid.equals(MibOid.REMOVABLE_DRIVE_OID))
			{
			 return("USB");
			}
		  else if(oid.equals(MibOid.VIRTUAL_MEM_OID))
			{
			 return("VIRTUAL");
			}
		  else if(oid.equals(MibOid.PHYSICAL_MEM_OID))
			{
			 return("PHYSICAL");
			}
		  else
			{ return("");
			}
		}
	public static long getLong(String no)
		{
			 try{
				long ii=Long.parseLong(no);
				return(ii);
				}
			 catch(Exception ee)
				{
				 return(0L);
				}
		}
	public static String getDate(String hex)
	{	
		String date="";
		try{
		if(hex!=null && (hex.length()==16 || hex.length()==23))
		{
			String thex=hex.replaceAll(":","");
			yy=Integer.parseInt(thex.substring(0,4),16);
			mm=Integer.parseInt(thex.substring(4,6),16);
			dd=Integer.parseInt(thex.substring(6,8),16);
			hh=Integer.parseInt(thex.substring(8,10),16);
			mn=Integer.parseInt(thex.substring(10,12),16);
			ss=Integer.parseInt(thex.substring(12,14),16);
			ml=Integer.parseInt(thex.substring(14),16);
		}
		  }catch(Exception ee){}
		date=""+yy+"-"+mm+"-"+dd+"  "+hh+":"+mn+":"+ss+":"+ml;
		return(date);
	}
	public static String getString(String hex)
	{
	 String data="";
		if(hex!=null && hex.length()>=1)
		{
		 hex=hex.replaceAll(":","");
		 for(int i=0;i<=(hex.length()-2);i=i+2)
			{
			char k=(char)(Integer.parseInt(hex.substring(i,i+2),16));
			data=data+k;
			}
		}
	return(data);
	}
	public static void main(String tt[])
	{
		SnmpFormat dd=new SnmpFormat();
		System.out.println(dd.getDate("07:de:0a:1ff3:06:24:22:09"));
		//53:6f:66:74:77:61:72:65:20:4c:6f:6f:70:62:61:63:6b:20:49:6e:74:65:72:66:61:63:65:20:31:00
		System.out.println(dd.getString("57:41:4e:20:4d:69:6e:69:70:6f:72:74:20:28:53:53:54:50:29:00"));
	}
 }