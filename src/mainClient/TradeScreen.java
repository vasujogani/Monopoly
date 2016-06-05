package mainClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JTextArea;
import java.util.*;

public class TradeScreen extends JFrame{

	private String all;
	private List<List<CardLabel>> list; 
	
	public TradeScreen(String s){
		super("Trade here!");
		
		//close when [x] is pressed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//how big should hte JFrame be?
		setSize(800, 800);
		
		//Do you want to be able to see the Frame?
		setVisible(true);
		
		//Do not allow window size to be changed
		setResizable(false);
		
		//Set the layout of this Frame
		setLayout(new BorderLayout());
		
		list = new ArrayList<List<CardLabel>>();
		
		JPanel northPanel = new JPanel();
		this.add(northPanel,BorderLayout.NORTH);
		
		JPanel southpanel = new JPanel();
		southpanel.setLayout((LayoutManager) new BoxLayout(southpanel, BoxLayout.X_AXIS));
		this.add(southpanel, BorderLayout.SOUTH);
		
		JTextArea chat = new JTextArea();
		JButton trade = new JButton("Trade");
		JButton offer = new OfferButton();
		southpanel.add(chat);
		southpanel.add(trade);
		
		String id = "";
		String cardName = "";
		String cost = "";
		String rent = "";
		String[] colorName;
		System.out.println("S in the trade screen is " + s);
		String[] todo = s.split("-");
		for(int i = 0; i < todo.length; i++) {
			todo[i] = todo[i].substring(1,todo[i].length()-1);
			String[] finaltodo = todo[i].split(",");
			String name = finaltodo[0];
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
		
		JPanel center = new JPanel();
		center.setLayout((LayoutManager) new GridLayout(10,4));
		this.add(new JScrollPane(center),BorderLayout.CENTER);
		JButton[][] placeHolders = new JButton[10][4];
		
/*		for(int i  = 0; i < 10; i++){
			for(int j = 0; j < 4; j++){
				placeHolders[i][j] = new JButton("");
				center.add(placeHolders[i][j]);
			}
		} */
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 4; j++){
				if(j < list.size() && i < list.get(j).size()){
					placeHolders[i][j] = (list.get(j).get(i));
				}else {
					placeHolders[i][j] = new JButton("");
				}
				center.add(placeHolders[i][j]);
			}
		}
		center.update(getGraphics());
		center.repaint();
		center.validate();
	}
}
