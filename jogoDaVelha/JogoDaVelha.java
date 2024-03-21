package jogoDaVelha;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JogoDaVelha implements ActionListener {
	
	Random random = new Random();
	JFrame tela = new JFrame();
	JPanel titulo = new JPanel();
	JPanel buton = new JPanel();
	JLabel texto = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean jogador1_vez;
	int jogadas =0;
	
	
	JogoDaVelha(){
		
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(600,600);
		tela.getContentPane().setBackground(new Color(50,50,50));
		tela.setLayout(new BorderLayout());
		tela.setVisible(true);

		texto.setBackground(new Color(25,25,25));
		texto.setForeground(new Color(25,255,0));
		texto.setFont(new Font("INK Free", Font.BOLD, 72));
		texto.setHorizontalAlignment(JLabel.CENTER);
		texto.setText("Jogo da Velha");
		texto.setOpaque(true);
		
		titulo.setLayout(new BorderLayout());
		titulo.setBounds(0,0,800,100);
		
		buton.setLayout(new GridLayout(3,3));
		buton.setBackground(new Color(150,150,150));
		
		for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			buton.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD , 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setText("");
		}
		
		titulo.add(texto);
		tela.add(titulo, BorderLayout.NORTH);
		tela.add(buton);
		
		primeiroTurno();
		
		
	
	}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jogadas++;
		
		for(int i=0; i<9; i++) {
			
			if(e.getSource()==buttons[i]) {
				if(jogador1_vez) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color( 255,0,0));
						buttons[i].setText("X");
						jogador1_vez=false;
						texto.setText("A vez do O");
						verifica();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color( 0,0,255));
						buttons[i].setText("O");
						jogador1_vez=true;
						texto.setText("A vez do X");
						verifica();
					}
					
				}
			}
		}
		
	}
	
	public void primeiroTurno() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0) {
			jogador1_vez = true;
			texto.setText("A vez do X");
		}
		else {
			jogador1_vez = false;
			texto.setText("A vez do O");
		}
	}
	
	public void verifica() {
		// Vitória do X
			
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				)	{
				xGanha(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				)	{
				xGanha(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				)	{
				xGanha(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				)	{
				xGanha(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				)	{
				xGanha(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				)	{
				xGanha(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				)	{
				xGanha(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				)	{
				xGanha(2,4,6);
		}
		
		//O vence
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				)	{
				oGanha(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				)	{
				oGanha(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				)	{
				oGanha(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				)	{
				oGanha(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				)	{
				oGanha(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				)	{
				oGanha(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				)	{
				xGanha(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				)	{
				xGanha(2,4,6);
		}
		
		if(jogadas == 9) {
			empate();			
		}
		
					
		
	}
	
	public void xGanha(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9 ; i++) {
			buttons[i].setEnabled(false);
		}
		texto.setText("X Venceu");
	}
	
	public void oGanha(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9 ; i++) {
			buttons[i].setEnabled(false);
		}
		texto.setText("O Venceu");
		
	}
	
	public void empate() {
		for(int i=0; i<9; i++) {
			buttons[i].setBackground(Color.GRAY);
			buttons[i].setEnabled(false);
		}
		texto.setText("Empate");
		
	}
}
