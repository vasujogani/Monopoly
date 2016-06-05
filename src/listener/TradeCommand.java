package listener;
import mainClient.*;
//import ClientListenerAdapter;

public class TradeCommand extends ClientListenerAdapter
{
	public static String COMMAND = "TRADE";
	
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			System.out.println("@tradeCommand the message is "+message);
			new TradeScreen(message.substring(6));
		}
	}
	
}