package com.Attrezzo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String remetente;
	
	public String enviarEmailTexto(String destino, String assunto, String mensagem) {
		
		try {
			SimpleMailMessage simpleMessage = new SimpleMailMessage();
			simpleMessage.setFrom(remetente);
			simpleMessage.setTo(destino);
			simpleMessage.setSubject(assunto);
			simpleMessage.setText(mensagem);
			javaMailSender.send(simpleMessage);
			return "Email enviado";
		}
		catch(Exception e) {
			return "erro ao enviar email";
		}
	}
}
