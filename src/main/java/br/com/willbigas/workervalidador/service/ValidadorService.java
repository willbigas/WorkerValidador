package br.com.willbigas.workervalidador.service;

import br.com.willbigas.workervalidador.model.Cartao;
import br.com.willbigas.workervalidador.model.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ValidadorService {

	public void validarPedido(Pedido pedido) throws Exception {
		validarLimiteDisponivel(pedido.getCartao());
		validarCompraComLimite(pedido);
	}

	private void validarCompraComLimite(Pedido pedido) throws Exception {
		if (pedido.getValor().longValue() > pedido.getCartao().getLimiteDisponivel().longValue()) {
			log.error("Valor do pedido {}. Limite disponivel: {}" , pedido.getValor() , pedido.getCartao().getLimiteDisponivel());
			throw new Exception("Você não tem limite para efetuar essa compra");
		}
	}

	private void validarLimiteDisponivel(Cartao cartao) throws Exception {
		if (cartao.getLimiteDisponivel().longValue() <= 0L)  {
			throw new Exception("Limite Indisponivel");
		}
	}
}
