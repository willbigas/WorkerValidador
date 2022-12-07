package br.com.willbigas.workervalidador.service.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueCompraFinalizadaConfig {

	@Value("${queue_name_producer}")
	private String queueNameProducer;

	@Bean
	public Queue queue() {
		return new Queue(queueNameProducer, true);
	}
}
