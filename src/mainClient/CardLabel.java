package mainClient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CardLabel extends JButton implements ActionListener, ICardLabel {
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
		super("");
		this.name = n;
		this.cost = c;
		this.rent = r;
		this.owner = o;
		this.id = Integer.parseInt(i);
		this.color = col;
		addActionListener(this);
		if(!n.equals("")){
			this.setOpaque(true);
			this.setPreferredSize(new Dimension(50,200));
			this.setLocation(10, 100*this.id);
			this.setBackground(color);
			this.setBorderPainted(true);
			this.setText(""+n + "\n" + c + "\n " + r + "owned by: "+ o+"");
		}else{
			this.setOpaque(true);
			this.setBackground(color);
			this.setBorderPainted(true);
			this.setText("");
		}
//		this.setText("<html>"+n+"<br />"+c+"<br />"+r+"<br /> owned by:"+o+"</html>");
//		this.appendText("<html>"+n + "\n" + c + "\n " + r + "owned by: "+ o+"</html>");
		
/*		this.setText("<html>"+ n + "<br />"
				+ c + "<br /> " 
				+ r + "<br /> "
				+ "owned by: " + o + " </html>"); */ 
		this.setVisible(true);
		this.selected = false;
	}
	
	public void appendText(String string) {
		// TODO Auto-generated method stub
		String temp = this.getText();
		temp += "\n" + string;
		this.setText(temp);
	}

	public void select(){
		if(!selected){
			this.setBackground(Color.BLACK);
			this.setBorderPainted(true);
			this.selected = true;
		}else if(selected){
			selected = false;
			this.setBorderPainted(true);
			this.setBackground(this.color);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		this.select();
	}
	
	public boolean getSelectd(){
		return this.selected;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void unSelect(){
		this.setBorderPainted(true);
		this.setBackground(this.color);
	}
	
	public void dealSelect(Color c){
		this.setBorderPainted(false);
		this.setBackground(c);
	}
}
