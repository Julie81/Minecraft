import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Message_Memoire_Vue extends JPanel implements MouseListener {
	CardLayout cl;
	Memoire_Vue mv;
	
	public Message_Memoire_Vue () {
		
		this.cl =new CardLayout();
		
		// Message : Recherchez ici la recette d'un craft
		JPanel message = new JPanel();
		message.setBackground(new Color(0,0,0,0));
		JLabel message1=new JLabel("Recherchez ici ");
		JLabel message2 = new JLabel("la recette d'un craft ...");
		message1.setFont(new Font("Arial",Font.BOLD,36));
		message2.setFont(new Font("Arial",Font.BOLD,36));
		message1.setForeground(Color.white);
		message2.setForeground(Color.white);
		
		this.setBackground(new Color(107,87,49));
		Box box_texte = Box.createVerticalBox();
		box_texte.add(message1);
		box_texte.add(message2);
		message.add(box_texte);
		
		JPanel memoire = new JPanel();
		this.mv = new Memoire_Vue();
		memoire.add(this.mv);
		
		this.setLayout(cl);
		this.add(message,"texte");
		this.add(mv,"memoire");
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JPanel) {
			this.cl.last(this);
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