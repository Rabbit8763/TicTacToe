import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class tttButton2 extends JButton implements ActionListener {
	private ImageIcon X = new ImageIcon("/Users/Mac/Desktop/workspace/X.png");
	private ImageIcon O = new ImageIcon("/Users/Mac/Desktop/workspace/O.png");
	private ImageIcon mainButtonImage = null;
	private JFrame frame;
	private String buttonnumber;
	private String lastButton;
	private static int repeat = 0;
	public String [] arr1 = {"123", "456", "789", "147", "258", "369", "159", "357"};
	private int r;
	private String xwin = "X has won!";
	private String owin = "O has won!";


	public tttButton2(int i){
		X = new ImageIcon("/Users/Mac/Desktop/workspace/X.png"); 
		O = new ImageIcon("/Users/Mac/Desktop/workspace/O.png");
		this.addActionListener(this); //adding to ourselves - we are triggering and listening to action 	
	}
	
	/*
	 * setting the counter and using a count (clicks) via TTT2 to capture overall count. 
	 * if use "clicks" within the button class, it only counts the clicks within a specific instance 
	 * of the button click. have to pull out of class into main TTT2 class to keep counter.
	 * then use button setting through mainButtonImage to make sure that once image is set, it will not
	 * be overwritten.
	 */
	
	public void counter() {
		if (TicTacToe2.clicks%2 == 0){
			if(mainButtonImage == null){
				mainButtonImage = O;
			} else { 
				TicTacToe2.clicks --;
			}
		} 
		else { 
			if(mainButtonImage == null ){
				mainButtonImage = X;
			} else {
				TicTacToe2.clicks --;
			}
		}
	}
	
	public void sequence() {
		if(lastButton != null && lastButton == buttonnumber){} 
		else {
			if(mainButtonImage == X){ 
				TicTacToe2.sX = TicTacToe2.sX + buttonnumber; 
			}
			if(mainButtonImage == O){ 
				TicTacToe2.sO = TicTacToe2.sO + buttonnumber;
			}
		}	
	}
	
	/*
	 * algo: take each of the winning combos from the winning combo array, set to element, then loop 
	 * through the entry combos one by one to match. have to set repeat variable because this is 
	 * activated through the action clicker. therefore, we have to subtract out noise/clicks.
	 */
	public void checkwinner(String series){
		TicTacToe2.movescombo = series; 
		for (int i = 0; i < arr1.length; i++){
			TicTacToe2.points = 0; 
			TicTacToe2.singleCombo = arr1 [i];
			for (int j = 0; j < TicTacToe2.singleCombo.length(); j++){
				char c = TicTacToe2.singleCombo.charAt(j);
				repeat = 0;
				for(int t = 0; t < TicTacToe2.movescombo.length(); t++){
					char s = TicTacToe2.movescombo.charAt(t);
					if(c == s && repeat == 0 ){
						TicTacToe2.points ++;
						repeat ++; 
						if(TicTacToe2.points == 3){
							if(series == TicTacToe2.sX){
								JOptionPane.showMessageDialog(frame, "X has won!");	
							} 
							if(series == TicTacToe2.sO){ 
								if(series == TicTacToe2.sO){
									JOptionPane.showMessageDialog(frame, "O has won!");
								}
							}						
							break;
						} else {}
					} 
				 
				}
			}
		}
	}
	

	
	@Override
	public void actionPerformed (ActionEvent e){
	
		
		TicTacToe2.clicks ++;
		counter();
		setIcon(mainButtonImage);
		lastButton = buttonnumber;
		buttonnumber = e.getActionCommand();
	
		sequence();
		// JOptionPane.showMessageDialog(frame, buttonnumber + " XButtons are " + TicTacToe2.sX);
		
		checkwinner(TicTacToe2.sX);
		checkwinner(TicTacToe2.sO);
		
	} 
		
}

