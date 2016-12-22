package corrida;
import java.util.Random;
import javax.swing.*;

public class Raia extends Thread{
	
	private Controle botao;
	private JProgressBar raia;
	private int num;
	
	public Raia(int num, JProgressBar r, Controle b) {
		this.raia = r;
		this.botao = b;
		this.num = num;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			Random t = new Random();
			espera(t.nextInt(400));
			raia.setValue(i);
		}
		if(this.botao.isControle() == false){
			this.botao.setControle(true);
			this.botao.setContador();
			System.out.println("Raia "+num+" ganhou - "+botao.getContador()+"º lugar");	
			Ganhador g = new Ganhador(num);
			g.start();
		}else{
			this.botao.setContador();
			System.out.println("Raia "+num+" perdeu - "+botao.getContador()+"º lugar");
		}
		if(this.botao.getContador() == 4){
			this.botao.setBotao();
		}			
	}
	
	private synchronized void espera(int tempo){
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
