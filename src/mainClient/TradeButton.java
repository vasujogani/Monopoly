package mainClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TradeButton 
extends JButton 			//FancyButton is-a JButton
implements ActionListener {
	
	private IClient client;
	private ICardLabel[][] cards;
	private boolean inside;
	private JLabel label;
	
	public TradeButton(IClient c, String s){
		//something must go here
		super("Trade");
		System.out.println("@TradeButton Created one!");
		client = c;
		addActionListener(this);
		inside = false;
	}
	
	
	public void actionPerformed(ActionEvent e){
		client.send("TRADE");
	}
}
