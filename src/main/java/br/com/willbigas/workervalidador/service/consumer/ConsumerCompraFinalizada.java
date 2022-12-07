package br.com.willbigas.workervalidador.service.consumer;

import br.com.willbigas.workervalidador.model.Pedido;
import br.com.willbigas.workervalidador.service.producer.ProducerCompraFinalizada;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConsumerCompraFinalizada {

	private final ObjectMapper mapper;
	private final ProducerCompraFinalizada producerCompraFinalizada;

	@RabbitListener(queues = {"${queue_name_consumer}"})
	public void consumer(@Payload Message message) throws IOException {
		Pedido pedido = mapper.readValue(message.getBody(), Pedido.class);
		System.out.println("Mensagem recebida - Worker Validador -> "  + pedido);
		producerCompraFinalizada.enviarFilaCompraFinalizada(pedido);
	}
}
