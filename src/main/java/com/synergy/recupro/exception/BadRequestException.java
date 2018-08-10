package com.synergy.recupro.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	public static final Logger logger = LogManager
			.getLogger(BadRequestException.class);

    public BadRequestException(String message) {
        super(message);
        logger.info(message + " Class Name :: " +Thread.currentThread().getStackTrace()[2].getClassName()+  " Method Name :: " +Thread.currentThread().getStackTrace()[2].getMethodName().toString());
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
        logger.info(message, cause+ " Class Name :: " +Thread.currentThread().getStackTrace()[2].getClassName() + " Method Name :: " +Thread.currentThread().getStackTrace()[2].getMethodName().toString());
    }
}
