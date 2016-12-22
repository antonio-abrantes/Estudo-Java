package sb.principal;
import javax.swing.JOptionPane;

public class MenuCliente {

	public MenuCliente(Banco banco) {
		int op;
		String menuPrincipal = "  #    MENU CLIENTE    #\n";
		menuPrincipal += "# Informe o tipo da conta:\n";
		menuPrincipal += "# 1 = Conta Corrente\n";		
		menuPrincipal += "# 2 = Conta Poupança\n";
		menuPrincipal += "# 0 = Sair\n";
				
		while(true){
			try {	
				op = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal+"\nTipo: "));				
				if(op == 0)
					break;
				String nome = JOptionPane.showInputDialog("Nome do cliente:");
				Conta conta = banco.buscar(op, nome);
				
				while(true){
					if(conta != null){
						String menu = "Opções da conta nº : de "+conta.getNumero()+"\nSaldo R$: "+conta.getSaldo();
						menu += "\nSaques disponiveis: "+conta.getQtdSaques();
						menu += "\n"+"1 - Depositar\n"+"2 - Sacar"+"\n0 - Sair";
						int opS = Integer.parseInt(JOptionPane.showInputDialog(menu+"\nOpções de conta"));
						if(opS == 0){
							break;
						}
							
						double valor = 0;
						switch (opS) {
						case 1:
							try {
								valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do deposito: "));
								conta.depositar(valor);
								JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso...");
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
							}
							break;
						case 2:							
							try {
								conta.verificaQtdSacques(conta.getQtdSaques());
								valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque: "));
								conta.sacar(valor);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
							}											
							break;
						default:
							JOptionPane.showMessageDialog(null, "Opção invalida!!!");
							break;
						}
				    }else{
				    	JOptionPane.showMessageDialog(null, "Cliente não cadastrado!!");
				    	break;
				    }
				}
					
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
			};			
		}
	}
}
