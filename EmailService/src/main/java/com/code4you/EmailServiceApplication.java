package com.code4you;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.code4you.emailsenderservice.MailSender;

@SpringBootApplication
public class EmailServiceApplication {
	
	@Autowired
	private MailSender service;
	
	public static void main(String[] args) {
		
		SpringApplication.run(EmailServiceApplication.class, args);
		
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		service.sendSimpleEmail("sawganeshkumar15@gmail.com",
				"This is Email Body with Attachment...",
				"This email has attachment");

	}

}
