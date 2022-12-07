package br.com.willbigas.workervalidador.service;

import br.com.willbigas.workervalidador.exceptions.LimiteIndisponivelException;
import br.com.willbigas.workervalidador.exceptions.SaldoInsuficienteException;
import br.com.willbigas.workervalidador.model.Cartao;
import br.com.willbigas.workervalidador.model.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ValidadorService {

	public void validarPedido(Pedido pedido) {
		validarLimiteDisponivel(pedido.getCartao());
		validarCompraComLimite(pedido);
	}

	private void validarCompraComLimite(Pedido pedido) {
		if (pedido.getValor().longValue() > pedido.getCartao().getLimiteDisponivel().longValue()) {
			log.error("Valor do pedido {}. Limite disponivel: {}" , pedido.getValor() , pedido.getCartao().getLimiteDisponivel());
			throw new LimiteIndisponivelException("Você não tem limite para efetuar essa compra" , null);
		}
	}

	private void validarLimiteDisponivel(Cartao cartao) {
		if (cartao.getLimiteDisponivel().longValue() <= 0L)  {
			throw new SaldoInsuficienteException("Limite Indisponivel", null);
		}
	}
}
