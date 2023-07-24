package model;

public abstract class PessoaJuridica {
	private long cnpj;
	private String razaoSocial;
	private String nome;
	
	public PessoaJuridica() {
		
	}
	
	public PessoaJuridica(long cnpj, String razaoSocial, String nome) {
		this.cnpj=cnpj;
		this.razaoSocial=razaoSocial;
		this.nome=nome;
	}

	@Override
	public String toString() {
		return "CNPJ: " + this.cnpj + "\nrazao social: " + this.razaoSocial + "\nnome: " + this.nome;
	}
	
	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
