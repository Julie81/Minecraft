import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ErrorMess extends Frame implements WindowListener,ActionListener{
	int hauteur = 100;
	int longueur = 300;
	
	public ErrorMess(String mess) {
		super();
		this.setTitle(mess);
		JButton b = new JButton();
		b.setBackground(Color.lightGray);
		b.setVisible(true);
		b.setText("It seems the item you're trying to build only exists in your head... Sorry");
		b.addActionListener(this);
		this.add(b);
		this.addWindowListener(this);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public ErrorMess(ArrayList<Item> itemManquant) {
		super();
		this.setTitle("Not wealthy enough...");
		this.setVisible(true);
		this.addWindowListener(this);
		
		//Layout
		GridBagLayout gd = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gd);
		gbc.gridx = 1; // on met tout les items dans la meme colonne
		
		JButton b = new JButton();
		b.setPreferredSize(new Dimension(500, 100));
		b.setBackground(Color.lightGray);
		b.setVisible(true);
		b.addActionListener(this);
		String mess = "Action impossible : Les ressources suivantes ne sont pas en quantité suffisante.";
		b.setText(mess);
		gd.setConstraints(b, gbc);
		this.add(b);
		
		for(int i=0;i<itemManquant.size();i++){
			JButton p = new JButton();
			ImageIcon icon = new ImageIcon(itemManquant.get(i).path);
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance( 90, 90,  java.awt.Image.SCALE_SMOOTH ) ;
			icon = new ImageIcon(newimg);
			p.getActionCommand();
			p.addActionListener(this);
			p.setIcon(icon);
			p.setVisible(true);
			gd.setConstraints(p, gbc);
			this.add(p);
		}
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.dispose();
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		
	}
}
