import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Recolte extends Panel {
	
	public Recolte() {
		JButton col_pierre = new JButton("pierre");
		col_pierre.setPreferredSize(new Dimension(80,30));
		col_pierre.setBackground(Color.GRAY);
		this.add(col_pierre);
		
		JButton col_bois = new JButton("bois");
		col_bois.setPreferredSize(new Dimension(70,30));
		col_bois.setBackground(Color.ORANGE);
		this.add(col_bois);

		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//quantite+=5;
	}
}
