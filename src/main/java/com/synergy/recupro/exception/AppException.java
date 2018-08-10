package com.synergy.recupro.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {

	public static final Logger logger = LogManager
			.getLogger(AppException.class);

	public AppException(String message) {
		super(message);
		logger.info(message +" Class Name :: " +Thread.currentThread().getStackTrace()[2].getClassName()+  " Method Name :: " +Thread.currentThread().getStackTrace()[2].getMethodName().toString());

	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
		logger.info(message, cause+" Class Name :: " +Thread.currentThread().getStackTrace()[2].getClassName()+  " Method Name :: " +Thread.currentThread().getStackTrace()[2].getMethodName().toString());
	}
}
