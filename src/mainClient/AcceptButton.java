package mainClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AcceptButton extends JButton implements ActionListener{
	
	private IClient client;
	
	public AcceptButton(IClient c){
		super("Accept");
		client = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
