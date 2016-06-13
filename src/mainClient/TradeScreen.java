package mainClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JTextArea;
import java.util.*;
/*
public class TradeScreen extends JFrame{

	private String all;
	private List<List<CardLabel>> list; 
	private IClient client;
	private JTextArea chat;
	private JPanel northPanel;
	private JPanel southpanel;
	private JButton trade;
	private JButton offer;
	private JButton accept;
	private JButton reject;
	private JLabel amount;
	private JLabel updater;
	private ICardLabel[][] placeHolders;
	
	public TradeScreen(String s, IClient cl){
		super("Trade here!");
		
		//close when [x] is pressed
		
		//how big should hte JFrame be?
		setSize(800, 800);
		
		//Do you want to be able to see the Frame?
		setVisible(true);
		
		//Do not allow window size to be changed
		setResizable(false);
		
		//Set the layout of this Frame
		setLayout(new BorderLayout());
		client = cl;
		
		list = new ArrayList<List<CardLabel>>();
		
		northPanel = new JPanel();
		updater = new JLabel();
		updater.setText("THIS IS JUST THE SAMPLE TEST\n THAT WILL ACCESS \nTHE SIZE OF\n THE AREA");
		northPanel.add(updater);

		
		
		southpanel = new JPanel();
		southpanel.setLayout((LayoutManager) new BoxLayout(southpanel, BoxLayout.X_AXIS));
		this.add(southpanel, BorderLayout.SOUTH);
		
		String id = "";
		String cardName = "";
		String cost = "";
		String rent = "";
		String[] colorName;
		String name= "";
		System.out.println("S in the trade screen is " + s);
		String[] todo = s.split("-");
		for(int i = 0; i < todo.length; i++) {
			todo[i] = todo[i].substring(1,todo[i].length()-1);
			String[] finaltodo = todo[i].split(",");
			 name = finaltodo[0];
			String money = finaltodo[1];
			int x = 2;
			int lineChanger = 0;
			
				while(x < finaltodo.length){
					System.out.println("IN while loop- ----------------------------- " + finaltodo[x]);
					if(lineChanger==0){
						list.add(new ArrayList<CardLabel>());
						id = finaltodo[x];
						lineChanger++;
					}
					else if(lineChanger==1){
						cardName = finaltodo[x];
						lineChanger++;
					}
					else if(lineChanger==2){
						cost = finaltodo[x];
						lineChanger++;
					}
					else if(lineChanger == 3){
						rent = finaltodo[x];
						lineChanger++;
					}
					else if(lineChanger == 4){
						colorName = finaltodo[x].split(" ");
						int a = Integer.parseInt(colorName[0]);
						int b = Integer.parseInt(colorName[1]);
						int c = Integer.parseInt(colorName[2]);
						list.get(i).add(new CardLabel(id,cardName,cost,rent, name,new Color(a,b,c)));
						lineChanger=0;
					}
				x++;
				}
//			while(list.get(i).size()<11){
//				list.get(i).add(new CardLabel("-1","","","","",null));
//			}
		}
		updater.setText("the guy's name has "+ client.getName());
		
		JPanel center = new JPanel();
		center.setLayout((LayoutManager) new GridLayout(10,4,2,2));
		this.add(new JScrollPane(center),BorderLayout.CENTER);
		placeHolders = new ICardLabel[10][4];
		
		for(int i  = 0; i < 10; i++){
			for(int j = 0; j < 4; j++){
				placeHolders[i][j] = new JButton("");
				center.add(placeHolders[i][j]);
			}
		} 
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 4; j++){
				if(j < list.size() && i < list.get(j).size()){
					placeHolders[i][j] = (list.get(j).get(i));
				}else {
					placeHolders[i][j] = new CardLabel("-1","","","","", Color.WHITE);
			//		placeHolders[i][j].setBackground(Color.BLUE);
				}
				center.add((Component) placeHolders[i][j]);
			}
		}
		center.update(getGraphics());
		center.repaint();
		center.validate();
		
		chat = new JTextArea();
		trade = new TradeButton(client,placeHolders, updater);
		offer = new OfferButton(client, placeHolders, updater);
		accept = new AcceptButton(client);
		reject = new RejectButton(client);
		amount = new JLabel("Amount:");
		amount.setText("Amount:");
		southpanel.add(amount);
		southpanel.add(chat);
		southpanel.add(trade);
		southpanel.add(offer);
		southpanel.add(accept);
		southpanel.add(reject);
	}
	
	public void setLabel(String s){
		updater.setText(s);
	}
	
	public ICardLabel[][] getHolders(){
		return this.placeHolders;
	}
	
	public JLabel getLabel(){
		return this.updater;
	}
	
	public boolean hasCard(int i){
		for(ICardLabel[] c : this.placeHolders)
			for(ICardLabel a : c)
				if(a.getId()==i)
					return true;
		return false;
	}
	
	public ICardLabel getCardAt(int i){
		for(ICardLabel[] c : this.placeHolders)
			for(ICardLabel a : c)
				if(a.getId()==i)
					return a;
		return null;
	}
}
*/