package model;

import java.util.ArrayList;
import java.util.List;

public class Empresa extends PessoaJuridica implements Transacao{
	private float caixa;
	private float dividas;
	private float receitas;
	private List <Produto> produtos = new ArrayList<Produto>();
	private List <Cliente> clientes = new ArrayList<Cliente>();
	private List <Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	public final static int AVISTA=1;
	public final static int APRAZO=2;
	
	public Empresa() {
		
	}
	public Empresa(float caixa, float dividas, float receitas) {
		this.caixa=caixa;
		this.dividas=dividas;
		this.receitas=receitas;
	}
	public Empresa(long cnpj, String razaoSocial, String nome, List<Produto> produtos, List<Cliente> clientes, List<Fornecedor> fornecedores) {
		super(cnpj, razaoSocial, nome);
		this.produtos=produtos;
		this.clientes=clientes;
		this.fornecedores=fornecedores;
	}
	
	@Override
	public void pagar(float valor) {
		dividas+=valor;
	}
	@Override
	public void receber(float valor) {
		receitas = valor+receitas;
	}
	public float vender(Produto produto, Cliente cliente, int formaPag, int quantidade) {
		float descontos=0;
		float juros=0;
		if(cliente.isVip()) {
			descontos+=produto.getPreco()*getDesconto();
		}
		if(formaPag==AVISTA) {
			descontos+=produto.getPreco()*getDesconto();
		}
		else if(formaPag==APRAZO) {
			juros+=produto.getPreco()*(getJuros()*2);
		}
		return ((produto.getPreco()-descontos+juros)*quantidade);
	}
	public float comprar (Produto produto, Fornecedor fornecedor, int formaPag, int quantidade) {
		float descontos=0;
		float juros=0;
		if(fornecedor.isParceria()) {
			descontos+=produto.getPreco()*(getDesconto()*2);
		}
		if(formaPag==AVISTA) {
			descontos+=produto.getPreco()*(getDesconto()*2);
		}
		else if(formaPag==APRAZO) {
			juros+=produto.getPreco()*getJuros();
		}
		return((produto.getPreco()-descontos+juros)*quantidade);
		
	}
	
	
	public void balanco() {
		caixa = receitas - dividas+caixa;
		receitas=0;
		dividas=0;
		
		
	}
	
	public float getCaixa() {
		return caixa;
	}
	public void setCaixa(float caixa) {
		this.caixa = caixa;
	}
	public float getDividas() {
		return dividas;
	}
	public void setDividas(float dividas) {
		this.dividas = dividas;
	}
	public float getReceitas() {
		return receitas;
	}
	public void setReceitas(float receitas) {
		this.receitas = receitas;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public static int getAvista() {
		return AVISTA;
	}
	public static int getAprazo() {
		return APRAZO;
	}
	@Override
	public float getDesconto() {
		return 0.10f;
	}
	@Override
	public float getJuros() {
		
		return 0.10f;
	}
	
	
	
}
