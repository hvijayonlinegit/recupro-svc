package com.synergy.recupro.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.synergy.recupro.constants.RecuproApplicationConstants;

@Service
public class EnvironmentHelper {

	@Autowired
	private Environment environment;
	
	public static String getEnvironmentForLocation(String location) throws Exception
	{
		if(location.isEmpty() || location==null)
		{
			throw new Exception ("Location is empty, Unable to determine the environment");
		}
		if(location.contains("localhost"))
		{
			return RecuproApplicationConstants.DEV_ENVIRONMENT;
		}
		if(location.contains(" "))
		{
			return RecuproApplicationConstants.PROD_ENVIRONMENT;
		}
		
		return RecuproApplicationConstants.EMPTY_STRING;
	}
	
	public String getPropertyFromPropertiesFile(String propertyName) throws Exception
	{
		if(environment.getProperty(propertyName) == null || 
				environment.getProperty(propertyName).isEmpty())
			
		{
			throw new Exception("Invalid Property Name or Value, "
					+"Property Doesn't exists in "
					+ "Application.properties"+ "Property Name:" + propertyName +" "
					+ "Property Value:"+environment.getProperty(propertyName)); 
		}
		
		return environment.getProperty(propertyName); 
	}
}
