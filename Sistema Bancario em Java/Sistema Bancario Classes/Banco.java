package sb.principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Banco {
	
	public static final int CONTA_CORRENTE = 1;
	public static final int CONTA_POUPANCA = 2;
	private List<Conta> contasCorrente;
	private List<Conta> contasPoupanca;
	
	public Banco() {
		contasCorrente = new ArrayList<Conta>();
		contasPoupanca = new ArrayList<Conta>();
	}
	
	public Conta buscar(int op, String nome){		
		if(op == 1){
			for (Conta conta : contasCorrente) {
				if(conta.getTitular().equals(nome)){
					return conta;
				}
			}
			return null;
		}
		if(op == 2){
			for (Conta conta : contasPoupanca) {
				if(conta.getTitular().equals(nome)){
					return conta;
				}
			}
			return null;
		}
		return null;
	}
	
	public void listar(int tipo) {
		if(tipo == CONTA_CORRENTE){
			if(contasCorrente.isEmpty()){
				JOptionPane.showMessageDialog(null, "Sem clientes cadastrados...");
			}else{
				for (Conta conta : contasCorrente) {
					System.out.println("Nº: "+conta.getNumero()+", Titular: "+ conta.getTitular());
					System.out.println("Saldo R$: "+conta.getSaldo());
				}
			}
		}else if(tipo == CONTA_POUPANCA){
			if(contasPoupanca.isEmpty()){
				JOptionPane.showMessageDialog(null, "Sem clientes cadastrados...");
			}else{
				for (Conta conta : contasPoupanca) {
					System.out.println("Nº: "+conta.getNumero()+", Titular: "+ conta.getTitular());
					System.out.println("Saldo R$: "+conta.getSaldo());
				}
			}		
		}
	}
	
	public void criarConta(int tipo){
		String nome = JOptionPane.showInputDialog("Nome: ");
		int novoNumero = geraNumero(tipo);
			
		if(tipo == CONTA_CORRENTE){			
			try {
				Double saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo inicial: "));
				ContaCorrente nova = new ContaCorrente(nome, saldo);
				nova.setNumero(novoNumero);
				this.contasCorrente.add(nova);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
			}
		}
		if(tipo == CONTA_POUPANCA){
			try {
				ContaPoupanca nova = new ContaPoupanca(nome);
				nova.setNumero(novoNumero);
				this.contasPoupanca.add(nova);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso...");
	}
	
	public int geraNumero(int tipo){
		Random numero = new Random();
		int novoNum;
			
		if(tipo == CONTA_CORRENTE){
			novoNum = numero.nextInt(10000);
			while(this.verificaNumero(contasCorrente, novoNum) == false){
				novoNum = numero.nextInt(10000);
			}
			return novoNum;
		}else if(tipo == CONTA_POUPANCA){
			novoNum = numero.nextInt(500);
			while(this.verificaNumero(contasPoupanca, novoNum) == false){
				novoNum = numero.nextInt(500);
			}
			return novoNum;
		}else{
			return 0;
		}
	}
	
	public boolean verificaNumero(List<Conta> lista, int num){
		for (Conta conta : lista) {
			if(conta.getNumero() == num){
				return false;
			}
		}	
		return true;
	}
}
