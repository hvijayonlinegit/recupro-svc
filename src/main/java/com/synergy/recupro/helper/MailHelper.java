package com.synergy.recupro.helper;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.synergy.recupro.model.User;

@Service
public class MailHelper {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private EnvironmentHelper environmentHelper;
	    
	
	public void sendEmail(User user, String location) throws Exception{

		
	    	MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        
	        final String  SUBJECT = "new user to recupro";
	        
	        StringBuilder mailBody = new StringBuilder(1000);
	        
	         mailBody.append("hello team").append("\n").append("A new user has been registered to recupro.").append("\n").append("Please find details below:").append("\n")
	        .append("Name					:"+user.getName()).append("\n")
	        .append("Email					:"+user.getEmail()).append("\n")
	        .append("User Name				:"+user.getUsername()).append("\n")
	        .append("Created At				:"+user.getCreatedAt()).append("\n")
	        .append("record Created in 		:"+environmentHelper.getEnvironmentForLocation(location));
	
	        helper.setTo(environmentHelper.getPropertyFromPropertiesFile("custom.mail.to-address"));
	        helper.setText(mailBody.toString());
	        helper.setSubject(SUBJECT);
	        
	        sender.send(message);
	    }


}
