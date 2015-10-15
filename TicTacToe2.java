import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe2 extends JFrame{
	
	private JPanel p = new JPanel(); 
	private JPanel d = new JPanel();
	private JLabel announcement = new JLabel();
	private tttButton2 buttons[] = new tttButton2[9];
	private String type = null;
	public static int clicks;
	public static String sX = ""; 
	public static String sO = "";
	public static String movescombo;
	public static String singleCombo;
	public static int points = 0;
	private static JLabel gameLabel = new JLabel();
	public static String test;
	
	
	public static void main (String [] args){
		new TicTacToe2();
	}
	
	public TicTacToe2 (){
		super("TicTacToe");   
		setSize(700,700); 
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(3, 3));
		for(int i = 0; i< 9; i++){
			buttons[i] = new tttButton2(i); 
			buttons [i].setPreferredSize(new Dimension(200, 200));
			buttons [i].setActionCommand(Integer.toString(i + 1)); // setActionCommand to set a reference for each button when clicked
			p.add(buttons[i]);
		}
		add(p, BorderLayout.CENTER);
		
		announcement.setSize(new Dimension(600, 200));
		announcement = new JLabel (test);
		d.add(announcement);
		add(d, BorderLayout.PAGE_END);
		
		pack();
		setVisible(true);		
	
	}
	
	
	
	public static void setGameLabel(String gamestatus){
		gameLabel = new JLabel (gamestatus);
	}
	
	
}
