package com.lmg.cursomc.service;

import com.lmg.cursomc.domain.Cliente;
import com.lmg.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationHtmlEmail(Pedido pedido);

    void sendHtmlEmail(MimeMessage msg) throws MessagingException;

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
