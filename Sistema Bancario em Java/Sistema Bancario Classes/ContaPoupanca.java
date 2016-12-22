package sb.principal;
import java.util.Random;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(String nome) throws Exception{
		super(nome);		
		this.depositar(50.00);
	}

}
