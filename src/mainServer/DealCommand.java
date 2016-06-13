package mainServer;

import java.util.*;

class DealCommand extends NetworkListenerAdapter{
	
	public static String COMMAND = "OFFER";
	public static String COMMAND2 = "DEAL";
	private List<IPropertyCard> cards;
	
	public void process(String message, IPlayer player, IServer server){
		if(isCommand(message, COMMAND)){
			//when a player tries to offer something to other player, this will send a message to pop up an acceptance screen.
			player.send("OFFER ");
		}
	}	
}
