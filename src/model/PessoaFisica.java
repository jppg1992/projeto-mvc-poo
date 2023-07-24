package model;

public abstract class PessoaFisica {
	private long cpf;
	private long rg;
	private String nome;
	
	public PessoaFisica() {
		
	}
	
	public PessoaFisica(long cpf, long rg, String nome) {
		this.cpf=cpf;
		this.rg=rg;
		this.nome=nome;
	}

	@Override
	public String toString() {
		return "CPF: " + this.cpf + "\nRG: " + this.rg + "\nNome: " + this.nome;
	}
	
	
	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
