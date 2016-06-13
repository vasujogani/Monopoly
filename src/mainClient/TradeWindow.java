package mainClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TradeWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel player;
	private JPanel others;
	private JPanel southPanel;
	private JPanel northPanel;
	private JComboBox<String> playerList;
	private JComboBox<String> othersList;
	private JComboBox<String> cardList;
	private DefaultComboBoxModel playerModel;
	private DefaultComboBoxModel othersModel;
	private JTextArea playerUpdate;
	private JTextArea othersUpdate;
	private JButton offer;
	private JButton accept;
	private JButton reject;
	private JButton playerAdd;
	private JButton othersAdd;
	private JButton cardAdd;
	private JTextField amount;
	private IClient client;
	private static String message;
	
	public TradeWindow(String s, IClient c){
		super("Trading Here");
		//initializing the screen...
		setSize(600, 300);
		
	//	setResizable(false);
		setLayout(new BorderLayout());
		
		//initializing the vars.
		message = s;
		client = c;
		fill(s);
		player = new JPanel();
		others = new JPanel();
		southPanel = new JPanel();
		northPanel = new JPanel();
		playerModel = new DefaultComboBoxModel();
		othersModel = new DefaultComboBoxModel();
//		playerList = new JComboBox();	//done when list made
//		othersList = new JComboBox();	//done when list made
//		cardList = new JComboBox();		//done when list made
		amount = new JTextField("Amount");
		playerUpdate = new JTextArea("");
		othersUpdate = new JTextArea("");
		offer = new OfferButton(client);
		accept = new AcceptButton(client);
		reject = new RejectButton(client);
		playerAdd = new AddButton(client, playerList, this, "player");
		othersAdd = new AddButton(client, othersList, this, "others");
		cardAdd = new AddButton(client, cardList, this, "card");
		
		
		//add stuff to the screen
		player.setPreferredSize(new Dimension(290, 290));
		player.setLayout((LayoutManager) new BoxLayout(player, BoxLayout.PAGE_AXIS));
		player.add(new JLabel(""+client.getName()));
		player.add(new JLabel("Select the card:"));
		player.add(playerList);
		player.add(playerAdd);
		player.add(new JLabel("Amount: pay(+)"));
		player.add(new JLabel("        recieve(-)"));
		player.add(amount);
		player.add(playerUpdate);
		playerUpdate.setBorder(new LineBorder(Color.BLACK));
		others.setPreferredSize(new Dimension(290,290));
		others.setLayout((LayoutManager) new BoxLayout(others, BoxLayout.Y_AXIS));
		others.add(new JLabel("Select the player"));
		others.add(othersList);
		others.add(othersAdd);
		others.add(new JLabel("Select the card"));
		others.add(cardList);
		others.add(cardAdd);
		others.add(othersUpdate);
		this.add(player, BorderLayout.WEST);
		this.add(others, BorderLayout.EAST);
	//	southPanel.add(playerUpdate);
	//	southPanel.add(othersUpdate);
	//	this.add(southPanel, BorderLayout.SOUTH);
		northPanel.setLayout((LayoutManager) new BoxLayout(northPanel, BoxLayout.X_AXIS));
		this.add(northPanel, BorderLayout.NORTH);
		northPanel.add(offer);
		northPanel.add(accept);
		northPanel.add(reject);
		System.out.println("made the trade window");
		setVisible(true);	
	}
	
	void fill(String s){
		String[] todo = s.split("-");
		String name = client.getName();
		String playerStr = "";
		String othersStr = "";
		for(int i  = 0; i < todo.length; i++){
			String[] todo2 = todo[i].split(",");
			System.out.println("-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0 the name is " + (todo2[0].substring(1))+ " -- " + name);
			if(todo2[0].substring(1).equals(name)){
				playerStr = todo[i];
			} else {
				othersStr += todo[i] + "-";
			}
		}
		updatePlayer(playerStr);
		updateOthers(othersStr);
	}
	void updatePlayer(String s){
		System.out.println("the player's string is " + s);
		s = s.substring(1, s.length()-1);
		String[] todo = s.split(",");
		String ret = "";
		String temp = "";
		ret += todo[1];
		int x = 2;
		int line = 0;
		int numb = (todo.length-2)/5;
		String[] list = new String[numb];
		while(x < todo.length){
			if(line == 0){
				String id = todo[x];
				line++;
			}else if(line == 1){
				temp += todo[x] + " - ";
				line++;
			}else if(line == 2 ){
				temp += "Cost: " + todo[x];
				line++;
			}else if(line ==3){
				temp += " Rent: " + todo[x];
				line++;
			}else if(line==4){
				System.out.println("Stuffed added to the list is " + temp);
				list[(x-2)/5] = temp;
				line = 0;
				numb++;
				temp = "";
			}
			x++;
		}
		for(int i = 0; i < list.length; i++)
			System.out.println("=++++++++++++++++++++++++++++++++++++++++++++++++++++ @tradeWindow the value in the list coammnad is " + list[i]);
		playerList = new JComboBox(list);
		setVisible(true);
	}
	
	void updateOthers(String s){
			if(!s.equals("")){
			System.out.println("the others string is " + s);
			String[] todo = s.split("-");
			String[] list = new String[todo.length];
			for(int i = 0; i < todo.length; i++){
				list[i] = todo[i].split(",")[0].substring(1);
			}
			othersList = new JComboBox(list);
			cardList = new JComboBox();
			setVisible(true);
		}else {
			othersList = new JComboBox();
			cardList = new JComboBox();
			setVisible(true);
		}
	}
	
	void updateCards(String name){
		System.out.println("@tradewindow int he update card");
		String todoString = this.message;
		String[] todo = todoString.split("-");
		for(int i = 0; i < todo.length; i++){
			if(name.equals(todo[i].split(",")[0].substring(1))){
				System.out.println("@tradeWindow the todo is " + todo[i]);
				String todoStr = todo[i].substring(1, todo[i].length()-1);
				String[] todo2 = todoStr.split(",");
				String temp = "";
				int x = 2;
				int line = 0;
				int numb = (todo2.length-2)/5;
				String[] list = new String[numb];
				while(x < todo2.length){
					if(line == 0){
						String id = todo2[x];
						line++;
					}else if(line == 1){
						temp += todo2[x] + " - ";
						line++;
					}else if(line == 2 ){
						temp += "Cost: " + todo2[x];
						line++;
					}else if(line ==3){
						temp += " Rent: " + todo2[x];
						line++;
					}else if(line==4){
						System.out.println("Stuffed added to the list is " + temp);
						list[(x-2)/5] = temp;
						cardList.addItem(temp);
						line = 0;
						numb++;
						temp = "";
					}
					x++;
				}
				break;
			}
		}
		System.out.
		println("I hate this");
		this.setVisible(true);
	}
	
	JTextArea getPlayerArea(){
		return this.playerUpdate;
	}
	
	JTextArea getCardArea(){
		return this.othersUpdate;
	}
	
	boolean checkAlreadyExist(JTextArea a, String s){
		if(a.getText().contains(s)){return false; }
		return true;
	}
	
}
