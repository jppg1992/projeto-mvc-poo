package model;

public class Fornecedor extends PessoaJuridica {
	private boolean parceria;
	
	public Fornecedor() {
		super();
	}
	
	public Fornecedor(long cnpj, String razaoSocial, String nome, boolean parceria) {
		super(cnpj, razaoSocial, nome);
		this.parceria=parceria;
	}

	@Override
	public String toString() {
		return super.toString() + "\nO fornecedor tem parceria? " + this.parceria;
	}
	
	public boolean isParceria() {
		return parceria;
	}

	public void setParceria(boolean parceria) {
		this.parceria = parceria;
	}
	
}
