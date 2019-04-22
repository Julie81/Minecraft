import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Memoire_Vue extends Panel implements MouseListener{
	int larg=80;
	String n = null;
	//Item it = new Item(n);
	
	public Memoire_Vue (String name) {
		super();
		this.setPreferredSize(new Dimension(larg*3,larg*3+30));
		this.setBackground(new Color(139,108,66));
		Label titre = new Label (" Memoire : ");
		titre.setFont(new Font("Arial",Font.BOLD,18));
		titre.setForeground(Color.black);
		this.add(titre);
	}
	public Insets getInsets() {
		Insets normal = super.getInsets();
		return new Insets(normal.top+5, normal.left +10,
		normal.bottom, normal.right + 10);
		}
	
	public void paint (Graphics g){
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				g.drawRect(i*larg+10, j*larg+50, larg, larg);
			}
		}
	}

	@Override	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof Panel) {
			System.out.println("Item dont on veut afficher la recette");
		}
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
