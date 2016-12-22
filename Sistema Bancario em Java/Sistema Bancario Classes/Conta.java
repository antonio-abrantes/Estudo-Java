package sb.principal;
import java.util.List;

import javax.swing.JOptionPane;

public abstract class Conta {

	private int qtdSaques;
	private int numero;
	private String titular;
	private double saldo;
			
	public Conta(String nome) {
		this.titular = nome;
		this.qtdSaques = 3;
	}
	
	public int getQtdSaques() {
		return qtdSaques;
	}
	
	public void verificaQtdSacques(int qtd) throws Exception{
		if(this.qtdSaques == 0){
			throw new Exception("Limite de saques diario excedido");
		}
	}
	
	public void depositar(double valor) throws Exception{
		if(valor > 0){
			this.saldo += valor;
		}else if(valor <= 0){
			throw new Exception("Valor negativo ou igual a zero");
		}else{
			throw new Exception("Caracter invalido");
		}
	}
	
	public void sacar(double valor) throws Exception{
		if(valor <= saldo && valor > 0 && this.qtdSaques > 0){
			this.saldo -= valor;
			this.qtdSaques--;
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso...");
		}else if(valor > saldo){
			throw new Exception("Saldo insuficiente");			
		}else if(valor <= 0){
			throw new Exception("Valor negativo ou igual a zero");
		}else{
			throw new Exception("Caracter invalido");
		}
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getTitular() {
		return titular;
	}
	public double getSaldo() {
		return saldo;
	}
}
