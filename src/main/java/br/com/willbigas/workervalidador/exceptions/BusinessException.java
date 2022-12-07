package br.com.willbigas.workervalidador.exceptions;

public class BusinessException extends RuntimeException {

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
