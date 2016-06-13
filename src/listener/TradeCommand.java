package listener;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import mainClient.*;
//import ClientListenerAdapter;

public class TradeCommand extends ClientListenerAdapter
{
	public static String COMMAND = "TRADE";
	public static String COMMAND2 = "DEAl";
	
	private TradeWindow frame;
	private JLabel label;
	
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			System.out.println("@tradeCommand the message is "+message);
			frame = new TradeWindow(message.substring(6), client);
		}
		/* else if (isCommand(message, COMMAND2)){
			System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000 @TRADECOMMAND");
			ICardLabel[][] temp = (frame).getHolders();
			label = frame.getLabel();
			message = message.substring(5);
			String[] todo = message.split("-");
			String[] todo1 = todo[0].split(" ");
			String[] todo2 = todo[1].split(" ");
			System.out.println("TTTTTTTTTTTTTTTTTTTTOOOOOOODDDDDDDDDDDDDDOOOOOOOOOOOOOOOs are "+  todo1 + " dumb " + todo2);
			for(ICardLabel[] c : temp)
				for(ICardLabel a : c)
					a.unSelect();
			for(String s : todo1){
				System.out.println("s is " + s);
				if(!s.equals("") && frame.hasCard(Integer.parseInt(s))){
					ICardLabel card = frame.getCardAt(Integer.parseInt(s));
					card.dealSelect(Color.GREEN);
				}
			}
			for(String s: todo2){
				System.out.println("s is " + s);
				if(!s.equals("")&&frame.hasCard(Integer.parseInt(s))){
					ICardLabel card = frame.getCardAt(Integer.parseInt(s));
					card.dealSelect(Color.BLUE);
				}
			}
			label.setText("Do you agree to the offer");
		}*/
	}
}