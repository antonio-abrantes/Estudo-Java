package sb.principal;
import java.util.Random;

import javax.swing.JOptionPane;

public class ContaCorrente extends Conta{

	public ContaCorrente(String nome, double saldo){
		super(nome);	
		try {
			this.depositar(saldo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		};
	}

}
