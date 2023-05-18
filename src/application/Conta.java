package application;

public abstract class Conta implements IConta {
	
	protected static int SEQUENCIAL = 1;
	protected static final int AGENCIA_PADRAO = 1;
	protected int agencia;
	protected int conta;
	protected double saldo = 0.0;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.cliente = cliente;
		this.agencia = AGENCIA_PADRAO;
		this.conta = SEQUENCIAL++;
	}

	public Conta(int agencia, int conta, double saldo) {
		this.agencia = agencia;
		this.conta = conta;
		this.saldo = saldo;
		
	}

	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	
	protected void imprimirInfosComuns() {
		System.out.println("Titular: "+cliente.getNome());
		System.out.println("Agencia: "+agencia);
		System.out.println("Conta: "+conta);
		System.out.println(String.format("Saldo: %.2f", saldo));
	}

	
	
}
