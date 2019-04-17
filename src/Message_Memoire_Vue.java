import java.awt.CardLayout;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Message_Memoire_Vue extends JPanel implements MouseListener {
	
	public Message_Memoire_Vue () {
		CardLayout cl =new CardLayout();
		JPanel message=new JPanel();
		Label message1=new Label("Recherchez ici la recette d'un craft ...");
		message.add(message1);
		
		JPanel memoire = new JPanel();
		Memoire_Vue mem = new Memoire_Vue(null);
		memoire.add(mem);
		
		this.setLayout(cl);
		//this.add(message,"texte");
		this.add(mem,"memoire");
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
