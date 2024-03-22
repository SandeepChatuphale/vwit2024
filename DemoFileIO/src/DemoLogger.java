
//to deal with files java has offered many classes from "java.io" package

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class DemoLogger {

	private static String LOG_LEVEL_ERROR = "ERROR";
	private static String LOG_LEVEL_INFO = "INFO";
	
	public static void main(String[] args) {

		writeLog(LOG_LEVEL_ERROR, "withdrawTransaction");
		writeLog(LOG_LEVEL_INFO, "openAccount");
	}
	
	public static void writeLog(String level , String method)
	{
		try (FileWriter writer = new FileWriter("bankapp.log",true)) 
		{
			
			writer.write(level +" " + new Date() +" " + method +"\n" );
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
