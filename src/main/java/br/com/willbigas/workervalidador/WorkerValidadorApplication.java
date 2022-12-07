package br.com.willbigas.workervalidador;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class WorkerValidadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkerValidadorApplication.class, args);
	}

}
