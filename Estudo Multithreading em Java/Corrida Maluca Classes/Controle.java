package corrida;
import javax.swing.JButton;

public class Controle {

	private boolean controle;
	private JButton botao;
	private int contador;
	
	public Controle(boolean b, JButton c) {
		this.botao = c;
		this.controle = b;
	}
	
	public boolean isControle() {
		return controle;
	}
	
	public int getContador() {
		return contador;
	}
	
	public synchronized void setContador() {
		this.contador++;
	}
	
	public synchronized void setBotao() {
		this.botao.setEnabled(true);
	}
	
	public synchronized void setControle(boolean controle) {
		this.controle = controle;
	}	
}
