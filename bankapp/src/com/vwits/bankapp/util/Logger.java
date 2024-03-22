package com.vwits.bankapp.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

	public static final String INFO = "INFO";
	public static final String ERROR = "ERROR";
	
	//name of the log file
	private static final String FILE_NAME = "bankapp.log";
	
	public static void writeLog(String level , String method)
	{
		try (FileWriter writer = new FileWriter(FILE_NAME,true)) 
		{
			
			writer.write(level +" " + new Date() +" " + method +"\n" );
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	//this is responsible for logging exceptions
	public static void writeLog(String level , String method , Exception e)
	{
		try (FileWriter writer = new FileWriter(FILE_NAME,true)) 
		{
			String message = "";
			StackTraceElement[] stackTrace = e.getStackTrace();
			for (StackTraceElement stackTraceElement : stackTrace) {
				message += stackTraceElement.toString()  +"     ";
			}
			System.out.println("message");
			writer.write(level +" " + new Date() +" " + method + " " + message +"\n");
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}


}
