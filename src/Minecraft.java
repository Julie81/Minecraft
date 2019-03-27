import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Minecraft extends Frame implements WindowListener,ActionListener {
	
	JPanel content = new JPanel();
	CardLayout cl = new CardLayout();
	
	public static void main(String[] args) throws IOException {
		
		new Minecraft();

	}
	
	public Minecraft() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		
		Inventaire inv = new Inventaire();
	//	this.add(inv, BorderLayout.WEST);
		
		Recettes menu = new Recettes ();
		//this.add(menu, BorderLayout.WEST);
		
		
		content.setLayout(cl);
		content.add(inv,"inventaire");
		content.add(menu,"Menu");
		
		JPanel inv_rec = new JPanel();
		
		JButton inventaire = new JButton("inventaire");
		inventaire.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				cl.show(content, "inventaire");
			}
		});
		
		JButton recette = new JButton("recettes");
		recette.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				cl.show(content, "Menu");
			}
		});
		
		inv_rec.add(inventaire);
		inv_rec.add(recette);
		
		this.add(inv_rec,BorderLayout.WEST);
		this.add(content,BorderLayout.SOUTH);
		
		
		Recolte rec = new Recolte();
		this.add(rec,BorderLayout.EAST);
		
		this.addWindowListener(this);
		this.setTitle ("Table de craft Minecraft");
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
