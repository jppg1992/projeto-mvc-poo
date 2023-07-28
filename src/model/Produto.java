package model;

public class Produto {
	private String nome;
	private float preco;
	private int codigoBarras;
	private int quantidade;
	
	public Produto() {
		
	}
	
	public Produto(String nome, float preco) {
		this.nome=nome;
		this.preco=preco;
	}
	
	public void abastecer(int quantidade) {
		this.quantidade+=quantidade;
	}
	
	public void desabastecer(int quantidade) {
		if(this.quantidade>=quantidade)
		this.quantidade-=quantidade;
	}

	@Override
	public String toString() {
		return "nome: " + this.nome + "\npreço: " + this.preco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
