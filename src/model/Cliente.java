package model;

public class Cliente extends PessoaFisica {
	private boolean vip;
	
	public Cliente() {
		super();
	}
	
	public Cliente(long cpf, long rg, String nome, boolean vip) {
		super(cpf, rg, nome);
		this.vip=vip;
	}

	@Override
	public String toString() {
		return super.toString() + "\nO cliente é vip? " + this.vip;
	}
	
	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
}
