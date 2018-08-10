package com.synergy.recupro.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	public static final Logger logger = LogManager
			.getLogger(ResourceNotFoundException.class);
	private String resourceName;
	private String fieldName;
	private Object fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName,
			Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName,
				fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		String err = Thread.currentThread().getStackTrace()[2].getMethodName().toString();
		logger.info(String.format("%s not found with %s : '%s'", resourceName,
				fieldName, fieldValue)+" Class Name :: " +Thread.currentThread().getStackTrace()[2].getClassName()+ " Method Name :: " +err.substring(7));
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
}
