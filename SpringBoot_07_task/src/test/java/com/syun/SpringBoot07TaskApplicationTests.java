package com.syun;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
class SpringBoot08TaskApplicationTests {
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Test
	void contextLoads() {
		// 發送簡單郵件
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setSubject("SpringBoot Mail Test");
		message.setText("發送成功");
		message.setTo("xxxxx@gmail.com");
		message.setFrom("xxxxx@gmail.com");
		
		mailSender.send(message);
	}

	@Test
	void contextLoads2() throws MessagingException{
		// 發送複雜郵件
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		helper.setSubject("SpringBoot MimeMail Test");
		// true表示字段為html
		helper.setText("<p style='color:red'>發送成功</p>", true);
		
		// 附件
		helper.addAttachment("123.jsp", new File("C:\\test_site\\images\\test.jpg"));
		
		helper.setTo("xxxxx@gmail.com");
		helper.setFrom("xxxxx@gmail.com");
		
		mailSender.send(mimeMessage);
	}
}
