package mainClient;

import java.awt.Color;
import java.awt.event.ActionEvent;

public interface ICardLabel {

		public void appendText(String string);

		public void select();
		
		public void actionPerformed(ActionEvent e);
		
		public boolean getSelectd();
		
		public int getId();
		
		public void unSelect();

//		public void setBackground(Color blue);
		
		public void dealSelect(Color c);
}
