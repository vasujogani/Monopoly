package mainServer;

class TradeCommand extends NetworkListenerAdapter{
	
	public static String COMMAND = "TRADE";
	
	public void process(String message, IPlayer player, IServer server)
	{
		if(isCommand(message, COMMAND))
		{
			//do something
			String ret = "TRADE ";
			String colorName = "";
			IPlayer[] playerList = server.getClients();
			for(int i = 0; i < playerList.length; i++){
				ret +="["+playerList[i].getHandle()+","+playerList[i].getMoney();
				IPropertyCard[] cards = playerList[i].getCards();
				for(int j = 0; j < playerList[i].getCards().length; j++){
					colorName =  cards[j].getColor() + "";
					colorName = colorName.substring(17);
					System.out.println("@TradeCommand the value of the colorName is " + colorName);
					int a = Integer.parseInt(colorName.substring(0, colorName.indexOf("g")-1));
					colorName = colorName.substring(colorName.indexOf("g")+2);
					int b = Integer.parseInt(colorName.substring(0, colorName.indexOf("b")-1));
					colorName = colorName.substring(colorName.indexOf("b")+2, colorName.length()-1);
					int c = Integer.parseInt(colorName);
					ret+=","+cards[j].getId()+","+cards[j].getName()+","+cards[j].getCost()+","+cards[j].getRent()+","+a+" "+b+" "+c; 
				}
				ret+= "]-";
			}
			server.broadcast(ret);
		}	
	}
}