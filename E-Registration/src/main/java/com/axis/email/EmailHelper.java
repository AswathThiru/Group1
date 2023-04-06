package com.axis.email;

//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//
//
//import com.axis.entity.PdfFile;
//import com.axis.repository.PdfFileRepository;
//
//import jakarta.mail.MessagingException;
//
//public class EmailHelper {
//	@Autowired
//	EmailSenderService emailSenderService;
//	@Autowired
//	PdfFileRepository  fileRepo;
//	
//	@EventListener(ApplicationReadyEvent.class)
//	 public void triggerMail() throws MessagingException {
//		List<PdfFile> pdfFiles = fileRepo.findAll();
//
//	 for (PdfFile emailSender : pdfFiles) {
//		 //LocalDate startDate = emailSender.getStartDate();
//		 LocalDate expiryDate = emailSender.getExpiryDate();
//		 String status = emailSender.getStatus();
//		 String email = emailSender.getUserEmail();
//		 LocalDate todayDate = LocalDate.now();
//
//	if (status.equals("Not Paid") && ChronoUnit.DAYS.between(todayDate, expiryDate) == 30) {
//		String[] toEmails = { email };
//		emailSenderService.sendSimpleEmail(toEmails, "Testing", "This is a reminder to pay the due");
//		}
//	}
//
//	}
//}
