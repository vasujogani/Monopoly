package mainClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TradeButton 
extends JButton 			//FancyButton is-a JButton
implements ActionListener {
	IClient client;
	
	public TradeButton(String s){
		super(s);
		System.out.println("@TradeButton Construtor done");
		addActionListener(this);
	}
	
	public TradeButton(IClient c, String s){
		//something must go here
		super(s);
		System.out.println("@TradeButton Created one!");
		client = c;
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		client.send("TRADE");
	}
}
