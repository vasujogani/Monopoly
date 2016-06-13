package mainClient;

import javax.swing.JButton;

public class RejectButton extends JButton {
	
	private IClient client;
	
	public RejectButton(IClient c){
		super("Reject");
		client = c;
	}

}
