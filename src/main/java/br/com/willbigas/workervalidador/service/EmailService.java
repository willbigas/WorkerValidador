package br.com.willbigas.workervalidador.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService {

	private final JavaMailSender javaMailSender;

	public void notificarClienteLimiteInsuficiente(String email, String numeroPedido) {
		var msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Pedido " + numeroPedido + " - Limite Insuficiente");
		msg.setText("Este é um e-mail de aviso que sua compra do pedido " + numeroPedido + " não foi finalizada, pois não ha limite suficiente para compra. " +
				"\nObrigado por comprar com a gente!!");
		javaMailSender.send(msg);
		log.info("Cliente notificado com sucesso!!");
	}

	public void notificarClienteCompraFinalizada(String email, String numeroPedido) {
		var msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Pedido " + numeroPedido + " - Compra Finalizada");
		msg.setText("Este é um e-mail de aviso que seu pedido de numero " + numeroPedido + " foi finalizada, e já esta a caminho do seu endereço. " +
				"\nObrigado por comprar com a gente!!");
		javaMailSender.send(msg);
		log.info("Cliente notificado com sucesso!!");
	}
}
