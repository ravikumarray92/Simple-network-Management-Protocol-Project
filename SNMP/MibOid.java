public interface MibOid
{
 public static final String sysDesc=".1.3.6.1.2.1.1.1.0";  /* computer router manage switch */
 public static final String sysName=".1.3.6.1.2.1.1.5.0";
 public static final String snmpName=".1.3.6.1.2.1.1.4.0";
 public static final String snmpLocation=".1.3.6.1.2.1.1.6.0";
 public static final String noOfUsers=".1.3.6.1.2.1.25.1.5.0";
 public static final String sysUpTime=".1.3.6.1.2.1.25.1.1.0";	/* 2:45:56.333 time diff (curTime-startTime) */
 public static final String sysDateTime="1.3.6.1.2.1.25.1.2.0";	/* hexa decimal Number 07:de:0a:13:0f:31:06:08*/
 
 public static final String ramSize=".1.3.6.1.2.1.25.2.2.0"; 	/* in KB */

 public static final String HD_DRIVE_OID="1.3.6.1.2.1.25.2.1.4";	/* means it is HD used to check Drive Type*/
 public static final String CD_ROM_OID="1.3.6.1.2.1.25.2.1.7";
 public static final String REMOVABLE_DRIVE_OID="1.3.6.1.2.1.25.2.1.5";
 public static final String VIRTUAL_MEM_OID="1.3.6.1.2.1.25.2.1.3";
 public static final String PHYSICAL_MEM_OID="1.3.6.1.2.1.25.2.1.2";

 public static final String deviceIndex=".1.3.6.1.2.1.25.2.3.1.1."; 	/* (starts by 1 ,if exits then retun given Index */ 
 public static final String deviceType=".1.3.6.1.2.1.25.2.3.1.2.";  	/* return (OID Object) HD_DRIVE_OID as above etc */
 public static final String deviceString=".1.3.6.1.2.1.25.2.3.1.3."; 	/* C:\ Label:  Serial Number a06270bb */
 public static final String deviceStorageUnits=".1.3.6.1.2.1.25.2.3.1.4."; /* give size of bytes per Unit */
 public static final String deviceTotalUnits=".1.3.6.1.2.1.25.2.3.1.5.";	/* retun total units , to get Size =UNITS*StorageUnits*/
 public static final String deviceTotalUsedUnits=".1.3.6.1.2.1.25.2.3.1.6.";

 public static final String noOfProcesses=".1.3.6.1.2.1.25.1.6.0"; 		/* included own UDP Calling */
	public static final String processIdCheck=".1.3.6.1.2.1.25.4.2.1.1."; 	/* .1.3.6.1.2.1.25.4.2.1.1.pid if process exist ther return that number */
	public static final String processName=".1.3.6.1.2.1.25.4.2.1.2.";		/* .1.3.6.1.2.1.25.4.2.1.2.pid */
	public static final String processLocation=".1.3.6.1.2.1.25.4.2.1.4."; 	/* Name excluded */
	public static final String processParameter=".1.3.6.1.2.1.25.4.2.1.5.";    /* Command Line Argument Values */
	public static final String processWorkingMemory=".1.3.6.1.2.1.25.5.1.1.2."; /* Working Set Memory in KB */
	public static final String processCpuTime=".1.3.6.1.2.1.25.5.1.1.1."; /* 455 --> 4.55 sec . 100 -> 1 sec */
 	
	public static final String packageCheck=".1.3.6.1.2.1.25.6.3.1.1.";	/* .1.3.6.1.2.1.25.6.3.1.1.PACKINDEX  return PACKINDEX*/
	public static final String packageName=".1.3.6.1.2.1.25.6.3.1.2.";		/* Only Name */
	public static final String packageId=".1.3.6.1.2.1.25.6.3.1.3.";		/* default 0.0 */
	public static final String packageDate=".1.3.6.1.2.1.25.6.3.1.5.";		/* aa:dd:ee:56:a4:45:b2:00 */

 public static final String noOfNetworkInterfaces=".1.3.6.1.2.1.2.1.0";
	public static final String nicName=".1.3.6.1.2.1.2.2.1.2.";		/* in hexa decimal  */
	public static final String nicSpeed=".1.3.6.1.2.1.2.2.1.5.";		/* bits per seconds - currrent bandtwidth*/
	public static final String nicMAC=".1.3.6.1.2.1.2.2.1.6.";			/* Hexa Deciaml */ 
	
	
}