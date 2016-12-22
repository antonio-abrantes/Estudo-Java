package corrida;
import javax.swing.JOptionPane;

public class Ganhador extends Thread{
	
	private int num;
	
	public Ganhador(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		ganhador();
	}
	
	public void ganhador(){
		JOptionPane.showMessageDialog(null, "O "+num+" ganhou!!");
	}
}
