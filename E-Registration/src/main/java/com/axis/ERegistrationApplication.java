package com.axis;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.event.EventListener;

import com.axis.email.EmailSenderService;
import com.axis.entity.PdfFile;
import com.axis.repository.PdfFileRepository;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import jakarta.mail.MessagingException;

@SpringBootApplication

public class ERegistrationApplication {
	@Autowired
	EmailSenderService emailSenderService;
	@Autowired
	PdfFileRepository  fileRepo;

	public static void main(String[] args) {
		SpringApplication.run(ERegistrationApplication.class, args);
	}
	public class EmailHelper {
		
		
		@EventListener(ApplicationReadyEvent.class)
		 public void triggerMail() throws MessagingException {
			List<PdfFile> pdfFiles = fileRepo.findAll();

		 for (PdfFile emailSender : pdfFiles) {
			 //LocalDate startDate = emailSender.getStartDate();
			 LocalDate expiryDate = emailSender.getExpiryDate();
			 String status = emailSender.getStatus();
			 String email = emailSender.getUserEmail();
			 LocalDate todayDate = LocalDate.now();

		if (status.equals("Not Paid") && ChronoUnit.DAYS.between(todayDate, expiryDate) == 30) {
			String[] toEmails = { email };
			emailSenderService.sendSimpleEmail(toEmails, "Testing", "This is a reminder to pay the due");
			}
		}

		}
	}


}
