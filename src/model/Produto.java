package model;

public class Produto {
	private String nome;
	private float preco;
	
	public Produto() {
		
	}
	
	public Produto(String nome, float preco) {
		this.nome=nome;
		this.preco=preco;
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
	
}
