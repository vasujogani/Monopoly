package mainClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AddButton extends JButton implements ActionListener{

	private IClient client;
	private JComboBox list;
	private String type;
	private JFrame frame;
	private JTextArea temp;
	
	AddButton(IClient c, JComboBox b, JFrame f, String s){
		super("Add");
		this.client = c;
		this.type = s;
		this.list = b;
		this.frame = f;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//jtype is ether player
		if(this.type.equals("player")){
			//do something
			String selected = (String) list.getSelectedItem();
			System.out.println("The selected item in the player side is " + selected);
			temp = ((TradeWindow) frame).getPlayerArea();
			if(((TradeWindow) frame).checkAlreadyExist(temp,selected)){temp.append(selected + "\n");}
		} else if (this.type.equals("others")){
			//do something
			String selected = (String) list.getSelectedItem();
			System.out.println("The selected item in the others ide is " + selected);
			((TradeWindow) frame).updateCards(selected);
		} else if (this.type.equals("card")){
			//do something
		}
	}
}
