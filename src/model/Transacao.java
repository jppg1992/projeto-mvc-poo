package model;

public interface Transacao extends PagamentoAvista, PagamentoAprazo {
	public void pagar (float valor);
	public void receber (float valor);
}
