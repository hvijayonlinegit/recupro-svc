package com.synergy.recupro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public interface IAws3Service {

	List<PutObjectResult> upload(MultipartFile[] multipartFiles,int id);

	List<S3ObjectSummary> list();

}