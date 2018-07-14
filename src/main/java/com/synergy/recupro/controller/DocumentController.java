/**
 * 
 */
package com.synergy.recupro.controller;

import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.synergy.recupro.config.AwsConfig;
import com.synergy.recupro.exception.AppException;
import com.synergy.recupro.service.Aws3ServiceImpl;

/**
 * @author Ahmar
 *
 */
@RestController
public class DocumentController {

	@Autowired
	private Aws3ServiceImpl aws3ServiceImpl;

	@Autowired
	AwsConfig awsConfig;

	@Autowired
	private AmazonS3 amazonS3;

	@Autowired
	ResourceLoader resourceLoader;

	String message = "";

	@PostMapping(value = "/upload")
	public ResponseEntity<String> upload(
			@RequestParam("file") MultipartFile[] multipartFiles,
			@RequestParam("id") int id) {
		try {

			aws3ServiceImpl.upload(multipartFiles, id);

		} catch (Exception e) {

			throw new AppException("Error while uploading file");
		}
		message = "File successfully uploaded !";
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@GetMapping(value = "/download")
	public ResponseEntity<?> download(@RequestParam String key,
			@RequestParam("id") int id) {

		String folderKey = Integer.toString(id) + "/" + key;
		/*
		 * String bucket = "https://s3.amazonaws.com/" + awsConfig.getBucket() +
		 * folderKey;
		 */
		try {
			GetObjectRequest getObjectRequest = new GetObjectRequest(
					awsConfig.getBucket(), folderKey);

			S3Object s3Object = amazonS3.getObject(getObjectRequest);

			S3ObjectInputStream objectInputStream = s3Object.getObjectContent();

			byte[] bytes = IOUtils.toByteArray(objectInputStream);

			String fileName = URLEncoder.encode(key, "UTF-8").replaceAll("\\+",
					"%20");

			/* Resource s3Resource = resourceLoader.getResource(bucket); */
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			httpHeaders.setContentDispositionFormData("attachment", fileName);
			return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);

		} catch (Exception e) {
			throw new AppException("Error while downloading file");
		}

	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> list() {

		List<S3ObjectSummary> detailList = aws3ServiceImpl.list();
		if (detailList.isEmpty()) {
			throw new AppException("List of Object is empty");
		}
		return new ResponseEntity<>(detailList, HttpStatus.OK);

	}
}