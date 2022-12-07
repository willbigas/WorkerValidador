package br.com.willbigas.workervalidador.service.producer;

import br.com.willbigas.workervalidador.model.Pedido;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerCompraFinalizada {

	private final RabbitTemplate rabbitTemplate;
	private final Queue queue;
	private final ObjectMapper mapper;

	public void produzirMensagem(Pedido pedido) throws JsonProcessingException {
		log.info("Enviando Mensagem {} para a fila {}", pedido.toString() , queue.getName());
		rabbitTemplate.convertAndSend(queue.getName() , mapper.writeValueAsString(pedido));
	}

}
