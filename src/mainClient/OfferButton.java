package mainClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class OfferButton extends JButton implements ActionListener {

	private IClient client;
	
	public OfferButton(IClient client2) {
		// TODO Auto-generated constructor stub
		super("Offer");
		client = client2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		client.send("OFFER ");
		
	}
}
