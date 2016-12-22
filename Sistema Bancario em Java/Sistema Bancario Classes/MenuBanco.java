package sb.principal;
import javax.swing.JOptionPane;

public class MenuBanco {

	public MenuBanco(){
		Banco banco = new Banco();
		
		int op;
		String menuPrincipal = "  #    SISTEMA BANCARIO    #\n";
		menuPrincipal += "# Opcões:          \n";
		menuPrincipal += "# 1 = Cadastrar Conta Corrente\n";		
		menuPrincipal += "# 2 = Cadastrar Conta Poupança\n";
		menuPrincipal += "# 3 = Listas clientes\n";
		menuPrincipal += "# 4 = Acessar conta\n";
		menuPrincipal += "# 0 = Sair\n";
		
		while(true){
			try {
				op = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal+"\nDigite a opção: "));
				if(op == 0)
					break;
				
				switch (op) {
				case 1:
					banco.criarConta(op);
					break;
				case 2:
					banco.criarConta(op);
					break;
				case 3:
					String menu = "Listar:\n"+"1 - Contas Corrente\n"+"2 - Contas Poupança"+"\n0 - Cancelar";
					int cliente = Integer.parseInt(JOptionPane.showInputDialog(menu+"\nOpções de conta"));
					banco.listar(cliente);
					break;
				case 4:
					MenuCliente mCliente = new MenuCliente(banco);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção invalida!!");
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
			};			
		}
	}
	
}
