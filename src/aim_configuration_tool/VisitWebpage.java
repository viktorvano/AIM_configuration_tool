package aim_configuration_tool;

import java.awt.Desktop;
import java.net.URI;

public class VisitWebpage {

    public static void eshop()
    {
    	try
    	{
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI("https://www.cyberairsoft.eu/");
			  desktop.browse(oURL);
    	} catch (Exception e)
    	{
    		  e.printStackTrace();
    	}
    }
    
    public static void facebook()
    {
    	try
    	{
    		  Desktop desktop = java.awt.Desktop.getDesktop();
    		  URI oURL = new URI("https://www.facebook.com/CyberAirsoft.eu/");
    		  desktop.browse(oURL);
    	} catch (Exception e)
    	{
    		  e.printStackTrace();
    	}
    }
    
    public static void youtube()
    {
    	try
    	{
    		  Desktop desktop = java.awt.Desktop.getDesktop();
    		  URI oURL = new URI("https://www.youtube.com/channel/UCL9JvnyiWljZUuTKxSESKIg/videos");
    		  desktop.browse(oURL);
    	} catch (Exception e)
    	{
    		  e.printStackTrace();
    	}
    }
    
    public static void google_maps()
    {
    	try
    	{
    		  Desktop desktop = java.awt.Desktop.getDesktop();
    		  URI oURL = new URI("https://www.google.sk/maps");
    		  desktop.browse(oURL);
    	} catch (Exception e)
    	{
    		  e.printStackTrace();
    	}
    }
    
    public static void lat_long()
    {
    	try
    	{
    		  Desktop desktop = java.awt.Desktop.getDesktop();
    		  URI oURL = new URI("https://www.latlong.net/");
    		  desktop.browse(oURL);
    	} catch (Exception e)
    	{
    		  e.printStackTrace();
    	}
    }
    
    public static void google_maps_KML()
    {
    	try
    	{
    		  Desktop desktop = java.awt.Desktop.getDesktop();
    		  URI oURL = new URI("https://www.google.sk/maps/d/");
    		  desktop.browse(oURL);
    	} catch (Exception e)
    	{
    		  e.printStackTrace();
    	}
    }
    
    public static void time_zones()
    {
    	try
    	{
    		  Desktop desktop = java.awt.Desktop.getDesktop();
    		  URI oURL = new URI("https://www.timeanddate.com/time/map/");
    		  desktop.browse(oURL);
    	} catch (Exception e)
    	{
    		  e.printStackTrace();
    	}
    }
}
