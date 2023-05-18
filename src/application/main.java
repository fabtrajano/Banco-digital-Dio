package application;

public class main {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Fabricio");
		
		Conta cc = new ContaCorrente(cliente);
		Conta cp = new ContaPoupanca(cliente);
		
		cc.transferir(250, cp);
		cp.imprimirExtrato();
		cc.imprimirExtrato();
		
	}

}
