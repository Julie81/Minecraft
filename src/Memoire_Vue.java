import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Memoire_Vue extends JPanel implements MouseListener,Observer{
	int larg=60;
	String n = null;
	Item it = new Item(n);
	
	public Memoire_Vue (String name) {
		super();
		this.n = name;
		Panel p = new Panel();
		p.addMouseListener(this);
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
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof Panel) {
			//appel controleur
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
	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
	
}
