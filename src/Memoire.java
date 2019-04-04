import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Memoire extends Panel{
	int larg=80;
	String n = null;
	Item it= new Item(n);
	
	public Memoire (String name) {
		super();
		this.n=name;
		this.setPreferredSize(new Dimension(6*larg,4*larg));
		Panel p = new Panel();
		p.setBackground(Color.darkGray);
		p.setPreferredSize(new Dimension(larg,larg));
		p.getInsets();
		this.add(p);
		this.add(new Panel());
	}
	public Insets getInsets() {
		Insets normal = super.getInsets();
		return new Insets(normal.top+larg+5, normal.left + 3*larg+10,
		normal.bottom, normal.right + 10);
		}
	
	public void paint (Graphics g){
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				g.drawRect(i*larg+10, j*larg+10, larg, larg);
			}
		}
	}
	
}
