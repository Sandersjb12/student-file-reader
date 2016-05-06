//Jeremy Sanders
//Insy 4305-001

import java.io.*;
import java.util.*;

public class CreateFiles
{
	public static void writeCustomers()
	{
		Formatter output;

		try
		{
			output=new Formatter("customers.txt");
			output.format("%s %s %s %s %d %d %s \r\n","Jones","786Cooper","Arlington","Texas",76019,12345,"student");
			output.format("%s %s %s %s %d %d %s \r\n","Smith","921Bowen","Arlington","Texas",76006,65489,"faculty");
			output.format("%s %s %s %s %d %d %s \r\n","Barker","621Lancaster","FortWorth","Texas",76090,54367,"student");
			output.format("%s %s %s %s %d %d %s \r\n","Callan","978Lowe","Dallas","Texas",75009,98712,"faculty");
			output.format("%s %s %s %s %d %d %s \r\n","Willis","123King","Tulsa","Oklahoma",56909,25968,"government");
			output.format("%s %s %s %s %d %d %s \r\n","James","109Baker","Dallas","Texas",75010,73674,"faculty");
			output.format("%s %s %s %s %d %d %s \r\n","Parsons","4523Azalea","Burleson","Texas",76134,26789,"government");
			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public static void writeCourses()
	{
		Formatter output;

		try
		{
			output=new Formatter("courses.txt");
			output.format("%s %s %s %.2f %d %d %d %d %d %d %s %s %s %d %s\r\n","Online","Java1","Davis",125.0,1,1,2015,2,1,2015,"programming","UTA",true,12,"Jones");
			output.format("%s %s %s %.2f %d %d %d %d %d %d %s %s %s %d %s\r\n","Online","Java2","Davis",125.0,2,2,2015,3,1,2015,"programming","UTA",true,12,"Jones");
			output.format("%s %s %s %.2f %d %d %d %d %d %d %s %s %s %d %s\r\n","Online","RelieveStress","Jones",35.0,3,2,2015,3,31,2015,"misc","none",false,5,"Smith");
			output.format("%s %s %s %.2f %d %d %d %d %d %d %s %s %s %d %s\r\n","Online","Painter2015","Vikram",59.0,3,2,2015,3,31,2015,"painting","TCU",false,8,"Parsons");
		
			output.format("%s %s %s %.2f %d %d %d %d %d %d %s %s %d %d %d %d %s\r\n","InClass","CanonPictures","Long",75.0,1,15,2015,2,3,2015,"photography","COB142",17,30,18,50,"Jones");
			output.format("%s %s %s %.2f %d %d %d %d %d %d %s %s %d %d %d %d %s\r\n","InClass","PlayThePiano","Smith",40.0,4,1,2015,5,1,2015,"music","UH105",13,30,15,30,"Smith");
			output.format("%s %s %s %.2f %d %d %d %d %d %d %s %s %d %d %d %d %s\r\n","InClass","PlayThePiano","Smith",40.0,4,1,2015,5,1,2015,"music","UH105",13,30,15,30,"Willis");
			output.format("%s %s %s %.2f %d %d %d %d %d %d %s %s %d %d %d %d %s\r\n","InClass","Acting101","Simon",69.0,4,5,2015,6,1,2015,"misc","CH106",8,0,10,0,"Parsons");
			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}