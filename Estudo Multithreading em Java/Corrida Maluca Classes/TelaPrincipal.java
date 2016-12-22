package corrida;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaPrincipal extends JFrame{
	
	private JButton btIniciar;
	private JPanel pnCima;
	private JPanel pnRaia1;
	private JPanel pnRaia2;
	private JPanel pnRaia3;
	private JPanel pnRaia4;
	private JProgressBar pb1;
	private JProgressBar pb2;
	private JProgressBar pb3;
	private JProgressBar pb4;
	
	public TelaPrincipal() {
		this.setLayout(new GridLayout(5, 1));
		
		this.btIniciar = new JButton("INICIAR");
		this.pnCima = new JPanel();
		this.pnCima.setBackground(Color.blue);
		this.pnCima.add(btIniciar);
		this.add(pnCima);
		
		this.pnRaia1 = new JPanel();
		this.pnRaia1.setBackground(Color.yellow);
		//Conteudo raia 1
		this.pb1 = new JProgressBar();
		this.pnRaia1.add(pb1);
		//this.pb1.setValue(20);
		this.add(pnRaia1);
		
		this.pnRaia2 = new JPanel();
		this.pnRaia2.setBackground(Color.green);
		//Conteudo raia 2
		this.pb2 = new JProgressBar();
		this.pnRaia2.add(pb2);
		this.add(pnRaia2);
		
		this.pnRaia3 = new JPanel();
		this.pnRaia3.setBackground(Color.white);
		//Conteudo raia 3
		this.pb3 = new JProgressBar();
		this.pnRaia3.add(pb3);
		this.add(pnRaia3);
		
		this.pnRaia4 = new JPanel();
		this.pnRaia4.setBackground(Color.blue);
		//Conteudo raia 4
		this.pb4 = new JProgressBar();
		this.pnRaia4.add(pb4);
		this.add(pnRaia4);
		
		this.btIniciar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {	
				iniciar();
			}
		});
		this.setTitle("CoRrIdA MaLuKa");
		this.setLocationRelativeTo(null);
		this.setSize(300, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
	}
	
	private void iniciar(){
		Controle controle = new Controle(false, btIniciar);
		this.btIniciar.setEnabled(false);
		Raia r1 = new Raia(1, this.pb1, controle);
		Raia r2 = new Raia(2, this.pb2, controle);
		Raia r3 = new Raia(3, this.pb3, controle);
		Raia r4 = new Raia(4, this.pb4, controle);
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		System.out.println("========================");
	}

}
