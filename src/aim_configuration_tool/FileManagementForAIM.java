package aim_configuration_tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManagementForAIM {
	public static String readORcreateFile(String filename)
	{	  
	  File file = new File(filename);
	  	  
	  try
	  {
		  //Create the file
		  if (file.createNewFile())
		  {
		      System.out.println("File is created!");
		  } else {
		      System.out.println("File already exists.");
		  }
		  
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String data;
			data = reader.readLine();	    
			reader.close();			
			System.out.println("Reading successful.");
					
			if(data==null && filename.equals("altitude.dat"))
			{
				data="250";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("bcklght.dat"))
			{
				data="9";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("BT_name.txt"))
			{
				data="AIM";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("BT_PIN.txt"))
			{
				data="1234";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("code.txt"))
			{
				data="ASDF";
				writeToFile(filename, data);
			}else if(data==null && filename.startsWith("disp_") && filename.endsWith(".dat"))
			{
				data="1";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("latit.txt"))
			{
				data="48.153625";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("longit.txt"))
			{
				data="17.16187";
				writeToFile(filename, data);
			}else if(data==null && filename.startsWith("player_") && filename.endsWith(".txt"))
			{
				data=filename.substring(0, 8);
				writeToFile(filename, data);
			}else if(data==null && filename.equals("RF_ch.txt"))
			{
				data="4";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("RF_pwr.txt"))
			{
				data="7";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("track.dat"))
			{
				data="0";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("track_NO.dat"))
			{
				data="0";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("user.txt"))
			{
				data="a";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("UTC.txt"))
			{
				data="0";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("x_m_off.dat"))
			{
				data="-126";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("x_m_rng.dat"))
			{
				data="763";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("y_m_off.dat"))
			{
				data="41";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("y_m_rng.dat"))
			{
				data="518";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("z_m_off.dat"))
			{
				data="101";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("z_m_rng.dat"))
			{
				data="202";
				writeToFile(filename, data);
			}else if(data==null && filename.equals("Import KML.url"))
			{
				data="[InternetShortcut]\r\nURL=https://www.google.sk/maps/d/\r\n";
				writeToFile(filename, data);
			}
			
			String[] data_split = data.split("\0");
			
			data = data_split[0];
							
			return data;
	  }
	  catch (Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
	
	public static boolean writeToFile(String filename, String data)
	{
		Main.lblStatus.setText("Writing files:");
		Main.pi.setProgress(0.0);
		File file = new File(filename);
		
		try
		{
			  //Create the file
			  if (file.createNewFile())
			  {
			      System.out.println("File is created!");
			  } else {
			      System.out.println("File already exists.");
			  }
			
			//Write Content
			FileWriter writer = new FileWriter(file);
			writer.write(data);
			writer.close();
			System.out.println("File write successful.");
			Main.pi.setProgress(1.0);			
			return true;
		}
		catch (Exception e)
		{
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		    Main.pi.setProgress(0.0);
		    Main.lblStatus.setText("File error:");
		    return false;
		}
	}
}
