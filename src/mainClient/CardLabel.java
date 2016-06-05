package mainClient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CardLabel extends JButton implements ActionListener{
	private String name;
	private String cost;
	private String rent;
	private String owner;
	private int id;
	private Color color;
	private boolean selected;
	
	public CardLabel(String i, String n, String c, String r, String o, Color col){
//		super("<html>"+ n + "<br/ >"
//				+ c + "<br/ > " 
//				+ r + "<br/ > "
//				+ "owned by: " + o + " </html>");
		super("Card");
		this.name = n;
		this.cost = c;
		this.rent = r;
		this.owner = o;
		this.id = Integer.parseInt(i);
		this.color = col;
		addActionListener(this);
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(50,200));
		this.setLocation(10, 100*this.id);
		this.setBackground(color);
//		this.setText("<html>"+n+"<br />"+c+"<br />"+r+"<br /> owned by:"+o+"</html>");
		this.appendText("<html>"+n + "\n" + c + "\n " + r + "owned by: "+ o+"</html>");
//		this.setText("<html>"+n + "\n" + c + "\n " + r + "owned by: "+ o+"</html>");
/*		this.setText("<html>"+ n + "<br />"
				+ c + "<br /> " 
				+ r + "<br /> "
				+ "owned by: " + o + " </html>"); */ 
		this.setVisible(true);
		this.selected = false;
	}
	
	private void appendText(String string) {
		// TODO Auto-generated method stub
		String temp = this.getText();
		temp += "\n" + string;
		this.setText(temp);
	}

	public void select(){
		if(!selected){
			this.setBackground(Color.BLACK);
			this.selected = true;
		}else if(selected){
			selected = false;
			this.setBackground(this.color);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		this.select();
	}
	
	public int getSelectd(){
		return this.id;
	}
	
	public void unSelect(){
		this.setBackground(Color.WHITE);
	}
}
